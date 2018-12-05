package com.big.data.Service;

import com.big.data.Entity.User;
import com.big.data.HbaseConfig.HbaseConnect;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.hadoop.hbase.util.Bytes.toBytes;

@Service
public class UserService {

    private Connection connection = HbaseConnect.getInstance();
    private Table userTable;

    public Table getTable() {
        try {
            userTable = connection.getTable(TableName.valueOf("user"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userTable;
    }

    public List<User> findAll()
    {
        Scan scan = new Scan();
        // Getting the scan result
        ResultScanner scanner;
        List<User> users = new ArrayList<>();
        try {
            scanner = getTable().getScanner(scan);

            // Reading values from scan result
            for (Result result = scanner.next(); result != null; result = scanner.next()) {
                User user = new User();
                user.setId(Bytes.toString(result.getRow()));

                user.setEmail(Bytes.toString(result.getValue(Bytes.toBytes("professional data"), Bytes.toBytes("email"))));

                user.setDateNaissance(Bytes.toString(result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("birthday"))));
                user.setNom(Bytes.toString(result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("nom"))));
                user.setPrenom(Bytes.toString(result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("prenom"))));

                user.setLogin(Bytes.toString(result.getValue(Bytes.toBytes("auth data"), Bytes.toBytes("login"))));
                user.setPassword(Bytes.toString(result.getValue(Bytes.toBytes("auth data"), Bytes.toBytes("password"))));

                user.setProfil(Bytes.toString(result.getValue(Bytes.toBytes("professional data"), Bytes.toBytes("profil"))));
                users.add(user);
            }

            //closing the scanner
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;

    }

    public User save(User user){
        long id = findAll().size() + 1;
        user.setId(String.valueOf(id));
        Put newUser = new Put(Bytes.toBytes(user.getId()));

        if (user.getNom() != null)
            newUser.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("nom"), Bytes.toBytes(user.getNom()));

        if (user.getPrenom() != null)
            newUser.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("prenom"), Bytes.toBytes(user.getPrenom()));

        if (user.getDateNaissance() != null)
            newUser.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("birthday"), Bytes.toBytes(user.getDateNaissance()));

        if (user.getEmail() != null)
            newUser.addColumn(Bytes.toBytes("professional data"), Bytes.toBytes("email"), Bytes.toBytes(user.getEmail()));

        if (user.getProfil() != null)
            newUser.addColumn(Bytes.toBytes("professional data"), Bytes.toBytes("profil"), Bytes.toBytes(user.getProfil()));

        if (user.getLogin() != null)
            newUser.addColumn(Bytes.toBytes("auth data"), Bytes.toBytes("login"), Bytes.toBytes(user.getLogin()));

        if (user.getPassword() != null)
            newUser.addColumn(Bytes.toBytes("auth data"), Bytes.toBytes("password"), Bytes.toBytes(user.getPassword()));

        try {
            getTable().put(newUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Inserted !");

        return user;
    }

    //login
    public User findByLoginAndPwd(String login, String pwd) {
        Scan scan = new Scan();

        FilterList list = new FilterList(FilterList.Operator.MUST_PASS_ALL);
        SingleColumnValueFilter filter1 = new SingleColumnValueFilter(Bytes.toBytes("auth data"), Bytes.toBytes("login"), CompareFilter.CompareOp.EQUAL, Bytes.toBytes(login));
        list.addFilter(filter1);

        SingleColumnValueFilter filter2 = new SingleColumnValueFilter(Bytes.toBytes("auth data"), Bytes.toBytes("password"), CompareFilter.CompareOp.EQUAL, Bytes.toBytes(pwd));
        list.addFilter(filter2);
        scan.setFilter(list);
        // Getting the scan result
        ResultScanner scanner;
        User user = null;
        try {
            user = new User();
            scanner = getTable().getScanner(scan);
            // Reading values from scan result
            Result result = scanner.next();

            if (result == null)
                return null;

            user.setId(Bytes.toString(result.getRow()));

            user.setEmail(Bytes.toString(result.getValue(Bytes.toBytes("professional data"), Bytes.toBytes("email"))));

            user.setDateNaissance(Bytes.toString(result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("birthday"))));
            user.setNom(Bytes.toString(result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("nom"))));
            user.setPrenom(Bytes.toString(result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("prenom"))));

            user.setLogin(Bytes.toString(result.getValue(Bytes.toBytes("auth data"), Bytes.toBytes("login"))));
            user.setPassword(Bytes.toString(result.getValue(Bytes.toBytes("auth data"), Bytes.toBytes("password"))));

            user.setProfil(Bytes.toString(result.getValue(Bytes.toBytes("professional data"), Bytes.toBytes("profil"))));


            //closing the scanner
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void delete(String rowId) {
        Delete del = new Delete(toBytes(rowId));
        try {
            getTable().delete(del);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Deleted !");
    }

}
