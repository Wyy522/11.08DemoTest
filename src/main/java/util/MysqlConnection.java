package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnection {
    private static MysqlConnection connectionUtil = new MysqlConnection();

    public static Connection connection;

    private MysqlConnection() {

    }

    public static MysqlConnection getInstance() {
        if (connectionUtil == null) {
            synchronized (MysqlConnection.class) {
                if (connectionUtil == null) {
                    connectionUtil = new MysqlConnection();
                }
            }
        }
        return connectionUtil;
    }


    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //从配置文件里把相应的配置读出来
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/mysql.properties"));
        String jdbcDriver;
        //主机
        String jdbcUrl;
        //数据库用户名
        String userName;
        String password;
        jdbcDriver = properties.getProperty("DRIVER");
        jdbcUrl = properties.getProperty("URL");
        userName = properties.getProperty("USERNAME");
        password = properties.getProperty("PASSWORD");
        Class.forName(jdbcDriver);
        connection = DriverManager.getConnection(jdbcUrl, userName, password);
        return connection;

    }
}
