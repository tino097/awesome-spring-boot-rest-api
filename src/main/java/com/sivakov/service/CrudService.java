package com.sivakov.service;

import com.sivakov.exception.ObjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudService<T, ID, R extends JpaRepository<T, ID>> {

    protected final R repository;

    protected CrudService(R repository) {
        this.repository = repository;
    }

    /**
     * Gets entity by id.
     *
     * @param id the id
     * @return the entity by id
     */
    public T getById(ID id) {
        Optional<T> entity = repository.findById(id);
        if (entity.isPresent())
            return entity.get();
        else
            throw new ObjectNotFoundException("PERMISSION_NOT_FOUND");
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        return repository.findAll();
    }

    /**
     * Save entity.
     *
     * @param entity to save
     * @return the entity
     */
    public T save(T entity) {
        return repository.save(entity);
    }

    /**
     * Delete entity by id.
     *
     * @param id entity's id
     */
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
