package com.pasha.dev.dao;

import com.pasha.dev.filestats.FileStat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyMapper implements RowMapper<FileStat> {

    @Override
    public FileStat mapRow(ResultSet rs, int rowNum) throws SQLException {

        FileStat fileStat = new FileStat();
        fileStat.setName(rs.getString(1));
        fileStat.setCountLines(rs.getInt(2));
        fileStat.setAverageCountLines(rs.getDouble(3));
        fileStat.setMaxLengthWordsInFile(rs.getInt(4));
        fileStat.setMinLengthWordsInFile(rs.getInt(5));
        return fileStat;
    }

}
