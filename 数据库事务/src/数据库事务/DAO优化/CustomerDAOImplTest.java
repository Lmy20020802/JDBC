package 数据库事务.DAO优化;

import org.junit.Test;
import 数据库事务.Bean.Customer;
import 数据库事务.DAO.CustomerDAOImp1;
import 数据库连接池.C3P0数据库连接池.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @ClassName CustomerDAOImplTest
 * @Description TODO
 * @Author lmy
 * @Date 2022/3/22 19:32
 **/
public class CustomerDAOImplTest {
        private CustomerDAOImp1 dao=new CustomerDAOImp1();
        @Test
        public void insert() {
            Connection conn= null;
            try {
                conn = JDBCUtils.getConnection();
                Customer cust = new Customer(1, "于小飞", "xiaofei@126.com", new Date(43534646435L));
                dao.insert(conn,cust);
                System.out.println("添加成功");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.closeResource(conn,null);
            }
        }

        @Test
        public void deleteByid() {
            Connection conn= null;
            try {
                conn = JDBCUtils.getConnection();
                dao.deleteByid(conn,13);
                System.out.println("删除成功");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.closeResource(conn,null);
            }
        }

        @Test
        public void update() {
            Connection conn = null;
            try {
                conn = JDBCUtils.getConnection();
                Customer cust = new Customer(16,"贝多芬","beiduofen@126.com",new Date(453465656L));
                dao.update(conn, cust);
                System.out.println("修改成功");
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                JDBCUtils.closeResource(conn, null);

            }
        }

        @Test
        public void getCustomerById() {
            Connection conn= null;
            try {
                conn = JDBCUtils.getConnection3();
                Customer cust = dao.getCustomerById(conn, 19);
                System.out.println(cust);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.closeResource(conn,null);
            }
        }

        @Test
        public void getAll() {
            Connection conn= null;
            try {
                conn = JDBCUtils.getConnection();
                List<Customer> list = dao.getAll(conn);
                list.forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.closeResource(conn,null);
            }
        }

        @Test
        public void getCount() {
            Connection conn= null;
            try {
                conn = JDBCUtils.getConnection();
                Long count = dao.getCount(conn);
                System.out.println("表中的记录数为:"+count);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.closeResource(conn,null);
            }
        }

        @Test
        public void getMaxBirth() {
            Connection conn= null;
            try {
                conn = JDBCUtils.getConnection();
                Date maxBirth=dao.getMaxBirth(conn);
                System.out.println("最大的生日:"+maxBirth);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.closeResource(conn,null);
            }
        }
}
