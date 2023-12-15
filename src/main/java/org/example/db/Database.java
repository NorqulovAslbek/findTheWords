package org.example.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Database {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void crateTable() {
        String words = """
                CREATE TABLE IF NOT EXISTS words(
                id SERIAL PRIMARY KEY,
                word VARCHAR(50) NOT NULL,
                translate VARCHAR(50) NOT NULL,
                description TEXT NOT NULL
                );""";
        jdbcTemplate.execute(words);
    }
}
