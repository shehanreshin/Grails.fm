package edu.personal.grailsfm.authservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(value = "role")
public class Role {
    @PrimaryKey
    private Integer id;
    private String name;
    private String description;
}
