package edu.personal.grailsfm.authservice.util.mapper.impl;

import edu.personal.grailsfm.authservice.dto.RoleResponseDto;
import edu.personal.grailsfm.authservice.entity.Role;
import edu.personal.grailsfm.authservice.util.mapper.RoleMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleResponseDto map(Class<RoleResponseDto> type, Role role) {
        return new RoleResponseDto(role.getName(), role.getDescription());
    }
}
