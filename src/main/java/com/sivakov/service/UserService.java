package com.sivakov.service;

import com.sivakov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

/**
 * The type User service.
 */
@Service
@Validated
public class UserService extends CrudService<User, UUID, UserRepository> {

    @Autowired
    protected UserService(UserRepository repository) {
        super(repository);
    }

    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * Find by email and password user.
     *
     * @param email    the email
     * @param password the password
     * @return the user
     */
    public User findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    /**
     * Find by email and password and id user.
     *
     * @param email    the email
     * @param password the password
     * @param id       the id
     * @return the user
     */
    public User findByEmailAndPasswordAndId(String email, String password, UUID id) {
        return repository.findByEmailAndPasswordAndId(email, password, id);
    }

    /**
     * Find by email and id user.
     *
     * @param email the email
     * @param id    the id
     * @return the user
     */
    public User findByEmailAndId(String email, UUID id) {
        return repository.findByEmailAndId(email, id);
    }

    /**
     * Find by email and password and id not user.
     *
     * @param email    the email
     * @param password the password
     * @param id       the id
     * @return the user
     */
    public User findByEmailAndPasswordAndIdNot(String email, String password, UUID id) {
        return repository.findByEmailAndPasswordAndIdNot(email, password, id);
    }

    /**
     * Find by email and id not user.
     *
     * @param email the email
     * @param id    the id
     * @return the user
     */
    public User findByEmailAndIdNot(String email, UUID id) {
        return repository.findByEmailAndIdNot(email, id);
    }

    /**
     * Find by email and password and id not in user.
     *
     * @param email    the email
     * @param password the password
     * @param ids      the ids
     * @return the user
     */
    public User findByEmailAndPasswordAndIdNotIn(String email, String password, List<UUID> ids) {
        return repository.findByEmailAndPasswordAndIdNotIn(email, password, ids);
    }

}
