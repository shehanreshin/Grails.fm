    package edu.personal.grailsfm.songservice.entity;

    import lombok.Builder;
    import lombok.Getter;
    import lombok.Setter;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.index.Indexed;
    import org.springframework.data.mongodb.core.mapping.Document;
    import org.springframework.data.mongodb.core.mapping.Field;

    import java.util.Date;

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
        private Integer duration;

        @Field(name = "play_count")
        private Long playCount;

        @Field(name = "track_status")
        private TrackStatus status;

        @Field(name = "created_at")
        private Date createdAt;

        @Field(name = "updated_at")
        private Date updatedAt;
    }
