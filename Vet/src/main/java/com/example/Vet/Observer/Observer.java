package com.example.Vet.Observer;

import com.example.Vet.model.VetRequest;

public interface Observer {
    void update(VetRequest vetRequest);
}
