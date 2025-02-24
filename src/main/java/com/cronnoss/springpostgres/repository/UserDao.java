package com.cronnoss.springpostgres.repository;

import com.cronnoss.springpostgres.dto.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createUser(String username) {
        jdbcTemplate.update("INSERT INTO users (username) VALUES (?)", username);
    }

    public Optional<User> getUser(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?", userRowMapper, id).stream().findFirst();
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", userRowMapper);
    }

    public void deleteUser(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username"));
}
