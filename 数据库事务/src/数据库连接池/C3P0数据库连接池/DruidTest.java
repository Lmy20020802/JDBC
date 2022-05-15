package 数据库连接池.C3P0数据库连接池;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @ClassName DruidTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/3/22 21:52
 **/
public class DruidTest {
    @Test
    public void  getConnection() throws Exception{
        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

        pros.load(is);

        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
