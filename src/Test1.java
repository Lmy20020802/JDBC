import com.sun.media.sound.SoftTuning;
import org.junit.Test;
import 数据库的增删改查.课后练习.Student;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author lmy
 * @Date 2022/3/15 22:15
 **/
public class Test1 {
    @Test
    public void test1(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入四级/六级");
        int type = scanner.nextInt();
        System.out.println("请输入身份证号:");
        String IDCard = scanner.next();
        System.out.println("请输入准考证号:");
        String ExamCard = scanner.next();
        System.out.println("请输入学生姓名");
        String StudentName=scanner.next();
        System.out.println("请输入所在城市");
        String Location= scanner.next();
        System.out.println("请输入考试成绩:");
        int Grade=scanner.nextInt();

        String sql="insert into examstudent(type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
        int insertCount = upadate(sql, type, IDCard, ExamCard, StudentName, Location, Grade);
        if (insertCount>0)
        {
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
    public int upadate(String sql,Object ...args)
    {
        Connection conn= null;
        PreparedStatement ps= null;
        try {
            conn = Test2.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i=0;i<args.length;i++)
            {
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Test2.classResource(conn,ps);
        }
        return 0;
    }
    @Test
    public void test2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要输入的类型:");
        System.out.println("a.准考证号");
        System.out.println("b.身份证号");
        String selection = scanner.next();
        if ("a".equalsIgnoreCase(selection))   //(selection.equalsIgnoreCase("a"))
        {
            System.out.println("请输入准考证号：");
            String examCard = scanner.next();
            String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where examCard = ?";

            Student student = getInstance(Student.class,sql,examCard);
            if(student != null){
                System.out.println(student);
            }else{
                System.out.println("输入的准考证号有误！");
            }
        } else if ("b".equalsIgnoreCase(selection))
        {
            System.out.println("请输入身份证号：");
            String IDCard = scanner.next();
            String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where IDCard = ?";

            Student student = getInstance(Student.class,sql,IDCard);
            if(student != null){
                System.out.println(student);

            }else{
                System.out.println("输入的身份证号有误！");
            }
        }else {
            System.out.println("您的输入有误,请重新进入程序!");
        }
    }
    public <T> T getInstance(Class<T> clazz,String sql,Object ...args)
    {
        Connection conn= null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        try {
            conn = Test2.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i=0;i<args.length;i++)
            {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next())
            {
                T t=clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field=clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columValue);
                }
                return  t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Test2.closeResourse(conn,ps,rs);
        }
        return null;
    }
}