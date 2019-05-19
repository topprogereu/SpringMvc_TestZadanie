package com.pasha.dev.dao;

import com.pasha.dev.filestats.FileStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class FileStatFuncImpl implements FileStatFunc {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void saveFileStat(FileStat file) {
        String sql_query = "INSERT INTO fileStat( file_name, count_line, avg_words_in_line, max_word_length, min_word_length) VALUES (?,?,?,?,?)" ;
          //jdbcTemplate.query(sql_query, file.getName(),file.getCountLines(),
                  //file.getAverageCountLines(),file.getMaxLengthWordsInFile(),file.getMinLengthWordsInFile());
    }

    @Override
    public String getInfoAboutFile(String name) {
        String sql_query = "";

        return null;
    }

    public void createTableInDb()
    {
        String sql_query = "CREATE TABLE IF NOT EXISTS fileStat( file_name varchar(50) primary key , count_line int, avg_words_in_line double, max_word_length int, min_word_length int)";
        //jdbcTemplate.update(sql_query);
    }


    

}
