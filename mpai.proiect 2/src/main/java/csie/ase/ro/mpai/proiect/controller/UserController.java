package csie.ase.ro.mpai.proiect.controller;

import csie.ase.ro.mpai.proiect.proxy.UserServiceProxy;
import csie.ase.ro.mpai.proiect.response.ExamResponse;
import csie.ase.ro.mpai.proiect.response.UserResponse;
import csie.ase.ro.mpai.proiect.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceProxy userServiceProxy;
    private final UserService userService;
    private final RestTemplate restTemplate;

    @Autowired
    public UserController(UserServiceProxy userServiceProxy, UserService userService, RestTemplate restTemplate) {
        this.userServiceProxy = userServiceProxy;
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/{CNP}/check-user")
    public String authorizeUser(@PathVariable String CNP, Model model, HttpSession session) {
        ResponseEntity<Object> response = userServiceProxy.findByCnp(CNP);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() instanceof UserResponse user) {
            session.setAttribute("user", user);
            model.addAttribute("user", user);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<UserResponse> request = new HttpEntity<>(user, headers);

            ExamResponse examResponse = userService.getExamForUser(user.getId());

            if (examResponse != null){
                String responseStringUser =  userService.validateParticipation(user, examResponse);
                    model.addAttribute("error",responseStringUser);
                    return "index";
            } else {
                try {
                    ResponseEntity<ExamResponse> examResponseEntity = restTemplate.postForEntity("http://localhost:8080/exams/generate", request, ExamResponse.class);
                    if (examResponseEntity.getStatusCode().is2xxSuccessful()) {
                        return "redirect:/exams/view/" + examResponseEntity.getBody().getId();
                    } else {
                        model.addAttribute("error", "Failed to generate exam.");
                        return "index";
                    }
                } catch (Exception e) {
                    model.addAttribute("error", "Failed to generate exam: " + e.getMessage());
                    return "index";
                }
            }

        } else {
            model.addAttribute("error", "User not found or error in response.");
            return "index";
        }
    }
}
