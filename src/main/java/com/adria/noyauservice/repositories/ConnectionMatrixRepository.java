package com.adria.noyauservice.repositories;

import com.adria.noyauservice.entities.ConnectionMatrix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConnectionMatrixRepository extends JpaRepository<ConnectionMatrix, Long> {

    Optional<ConnectionMatrix> findConnectionMatrixByClientId(Long clientId);
}
