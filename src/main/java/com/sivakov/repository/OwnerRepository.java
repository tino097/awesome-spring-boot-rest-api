package com.sivakov.repository;

import com.sivakov.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface OwnerRepository extends JpaRepository<Owner, UUID> {
}
