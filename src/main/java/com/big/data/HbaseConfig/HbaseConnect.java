package com.big.data.HbaseConfig;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class HbaseConnect {
    private static Connection connection;

    private HbaseConnect() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            Configuration configuration = HBaseConfiguration.create();
            try {
                return ConnectionFactory.createConnection(configuration);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void initTables() {
        try {
            Connection connection = getInstance();
            Admin admin = connection.getAdmin();

            //création de la table user
            TableName tableUser = TableName.valueOf("user");
            HTableDescriptor descU = new HTableDescriptor(tableUser);
            descU.addFamily(new HColumnDescriptor("professional data"));
            descU.addFamily(new HColumnDescriptor("personal data"));
            descU.addFamily(new HColumnDescriptor("auth data"));
            admin.createTable(descU);

            //création de la table comment
            TableName tableComment = TableName.valueOf("comment");
            HTableDescriptor descC = new HTableDescriptor(tableComment);
            descC.addFamily(new HColumnDescriptor("user data"));
            descC.addFamily(new HColumnDescriptor("post data"));
            descC.addFamily(new HColumnDescriptor("comment data"));
            admin.createTable(descC);

            //création de la table post
            TableName tableP = TableName.valueOf("post");
            HTableDescriptor descP = new HTableDescriptor(tableP);
            descP.addFamily(new HColumnDescriptor("meta data"));
            descP.addFamily(new HColumnDescriptor("body data"));
            admin.createTable(descP);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Tables created !");

    }
}
