package org.ewkekw.spot.damas.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ewkekw.spot.damas.api.model.User;
import org.ewkekw.spot.damas.api.service.IUserService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User", description = "Operações relacionadas ao perfil do usuário")
@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Perfil do usuário", description = "Obtém o perfil do usuário por ID")
    @GetMapping("/{id}")
    public User getUserProfile(
            @Parameter(description = "ID do usuário") @PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
