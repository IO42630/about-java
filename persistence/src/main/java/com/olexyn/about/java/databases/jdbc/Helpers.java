package com.olexyn.about.java.databases.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class TableDto{

    private List<List<String>> table = null;

    private TableDto(){}

    TableDto(List<List<String>> input){
        this.table = input;
    }

    public List<List<String>> getTable() {
        return table;
    }
}


public class Helpers {

    public String getResult(ResultSet rs) throws SQLException {

        return tableToString(resultSetToTable(rs));
    }

    /**
     */
    public TableDto resultSetToTable(ResultSet rs) throws SQLException {

        List<List<String>> result = new ArrayList<>();

        ResultSetMetaData rsMd = rs.getMetaData();
        int columnsNumber = rsMd.getColumnCount();

        List<String> header = new ArrayList<>();
        for (int i = 1; i <= columnsNumber; i++) {
            header.add(rsMd.getColumnName(i));
        }
        result.add(header);

        while (rs.next()) {

            List<String> values = new ArrayList<>();
            for (int i = 1; i <= columnsNumber; i++) {
                values.add(rs.getString(i));
            }
            result.add(values);
        }

        return new TableDto( result        );
    }

    /**
     */
    public String tableToString(TableDto input) {

        List<List<String>> table = input.getTable();

        int nrOfCols = table.get(0).size();
        int[] maxCellLengths = new int[nrOfCols];

        for (List<String> strings : table) {
            for (int columnNr = 0; columnNr < nrOfCols; columnNr++) {
                String cell = strings.get(columnNr);
                if (cell.length() > maxCellLengths[columnNr]) {
                    maxCellLengths[columnNr] = cell.length();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<String> row : table) {
            sb.append(" | ");
            for (int columnNr=0;columnNr<row.size();columnNr++){
                String cell = row.get(columnNr);
                sb.append(cell);
                sb.append(" ".repeat(Math.max(0, maxCellLengths[columnNr] - cell.length())));
                sb.append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     */
    public void printResult(ResultSet rs) throws SQLException {
        System.out.println(getResult(rs));
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
