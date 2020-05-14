package softlab.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softlab.test.task.entities.User;
import softlab.test.task.models.ApiErrorResponse;
import softlab.test.task.models.ApiResponse;
import softlab.test.task.models.LogInUser;
import softlab.test.task.services.UserService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/email={email}")
    public HttpEntity<ApiResponse<Boolean>> checkEmailUniqueness(@PathVariable(name = "email") String email) {


        Boolean isUserWithTheEmailExists = userService.checkEmailUniqueness(email);

        ApiResponse<Boolean> response = new ApiResponse<>(isUserWithTheEmailExists);
        HttpStatus status = HttpStatus.OK;

        if (!isUserWithTheEmailExists) {
            response = new ApiErrorResponse<>(false, "User with email: " + email + " already exists");
            status = HttpStatus.BAD_REQUEST;
        }

        response.add(linkTo(methodOn(UserController.class).checkEmailUniqueness(email)).withSelfRel());
        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/login={login}")
    public HttpEntity<ApiResponse<Boolean>> checkLoginUniqueness(@PathVariable(name = "login") String login) {


        Boolean isUserWithTheLoginExists = userService.checkLoginUniqueness(login);

        ApiResponse<Boolean> response = new ApiResponse<>(isUserWithTheLoginExists);
        HttpStatus status = HttpStatus.OK;

        if (!isUserWithTheLoginExists) {
            response = new ApiErrorResponse<>(false, "User with login: " + login + " already exists");
            status = HttpStatus.BAD_REQUEST;
        }

        response.add(linkTo(methodOn(UserController.class).checkLoginUniqueness(login)).withSelfRel());
        return new ResponseEntity<>(response, status);
    }



    @PutMapping("/sign-up")
    public HttpEntity<ApiResponse<User>> signUp(@RequestBody User user) {

        User savedUser = userService.signUp(user);

        ApiResponse<User> response = new ApiResponse<>(savedUser);

        if (null == savedUser) {
            response = new ApiErrorResponse<>(user, "Fields login and email must be unique and password must be not null");
        }

        response.add(linkTo(methodOn(UserController.class).signUp(user)).withSelfRel());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/log-in")
    public HttpEntity<ApiResponse<User>> logIn(@RequestBody LogInUser logInUser) {

        User user = userService.logIn(logInUser);

        ApiResponse<User> response = new ApiResponse<>(user);

        if (null == user) {
            User errorUser = new User(logInUser.getLogin(), logInUser.getPassword());
            response = new ApiErrorResponse<>(errorUser, "There is no user with login: " + logInUser.getLogin());
            response.add(linkTo(methodOn(UserController.class).logIn(logInUser)).withSelfRel());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        response.add(linkTo(methodOn(UserController.class).signUp(user)).withSelfRel());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}