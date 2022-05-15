package 数据库事务.DAO;

import 数据库事务.Bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @ClassName CustomerDAO
 * @Description TODO
 * @Author lmy
 * @Date 2022/3/20 10:06
 *
 * 此接口用于规范针对于customers表的常用操作
 **/
public interface CustomerDAO {
    /**
     *@description:将cust对象添加到数据库中
     *@Author:lmy
     *@Date:2022/3/20 10:38
     *@param:*@param conn
     *@param:cust
     */
    void insert(Connection conn, Customer cust);

    /**
     *@description:针对指定的id,删除表中的一条记录
     *@Author:lmy
     *@Date:2022/3/20 10:40
     *@param:conn
     *@param:id
     */
    void deleteByid(Connection conn,int id);

    /**
     *@description:针对内存中的cust对象,去修改数据表中指定的记录
     *@Author:lmy
     *@Date:2022/3/20 10:41
     *@param:@param conn
     *@param:cust
     */

    void update(Connection conn,Customer cust);

    /**
     *@description:针对指定的id查询得到对应的Customer对象
     *@Author:lmy
     *@Date:2022/3/20 10:43
     *@param:conn
     *@param id
     */

    Customer getCustomerById(Connection conn,int id);

    /**
     *@description:查询表中的所有记录构成的集合
     *@Author:lmy
     *@Date:2022/3/20 10:43
     *@param:conn
     */

    List<Customer> getAll(Connection conn);

    /**
     *@description:返回数据表中的数据的条目数
     *@Author:lmy
     *@Date:2022/3/20 10:48
     *@param:conn
     */

    Long getCount(Connection conn);

    /**
     *@description:返回数据表中最大的生日
     *@Author:lmy
     *@Date:2022/3/20 10:49
     *@param:conn
     */

    Date getMaxBirth(Connection conn);
}
