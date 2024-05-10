package edu.personal.grailsfm.authservice.config;

import edu.personal.grailsfm.authservice.entity.Role;
import edu.personal.grailsfm.authservice.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleDataInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final List<Role> initialData = new ArrayList<>();

    public RoleDataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

        initialData.add(new Role("USER", "User description"));
        initialData.add(new Role("ARTIST", "Artist description"));
        initialData.add(new Role("ADMIN", "Admin description"));
    }

    @Override
    public void run(String... args) throws Exception {
        if (!isInitialDataExists()) addInitialData();
    }

    private boolean isInitialDataExists() {
        List<Role> roles = roleRepository.findAll().stream().sorted().toList();
        if (roles.isEmpty()) return false;
        return roles.equals(initialData.stream().sorted().toList());
    }

    private void addInitialData() {
        roleRepository.saveAll(initialData);
    }
}
