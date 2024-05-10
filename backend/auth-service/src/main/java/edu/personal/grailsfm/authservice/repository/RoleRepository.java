package edu.personal.grailsfm.authservice.repository;

import edu.personal.grailsfm.authservice.entity.Role;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CassandraRepository<Role, String> {
}
