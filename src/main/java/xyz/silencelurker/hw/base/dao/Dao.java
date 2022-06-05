package xyz.silencelurker.hw.base.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <p>
 * 连接类
 * </p>
 * 
 * @author Silence_Lurker
 */
public class Dao {
    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_company?useSSL=false", "root",
                    "d88vAnnX");
        } catch (Exception e) {
            System.out.println("Connection Error!");
        }

        return con;
    }
}
