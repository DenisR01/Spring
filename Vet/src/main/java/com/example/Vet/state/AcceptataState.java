package com.example.Vet.state;

import com.example.Vet.model.VetRequest;

public class AcceptataState implements VetRequestState {
    @Override
    public String getState() {
        return "acceptata";
    }

    @Override
    public void handle(VetRequest vetRequest) {

    }
}
