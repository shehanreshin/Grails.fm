package edu.personal.grailsfm.authservice.service.impl;

import edu.personal.grailsfm.authservice.dto.RoleResponseDto;
import edu.personal.grailsfm.authservice.entity.Role;
import edu.personal.grailsfm.authservice.repository.RoleRepository;
import edu.personal.grailsfm.authservice.service.RoleService;
import edu.personal.grailsfm.authservice.util.exception.role.InvalidRoleException;
import edu.personal.grailsfm.authservice.util.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleResponseDto findRoleByName(String name) {
        Optional<Role> role = roleRepository.findById(name);

        if (role.isEmpty()) {
            throw new InvalidRoleException();
        }

        return roleMapper.map(RoleResponseDto.class, role.get());
    }
}
