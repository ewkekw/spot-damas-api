package org.ewkekw.spot.damas.api.controller;

import org.ewkekw.spot.damas.api.model.User;
import org.ewkekw.spot.damas.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User getUserProfile(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
