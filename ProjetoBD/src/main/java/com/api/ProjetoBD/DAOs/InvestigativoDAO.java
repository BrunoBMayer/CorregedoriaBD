package com.api.ProjetoBD.DAOs;

import com.api.ProjetoBD.models.Investigativo;
import com.api.ProjetoBD.rowMappers.InvestigativoRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvestigativoDAO {

    private final JdbcTemplate jdbcTemplate;

    public InvestigativoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public int save(Investigativo inv) {
        String sql = "INSERT INTO Investigativo (matricula) VALUES (?)";
        return jdbcTemplate.update(sql, inv.getMatricula());
    }

    // READ ALL
    public List<Investigativo> findAll() {
        String sql = "SELECT * FROM Investigativo";
        return jdbcTemplate.query(sql, new InvestigativoRowMapper());
    }

    // READ ONE
    public Investigativo findByMatricula(String matricula) {
        String sql = "SELECT * FROM Investigativo WHERE matricula = ?";
        return jdbcTemplate.queryForObject(sql, new InvestigativoRowMapper(), matricula);
    }

    // DELETE
    public int deleteByMatricula(String matricula) {
        String sql = "DELETE FROM Investigativo WHERE matricula = ?";
        return jdbcTemplate.update(sql, matricula);
    }
}

