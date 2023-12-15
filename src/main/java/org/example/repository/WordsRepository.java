package org.example.repository;


import org.example.dto.Words;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean createWordsRepository(Words words) {
        String sql = "insert into words(word,translate,description) values ('%s','%s','%s')";
        sql = String.format(sql, words.getWord(), words.getTranslate(), words.getDescription());
        return jdbcTemplate.update(sql) != 0;
    }

    public List<Words> getWordsList() {
        String sql = "SELECT *FROM words";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Words.class));
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM words WHERE id=?";
        return jdbcTemplate.update(sql, id) != 0;
    }


}
