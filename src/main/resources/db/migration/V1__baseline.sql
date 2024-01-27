
-- Sound categories
CREATE TABLE IF NOT EXISTS categories (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,

  CONSTRAINT uc_categories UNIQUE (id, name)
);

-- Table for storing all sounds
CREATE TABLE IF NOT EXISTS sounds (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  categoryId VARCHAR(255) NOT NULL,

  FOREIGN KEY (categoryId) REFERENCES categories(id),
  CONSTRAINT uc_sounds UNIQUE (id, name, categoryId)
);

-- Table for collecting sounds in playlists
CREATE TABLE IF NOT EXISTS  playlists (
  id VARCHAR(36)  PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  sound_id VARCHAR(36) NOT NULL,

  FOREIGN KEY (sound_id) REFERENCES sounds(id),
  CONSTRAINT uc_playlists UNIQUE (id, sound_id)

);

-- Tags for explaining the sounds
CREATE TABLE IF NOT EXISTS sound_tags (
  sound_id VARCHAR(36) NOT NULL,
  tag VARCHAR(255) NOT NULL,

    FOREIGN KEY (sound_id) REFERENCES sounds(id),
    CONSTRAINT uc_sound_tags UNIQUE (sound_id, tag)
);





