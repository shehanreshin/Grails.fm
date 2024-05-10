package edu.personal.grailsfm.authservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(value = "role")
public class Role implements Comparable<Role> {
    @PrimaryKey
    @Column(value = "name")
    private String name;

    @Column(value = "description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Role o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            return this.description.compareTo(o.description);
        }
        return result;
    }
}
