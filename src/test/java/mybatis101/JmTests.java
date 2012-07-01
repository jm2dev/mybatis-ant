package mybatis101;

import org.testng.annotations.*;
import org.testng.Assert;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JmTests {
    @Test
    public void funciona() {
        System.out.println("Testing JM!");
    }

    @Test
    public void retrieveUsersFromDatabase() {
        try {
            initSessionFactory();
        } catch(Exception e) {
            System.out.println("Puto error");
        }

        SqlSession session = sessionFactory.openSession();

        try {
            Mapper mapper = session.getMapper(Mapper.class);
            User user = mapper.getUser(2);
            Assert.assertEquals(user.getName(), "User2");
        } finally {
            session.close();		
        }
    }

    private static SqlSessionFactory sessionFactory;

    public static void initSessionFactory() throws Exception {
        Reader rdr = Resources.getResourceAsReader("MyBatis101-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(rdr);
        rdr.close();
    }

}
