package com.example.ShoeSellin.Repository;

import com.example.ShoeSellin.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByName(String name);
}
