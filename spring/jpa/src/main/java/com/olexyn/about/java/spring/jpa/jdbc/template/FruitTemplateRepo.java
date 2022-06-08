package com.olexyn.about.java.spring.jpa.jdbc.template;

import com.olexyn.about.java.spring.jpa.model.FruitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FruitTemplateRepo {

    private final JdbcTemplate jdbcTemplate;

    public FruitTemplateRepo(@Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
    }

    private final FruitRowMapper fruitRowMapper = new FruitRowMapper();

    public FruitEntity save(FruitEntity entity) {
        jdbcTemplate.update(
            "INSERT INTO FruitEntity(pk,name,color) values(?,?,?)",
            entity.getPk(), entity.getName(), entity.getColor()
        );
        return entity;
    }

    public List<FruitEntity> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM fruit",
            (rs, rowNum) -> fruitRowMapper.mapRow(rs, rowNum)
        );
    }

    public FruitEntity getById(int id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM Student WHERE ID=?",
            (rs, rowNum) -> fruitRowMapper.mapRow(rs, rowNum),
            id
        );
    }

    public FruitEntity update(FruitEntity entity) {
        jdbcTemplate.update(
            "UPDATE Student SET name=?, color=? WHERE pk=?",
            entity.getName(), entity.getColor(), entity.getPk()
        );
        return entity;
    }

    public boolean deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Student WHERE ID=?", id);
        return true;
    }




    private class FruitRowMapper implements RowMapper<FruitEntity> {
        @Override
        public FruitEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            var entity = new FruitEntity();
            entity.setPk(rs.getLong("pk"));
            entity.setName(rs.getString("name"));
            entity.setColor(rs.getString("color"));
            return entity;
        }
    }

}
