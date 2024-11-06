CREATE TABLE Athlete(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    height DECIMAL(5,2) NOT NULL,
    age INT NOT NULL,
    nationality TEXT NOT NULL,
    team_id TEXT,

    FOREIGN KEY (team_id) REFERENCES team (id)
    ON DELETE SET NULL ON UPDATE CASCADE
);