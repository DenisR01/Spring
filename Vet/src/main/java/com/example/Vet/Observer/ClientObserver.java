package com.example.Vet.Observer;

import com.example.Vet.model.VetRequest;

public class ClientObserver implements Observer{

    @Override
    public void update(VetRequest vetRequest) {
        System.out.println("Comanda cu ID: " + vetRequest.getId() + " a trecut la starea: " + vetRequest.getState());
    }
}
