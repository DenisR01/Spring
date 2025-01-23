package com.example.Vet.repository;

import com.example.Vet.model.VetRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRequestRepository extends JpaRepository<VetRequest,Long> {

}
