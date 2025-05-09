package com.api.ProjetoBD.DAOs;

import com.api.ProjetoBD.models.Secretaria;
import com.api.ProjetoBD.rowMappers.SecretariaRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SecretariaDAO {

    private final JdbcTemplate jdbcTemplate;

    public SecretariaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public int save(Secretaria sec) {
        String sql = "INSERT INTO Secretaria (matricula) VALUES (?)";
        return jdbcTemplate.update(sql, sec.getMatricula());
    }

    // READ ALL
    public List<Secretaria> findAll() {
        String sql = "SELECT * FROM Secretaria";
        return jdbcTemplate.query(sql, new SecretariaRowMapper());
    }

    // READ ONE
    public Secretaria findByMatricula(String matricula) {
        String sql = "SELECT * FROM Secretaria WHERE matricula = ?";
        return jdbcTemplate.queryForObject(sql, new SecretariaRowMapper(), matricula);
    }

    // DELETE
    public int deleteByMatricula(String matricula) {
        String sql = "DELETE FROM Secretaria WHERE matricula = ?";
        return jdbcTemplate.update(sql, matricula);
    }
}

