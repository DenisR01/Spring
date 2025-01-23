package com.example.Vet.service;

import com.example.Vet.DTO.VetReqDTO;
import com.example.Vet.DTO.vetReqRequestDTO;
import com.example.Vet.model.Client;
import com.example.Vet.model.Employee;
import com.example.Vet.model.VetRequest;
import com.example.Vet.repository.ClientRepository;
import com.example.Vet.repository.EmployeeRepository;
import com.example.Vet.repository.VetRequestRepository;
import com.example.Vet.state.VetRequestState;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VetRequestService {
    private final VetRequestRepository vetRequestRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    public VetRequestService(VetRequestRepository vetRequestRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.vetRequestRepository = vetRequestRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    public VetRequest findById(Long requestId){
        return vetRequestRepository.findById(requestId).orElseThrow(()->new IllegalArgumentException("Inexistent Req"));
    }
    public List<VetReqDTO> GetAllVetRequests(){
        var requests=vetRequestRepository.findAll();
        if(requests.isEmpty())
            return new ArrayList<>();
        return requests.stream().map(this::toVetReqDTO).toList();

    }

    public void updateState(Long orderId, VetRequestState requestState){
        var request=vetRequestRepository.findById(orderId).orElseThrow(()->new IllegalArgumentException("request not found"));
        requestState.handle(request);
        request.notifyObservers();
        vetRequestRepository.save(request);
    }
    @Transactional
    public VetRequest createVetRequest(vetReqRequestDTO vetReqRequestDTO) {
        Client client = clientRepository.findById(vetReqRequestDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client inexistent"));
        Employee employee = employeeRepository.findById(vetReqRequestDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Angajat inexistent"));

        VetRequest vetRequest = new VetRequest();
        vetRequest.setLocation(vetReqRequestDTO.getLocation());
        vetRequest.setDescriere(vetReqRequestDTO.getDescriere());
        vetRequest.setClient(client);
        vetRequest.setEmployee(employee);
        vetRequest.setState("inAnaliza"); // Setează o stare implicită

        return vetRequestRepository.save(vetRequest);
    }
    public VetReqDTO toVetReqDTO(VetRequest vetRequest){
        return new VetReqDTO(vetRequest.getId(),vetRequest.getLocation(),vetRequest.getDescriere(),vetRequest.getState(),vetRequest.getClient().getNume(),vetRequest.getEmployee().getName());
    }
}
