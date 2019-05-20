package com.pasha.dev.dao;

import com.pasha.dev.myfile.FileStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class FileWorkDaoImpl implements FileWorkDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveFileStat(FileStat fileStat) {
        String sql_query = "INSERT INTO UPLOADED_FILE_STAT( name_of_file, count_lines, " +
                "avg_count_words, max_length_words_in_file, min_length_words_in_file) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql_query, fileStat.getName(),fileStat.getCountLines(),
                  fileStat.getAverageCountLines(),fileStat.getMaxLengthWordsInFile(),fileStat.getMinLengthWordsInFile());
    }

    @Override
    public List<FileStat> getInfoAboutFile(String name) {
        String sql_query = "SELECT * FROM UPLOADED_FILE_STAT WHERE name_of_file = ?";
        return jdbcTemplate.query(sql_query, new MyMapper(),name);
    }

    @Override
    public List<FileStat> getAllFiles() {
        String sql_query = "SELECT * FROM UPLOADED_FILE_STAT";
        return jdbcTemplate.query(sql_query, new MyMapper());
    }

    @PostConstruct
    public void init()
    {
            String sql_query = "CREATE TABLE IF NOT EXISTS UPLOADED_FILE_STAT" +
                    "( name_of_file varchar(50) primary key , count_lines int, avg_count_words double, max_length_words_in_file int, min_length_words_in_file int)";
            jdbcTemplate.update(sql_query);
    }






    

}
