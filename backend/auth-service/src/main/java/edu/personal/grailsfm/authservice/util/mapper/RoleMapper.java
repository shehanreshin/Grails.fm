package edu.personal.grailsfm.authservice.util.mapper;

import edu.personal.grailsfm.authservice.dto.RoleResponseDto;
import edu.personal.grailsfm.authservice.entity.Role;

public interface RoleMapper {
    RoleResponseDto map(Class<RoleResponseDto> type, Role role);
}
