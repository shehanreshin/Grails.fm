CREATE SEQUENCE IF NOT EXISTS artist_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE artist
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255),
    email          VARCHAR(255),
    password       VARCHAR(255),
    contact_number VARCHAR(255),
    status         INTEGER,
    created_at     TIMESTAMP WITHOUT TIME ZONE,
    updated_at     TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_artist PRIMARY KEY (id)
);

ALTER TABLE artist
    ADD CONSTRAINT uc_artist_email UNIQUE (email);

ALTER TABLE artist
    ADD CONSTRAINT uc_artist_name UNIQUE (name);

INSERT INTO artist (id, name, email, password, contact_number, status, created_at, updated_at)
    VALUES (
            nextval('artist_sequence'),
            'Jim Halpert',
            'jh@dundermufflin.org',
            'cece123123',
            '0777200686',
            1,
            current_timestamp,
            current_timestamp
    );