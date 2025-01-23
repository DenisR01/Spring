package com.example.Vet.state;

import com.example.Vet.model.VetRequest;

public interface VetRequestState {
    String getState();
    void handle(VetRequest vetRequest);
}
