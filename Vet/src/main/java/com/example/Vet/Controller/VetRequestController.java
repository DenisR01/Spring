package com.example.Vet.Controller;

import com.example.Vet.DTO.vetReqRequestDTO;
import com.example.Vet.model.VetRequest;
import com.example.Vet.service.VetRequestService;
import com.example.Vet.state.AcceptataState;
import com.example.Vet.state.InAnalizaState;
import com.example.Vet.state.RespinsaState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/requests")
public class VetRequestController {
    public final VetRequestService vetRequestService;

    public VetRequestController(VetRequestService vetRequestService) {
        this.vetRequestService = vetRequestService;
    }

    @GetMapping
    public  String getAllRequests(Model model){
        var requests= vetRequestService.GetAllVetRequests();
        model.addAttribute("requests",requests);
        return "requests";
    }
    @GetMapping("/{id}/update")
    public String showUpdateRequestStateForm(@PathVariable Long id, Model model) {
        VetRequest request = vetRequestService.findById(id); // Găsește comanda (returnează direct Order, nu Optional)// Exemplu de gestionare a erorilor

        model.addAttribute("request", request); // Adaugă comanda în model
        return "updateRequestState.html"; //
    }
    @PostMapping("/{id}/state")
    public String updateRequestState(@PathVariable Long id, @RequestParam String newState, RedirectAttributes redirectAttributes){
        var request = vetRequestService.findById(id);
        var stateToSet = switch (newState) {
            case "acceptata" -> new AcceptataState();
            case "inAnaliza" -> new InAnalizaState();
            case "respinsa" -> new RespinsaState();
            default -> throw new IllegalArgumentException("Starea specificată nu este validă: " + newState);
        };
        vetRequestService.updateState(request.getId(),stateToSet);

        redirectAttributes.addFlashAttribute("succes",true);
        return "redirect:/requests";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("vetReqDTO", new vetReqRequestDTO());
        return "createRequest";
    }

    @PostMapping
    public String createRequest(@ModelAttribute vetReqRequestDTO vetReqDTO, RedirectAttributes redirectAttributes) {
        vetRequestService.createVetRequest(vetReqDTO);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/requests";
    }
}

