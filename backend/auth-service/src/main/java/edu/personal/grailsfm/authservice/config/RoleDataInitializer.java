package edu.personal.grailsfm.authservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.personal.grailsfm.authservice.entity.Role;
import edu.personal.grailsfm.authservice.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RoleDataInitializer implements CommandLineRunner {
    private final ObjectMapper mapper;
    private final RoleRepository roleRepository;
    private final List<RoleData> initialData = new ArrayList<>();

    public RoleDataInitializer(ObjectMapper mapper, RoleRepository roleRepository) {
        this.mapper = mapper;
        this.roleRepository = roleRepository;

        initialData.add(new RoleData("User", "User description"));
        initialData.add(new RoleData("Artist", "Artist description"));
        initialData.add(new RoleData("Admin", "Admin description"));
    }

    @Override
    public void run(String... args) throws Exception {
        if (!isInitialDataExists()) addInitialData();
    }

    private boolean isInitialDataExists() {
        return false;
    }

    private void addInitialData() {
        Iterable<Role> roles = initialData.stream()
                .map(roleData -> new Role(UUID.randomUUID(), roleData.name, roleData.description))
                .toList();

        roleRepository.saveAll(roles);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static final class RoleData {
        private String name;
        private String description;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RoleData roleData = (RoleData) o;
            return Objects.equals(name, roleData.name) && Objects.equals(description, roleData.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, description);
        }
    }
}
