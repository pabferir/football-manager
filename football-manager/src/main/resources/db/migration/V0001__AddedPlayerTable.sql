CREATE SEQUENCE IF NOT EXISTS player_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE player
(
    id                       BIGINT NOT NULL,
    first_name               VARCHAR(255),
    last_name                VARCHAR(255),
    date_of_birth            date,
    height                   DOUBLE PRECISION,
    nationality              VARCHAR(255),
    jersey_number            INTEGER,
    player_position          VARCHAR(255),
    market_value_in_millions DOUBLE PRECISION,
    CONSTRAINT pk_player PRIMARY KEY (id)
);