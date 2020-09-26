package com.olexyn.about.java.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class PrettyPrint {




    public Map<Integer, String> resultSetToMap(ResultSet rs) throws SQLException {

        Map<Integer, String> idToNameMap = new HashMap<>();

        while (rs.next()) {
            int id = rs.getInt("customer_id");
            String name = rs.getString("name");
            idToNameMap.put(id, name);
        }

        return idToNameMap;
    }


    public String mapToString(Map<Integer, String> map) {

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            sb.append(" | ");
            sb.append(entry.getKey().toString());
            sb.append(" | ");
            sb.append(entry.getValue());
            sb.append(" |\n");
        }

        return sb.toString();

    }


    public void printResult(ResultSet rs) throws SQLException {
        String string = mapToString(resultSetToMap(rs));
        System.out.println(string);
    }


    public void universalHandler(Statement stmt) throws SQLException {
        boolean isResultSet = stmt.execute("sql");
        if (isResultSet) {
            ResultSet rs = stmt.getResultSet();
            System.out.println("ran a query");
        } else {
            int result = stmt.getUpdateCount();
            System.out.println("ran an update");
        }
    }

}
