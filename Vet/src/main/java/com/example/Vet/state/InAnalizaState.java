package com.example.Vet.state;

import com.example.Vet.model.VetRequest;

public class InAnalizaState implements VetRequestState {
    @Override
    public String getState() {
        return "inAnaliza";
    }

    @Override
    public void handle(VetRequest vetRequest) {
        vetRequest.setState(new InAnalizaState().getState());
        vetRequest.notifyObservers();
    }
}
