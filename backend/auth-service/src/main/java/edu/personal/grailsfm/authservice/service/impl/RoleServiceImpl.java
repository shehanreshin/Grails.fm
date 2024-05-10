package edu.personal.grailsfm.authservice.service.impl;

import edu.personal.grailsfm.authservice.dto.RoleResponseDto;
import edu.personal.grailsfm.authservice.repository.RoleRepository;
import edu.personal.grailsfm.authservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public RoleResponseDto findRoleByName(String name) {
        return null;
    }
}
