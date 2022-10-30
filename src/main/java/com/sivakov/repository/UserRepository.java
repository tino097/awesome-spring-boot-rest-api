package com.sivakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivakov.model.User;

import java.util.List;
import java.util.UUID;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    User findByEmail(String email);

    /**
     * Find by email and password user.
     *
     * @param email    the email
     * @param password the password
     * @return the user
     */
    User findByEmailAndPassword(String email, String password);

    /**
     * Find by email and password and id user.
     *
     * @param email    the email
     * @param password the password
     * @param id       the id
     * @return the user
     */
    User findByEmailAndPasswordAndId(String email, String password, UUID id);

    /**
     * Find by email and id user.
     *
     * @param email the email
     * @param id    the id
     * @return the user
     */
    User findByEmailAndId(String email, UUID id);

    /**
     * Find by email and password and id not user.
     *
     * @param email    the email
     * @param password the password
     * @param id       the id
     * @return the user
     */
    User findByEmailAndPasswordAndIdNot(String email, String password, UUID id);

    /**
     * Find by email and id not user.
     *
     * @param email the email
     * @param id    the id
     * @return the user
     */
    User findByEmailAndIdNot(String email, UUID id);

    /**
     * Find by email and password and id not in user.
     *
     * @param email    the email
     * @param password the password
     * @param ids      the ids
     * @return the user
     */
    User findByEmailAndPasswordAndIdNotIn(String email, String password, List<UUID> ids);

    /**
     * Find by email and id not in user.
     *
     * @param email the email
     * @param ids   the ids
     * @return the user
     */
    User findByEmailAndIdNotIn(String email, List<UUID> ids);

    /**
     * Find by email and password and id in user.
     *
     * @param email    the email
     * @param password the password
     *