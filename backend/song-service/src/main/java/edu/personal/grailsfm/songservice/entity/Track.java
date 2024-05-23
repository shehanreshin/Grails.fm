    package edu.personal.grailsfm.songservice.entity;

    import edu.personal.grailsfm.songservice.util.enums.TrackStatus;
    import lombok.Builder;
    import lombok.Getter;
    import lombok.Setter;
    import org.springframework.data.annotation.CreatedDate;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.annotation.LastModifiedDate;
    import org.springframework.data.mongodb.core.index.Indexed;
    import org.springframework.data.mongodb.core.mapping.Document;
    import org.springframework.data.mongodb.core.mapping.Field;
    import org.springframework.data.mongodb.core.mapping.FieldType;
    import org.springframework.data.mongodb.core.mapping.MongoId;

    import java.util.Date;
    import java.util.List;
    import java.util.Objects;

    @Setter
    @Getter
    @Builder
    @Document(collection = "track")
    public class Track {
        @Id
        private String id;

        @Field(name = "title")
        private String title;

        @Indexed
        @Field(name = "artist_id")
        private String artistId;

        @Field(name = "artist_name")
        private String artistName;

        @Field(name = "description")
        private String description;

        @Field(name = "duration")
        private Float duration;

        @Field(name = "genres")
        private List<String> genres;

        @Field(name = "play_count")
        private Long playCount;

        @Field(name = "uri")
        private String uri;

        @Field(name = "status")
        private TrackStatus status;

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
            Track track = (Track) o;
            return Objects.equals(id, track.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
