package edu.personal.grailsfm.authservice.controller;

import edu.personal.grailsfm.authservice.dto.RoleResponseDto;
import edu.personal.grailsfm.authservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("v1/roles")
@RestController
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/{name}")
    public ResponseEntity<RoleResponseDto> findRoleByName(@PathVariable String name) {
        return ResponseEntity.ok(roleService.findRoleByName(name));
    }
}
