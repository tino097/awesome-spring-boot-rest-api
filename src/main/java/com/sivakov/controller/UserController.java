package com.sivakov.controller;

import com.sivakov.exception.UserException;
import com.sivakov.model.User;
import com.sivakov.model.ErrorResponse;
import com.sivakov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
* The type User controller.
*
* @author Tino097
*/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Gets user.
     *
     * @return the user
     */
    
    @GetMapping
    public List<User> getUser() {
        return userService.getAll();
    }

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody @Valid User user) {
        user.setId(UUID.randomUUID());
        return userService.save(user);
    }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    /**
     * Edit user user.
     *
     * @param user the user
     * @param id   the id
     * @return the user
     */
    @PutMapping("/{id}")
    public User editUser(@RequestBody User user, @PathVariable UUID id) {
        return userService.editUser(user, id);
    }

    /**
     * Delete user.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

    /**
     * Gets user by email.
     *
     * @param email the email
     * @return the user by email
     */
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    /**
	 * Handle u exception error response.
	 *
	 * @param e the e
	 * @return the error response
	 */
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUException(UserNotFoundException e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }


}