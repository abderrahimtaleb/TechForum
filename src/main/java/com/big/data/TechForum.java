package com.big.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechForum {

    public static void main(String args[])
    {
        //HbaseConnect.getInstance();
        //HbaseConnect.initTables(); //first run -> create tables ; otherwise comment this line
        SpringApplication.run(TechForum.class, args);
    }
}
