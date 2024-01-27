

-- Table for storing all sounds
CREATE TABLE IF NOT EXISTS sounds (
  id VARCHAR(36) PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  bpm INTEGER NOT NULL,
  duration_in_seconds INTEGER NOT NULL
);

-- Genres
CREATE TABLE IF NOT EXISTS genres (
  id VARCHAR(36)  PRIMARY KEY,
  sound_id VARCHAR(36) NOT NULL,
  genre VARCHAR(36) NOT NULL,

  FOREIGN KEY (sound_id) REFERENCES sounds(id),
  CONSTRAINT uc_genres UNIQUE (sound_id, genre)
);

-- Table for collecting sounds in playlists
CREATE TABLE IF NOT EXISTS  playlists (
  id VARCHAR(36)  PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  sound_id VARCHAR(36) NOT NULL,

  FOREIGN KEY (sound_id) REFERENCES sounds(id),
  CONSTRAINT uc_playlists UNIQUE (id, sound_id)

);

-- Credits (mapping sounds to artists)
CREATE TABLE IF NOT EXISTS credits (
  id VARCHAR(36)  PRIMARY KEY,
  sound_id VARCHAR(36) NOT NULL,
  name VARCHAR(36) NOT NULL,
  role VARCHAR(255) NOT NULL,

  FOREIGN KEY (sound_id) REFERENCES sounds(id),
  CONSTRAINT uc_credits UNIQUE (sound_id, name, role)
);





