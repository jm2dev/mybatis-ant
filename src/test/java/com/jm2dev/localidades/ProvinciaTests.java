package com.jm2dev.localidades;

import org.testng.annotations.*;
import org.testng.Assert;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProvinciaTests {
    @BeforeClass
    public void setUp() {
        try {
            initSessionFactory();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
        }
    }

    @Test
    public void retrieveUsersFromDatabase() {
        SqlSession session = sessionFactory.openSession();

        try {
            ProvinciaMapper mapper = session.getMapper(ProvinciaMapper.class);
            Provincia provincia = mapper.getProvincia(2);
            
            Assert.assertEquals(provincia.getNombre(), "Albacete");
        } finally {
            session.close();		
        }
    }

    private static SqlSessionFactory sessionFactory;

    private Logger logger = LoggerFactory.getLogger(ProvinciaTests.class);

    public static void initSessionFactory() throws Exception {
        Reader rdr = Resources.getResourceAsReader("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(rdr);
        rdr.close();
        sessionFactory.getConfiguration().addMapper(ProvinciaMapper.class);
    }
}
