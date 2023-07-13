package lab.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lab.app.entities.User;
import lab.app.service.abstractions.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/save")
    @Operation(summary = "save user", description = "save user in db")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete user", description = "delete user from db")
    public ResponseEntity<Void> deleteUserById(@PathVariable long id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update user", description = "update user in db")
    public User updateUser(@PathVariable long id, @RequestBody User user){
        return userService.update(id, user);
    }

    @GetMapping("/getAll")
    @Operation(summary = "get all users", description = "get all users from db")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "get user by id", description = "get user by id from db")
    public User getById(@PathVariable long id){
        return userService.getById(id);
    }
}
