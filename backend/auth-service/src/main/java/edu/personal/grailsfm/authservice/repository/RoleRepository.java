package edu.personal.grailsfm.authservice.repository;

import edu.personal.grailsfm.authservice.entity.Role;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface RoleRepository extends CassandraRepository<Role, Integer> {
}
