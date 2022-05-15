package 数据库连接池.C3P0数据库连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @ClassName C3P0Test
 * @Description TODO
 * @Author lmy
 * @Date 2022/3/22 19:51
 **/
public class C3P0Test {
    //方式一:
    @Test
    public void testGetConnection() throws  Exception{
        //获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("root");
        cpds.setPassword("Lmy20020802");
        //通过设置相关的参数对数据库连接池进行管理
        //设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);
        Connection conn = cpds.getConnection();
        System.out.println(conn);

        //销毁c3p0数据库连接池
//        DataSources.destroy( cpds );
    }
    //方式二:使用配置文件
    @Test
    public void  testGetConnection1() throws  Exception
    {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
