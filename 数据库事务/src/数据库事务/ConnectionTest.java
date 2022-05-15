package 数据库事务;

import org.junit.Test;

import java.sql.Connection;

/**
 * @ClassName 数据库事务.ConnectionTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/3/19 11:20
 *
 **/
public class ConnectionTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }
}
