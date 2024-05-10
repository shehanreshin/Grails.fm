package edu.personal.grailsfm.authservice.service;

import edu.personal.grailsfm.authservice.dto.RoleResponseDto;

public interface RoleService {
    RoleResponseDto findRoleByName(String name);
}
