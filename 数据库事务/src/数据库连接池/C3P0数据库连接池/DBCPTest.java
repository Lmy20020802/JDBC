package 数据库连接池.C3P0数据库连接池;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName DBCPTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/3/22 20:54
 **/
public class DBCPTest {

    /**
     *@description:测试DBCP的数据库连接池技术
     *@Author:lmy
     *@Date:2022/3/22 21:00
     */
    @Test
    public void testGetConnection() throws SQLException {
        //方式一:不推荐
        //创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();

        //设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///test");
        source.setUsername("root");
        source.setPassword("Lmy20020802");

        //还可以设置其他涉及数据库连接池管理的相关属性：
        source.setInitialSize(10);
        source.setMaxActive(10);
        //。。。

        Connection conn = source.getConnection();
        System.out.println(conn);
    }
    @Test
    public void testGetConnection1() throws Exception{
        Properties pros = new Properties();

        //方式1：
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //方式2：
        FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));


        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }


}
