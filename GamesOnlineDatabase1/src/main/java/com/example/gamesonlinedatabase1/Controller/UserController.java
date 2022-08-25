package com.example.gamesonlinedatabase1.Controller;

import com.example.gamesonlinedatabase1.Modle.User;
import com.example.gamesonlinedatabase1.Service.UserService;
import com.example.gamesonlinedatabase1.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Api/v1/use")
public class UserController {

    private final UserService userService;


    @GetMapping("/user")
    public ResponseEntity getUser() {

        return ResponseEntity.status(200).body(new ApiResponse("Welcome User", 200));
    }

    @PostMapping("/Register")
    public ResponseEntity Register(@RequestBody @Valid User user) {
        userService.Register(user);
        return ResponseEntity.status(200).body(new ApiResponse("New user added !", 200));
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login() {
        return ResponseEntity.status(200).body(new ApiResponse("Welcome back !", 200));

    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
        userService.DeleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted , Good bye !", 200));
    }

    @PutMapping("/up/{id}")
    public ResponseEntity<ApiResponse> UpdateUser(@RequestBody @Valid User user, @PathVariable Integer id) {
        userService.UpdateUser(user, id);
        return ResponseEntity.status(200).body(new ApiResponse("User Updated", 200));
    }

    @GetMapping("/guest")
    public ResponseEntity getGuest() {
        return ResponseEntity.status(200).body(new ApiResponse("Welcome Guest", 200));
    }


}