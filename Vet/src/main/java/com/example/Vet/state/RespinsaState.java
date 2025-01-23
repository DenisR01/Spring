package com.example.Vet.state;

import com.example.Vet.model.VetRequest;

public class RespinsaState implements VetRequestState {
    @Override
    public String getState() {
        return "respinsa";
    }

    @Override
    public void handle(VetRequest vetRequest) {

    }
}
