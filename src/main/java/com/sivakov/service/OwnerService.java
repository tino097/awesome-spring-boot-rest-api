package com.sivakov.service;

import com.sivakov.model.Owner;
import com.sivakov.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
public class OwnerService extends CrudService<Owner, UUID, OwnerRepository> {

    protected OwnerService(OwnerRepository repository) {
        super(repository);
    }
}
