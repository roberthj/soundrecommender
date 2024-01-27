

-- Table for storing all sounds
CREATE TABLE IF NOT EXISTS sounds (
  id VARCHAR(36) PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  bpm INTEGER NOT NULL,
  duration_in_seconds INTEGER NOT NULL
);

-- Genres
CREATE TABLE IF NOT EXISTS genres (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,

  CONSTRAINT uc_genres UNIQUE (id, name)
);

-- Mapping sounds to genres
CREATE TABLE IF NOT EXISTS sound_genres (
  sound_id VARCHAR(36) NOT NULL,
  genre_id VARCHAR(36) NOT NULL,

  FOREIGN KEY (sound_id) REFERENCES sounds(id),
  FOREIGN KEY (genre_id) REFERENCES genres(id),
  CONSTRAINT uc_sound_genres UNIQUE (sound_id, genre_id)
);

-- Table for collecting sounds in playlists
CREATE TABLE IF NOT EXISTS  playlists (
  id VARCHAR(36)  PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  sound_id VARCHAR(36) NOT NULL,

  FOREIGN KEY (sound_id) REFERENCES sounds(id),
  CONSTRAINT uc_playlists UNIQUE (id, sound_id)

);

-- Artists
CREATE TABLE IF NOT EXISTS artists (
  id VARCHAR(36)  PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

-- Credits (mapping sounds to artists)
CREATE TABLE IF NOT EXISTS credits (
  sound_id VARCHAR(36) NOT NULL,
  artist_id VARCHAR(36) NOT NULL,
  role VARCHAR(255) NOT NULL,

  FOREIGN KEY (sound_id) REFERENCES sounds(id),
  FOREIGN KEY (artist_id) REFERENCES artists(id),
  CONSTRAINT uc_credits UNIQUE (sound_id, artist_id, role)
);





