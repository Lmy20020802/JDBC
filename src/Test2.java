import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author lmy
 * @Date 2022/3/16 20:30
 **/
public class Test2 {
    public static Connection getConnection() throws Exception {
        InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros=new Properties();
        pros.load(is);

        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");
        Class.forName(driverClass);

        Connection conn= DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void classResource(Connection conn, Statement ps)
    {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResourse(Connection conn, Statement ps, ResultSet rs)
    {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
