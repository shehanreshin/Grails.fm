package edu.personal.grailsfm.artistservice.entity;

import edu.personal.grailsfm.artistservice.util.enums.ArtistAccountStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@Document(collection = "artist")
public class Artist {
    @Id
    @Field(name = "id")
    private String id;

    @Indexed(unique = true)
    @Field(name = "name")
    private String name;

    @Indexed(unique = true)
    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;

    @Field(name = "contact_number")
    private String contactNumber;

    @Field(name = "status")
    private ArtistAccountStatus status;

    @Field(name = "role")
    private final String role = "ARTIST";

    @Field(name = "path_avatar")
    private String pathAvatar;

    @CreatedDate
    @Field(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Field(name = "updated_at")
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
