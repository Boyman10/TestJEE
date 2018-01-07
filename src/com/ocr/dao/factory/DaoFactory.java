package com.ocr.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ocr.dao.UserDao;
import com.ocr.dao.UserDaoImpl;

public class DaoFactory {
	
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/test", "test", "1234");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connexion = DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);
        return connexion; 
    }

    // Récupération du Dao
    public UserDao getUserDao() {
        return new UserDaoImpl(this);
    }
}