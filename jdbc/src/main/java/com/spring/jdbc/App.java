package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application started" );


        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

        // This will have all the fun to be performed for e.g. insert, delete....
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        //Sql query
        String query = "insert into student(id, name, city) values(?,?,?)";

        //fire query
        int record = template.update(query, 34, "Ayush Joshi", "Bhopal");

        System.out.println("Number of record inserted: "+record);

    }
}
