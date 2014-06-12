package com.dongyf.spring.dao;

import com.dongyf.spring.entity.Node;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dongyf on 2014/6/8.
 */

@Repository
public class TreeDaoImpl implements TreeDao {
    private JdbcTemplate jdbcTemplate;
    private static final String SELECT = "SELECT";
    private static final String FROM = "FROM";
    private static final String WHERE = "WHERE";
    private static final String AND = "AND";

    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Node> findChildren(String id) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT id,PARENT_ID,NODE_NAME,CHILDREN").append(" FROM wms.bas_tree t").append(" WHERE t.PARENT_ID=?");
        Object[] args = {id};
        List<Node> nodes  = jdbcTemplate.query(queryString.toString(), args, new RowMapper<Node>() {
            @Override
            public Node mapRow(ResultSet rs, int rowNum) throws SQLException {
                Node node = new Node();
                node.setId(rs.getLong("id"));
                node.setName(rs.getString("NODE_NAME"));

                return node;
            }
        });

        return nodes;
    }

    @Override
    public List<Node> getRoot() {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT id,PARENT_ID,NODE_NAME,CHILDREN").append(" FROM wms.bas_tree t").append(" WHERE t.PARENT_ID IS NULL");

        List<Node> nodes = jdbcTemplate.query(queryString.toString(), new RowMapper<Node>() {
            @Override
            public Node mapRow(ResultSet rs, int rowNum) throws SQLException {
                Node node = new Node();
                node.setName(rs.getString("NODE_NAME"));
                node.setId(rs.getLong("id"));
                return node;
            }
        });

        return nodes;
    }
    @Override
    public Node findNode(String id) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT id,PARENT_ID,NODE_NAME,CHILDREN").append(" FROM wms.bas_tree t").append(" WHERE t.id=?");
        Object[] args = {id};
        List<Node> nodes = jdbcTemplate.query(queryString.toString(), args, new RowMapper<Node>() {
            @Override
            public Node mapRow(ResultSet rs, int rowNum) throws SQLException {
                Node node = new Node();
                node.setName(rs.getString("NODE_NAME"));
                node.setId(rs.getLong("id"));
                return node;
            }
        });

        return nodes.get(0);
    }

}
