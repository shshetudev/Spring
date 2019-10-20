package com.shetu.multipledboperation_jackrutorial.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Transactional
@Repository
public class UserDaoImpl {
    /*
    * Inject 2 templates
    * */
    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;
    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate12;

    //methods
    public List getAllUser(){ //fields: id,username,email
        String sql1 = "select username,email form user1";
        //get users list form db1
        List list1 = jdbcTemplate1.query(sql1,new UserRowMapper());

        String sql2 = "select username,email from user2";
        //get users list form db2
        List list2 = jdbcTemplate12.query(sql2,new UserRowMapper());

        List listAll = (List) Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
        return listAll;
    }

}


