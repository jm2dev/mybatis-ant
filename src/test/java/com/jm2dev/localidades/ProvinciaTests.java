package com.jm2dev.localidades;

import org.testng.annotations.*;
import org.testng.Assert;

import java.io.Reader;
import java.util.List;

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
            session = sessionFactory.openSession();
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
    }

    @AfterClass 
    public void tearDown() {
        session.close();		
    }

    @Test
    public void retrieveSingleProvinceFromDatabase() {
        ProvinciaMapper mapper = session.getMapper(ProvinciaMapper.class);
        Provincia provincia = mapper.getProvincia(2);
            
        Assert.assertEquals(provincia.getNombre(), "Albacete");
    }

    @Test
    public void retrieveAllSpanishProvinces() {
        ProvinciaMapper mapper = session.getMapper(ProvinciaMapper.class);
        List<Provincia> provincias = mapper.getProvincias();

        Assert.assertEquals(provincias.size(), 52);
    }

    private static SqlSessionFactory sessionFactory;
    private SqlSession session;
    private Logger logger = LoggerFactory.getLogger(ProvinciaTests.class);

    public static void initSessionFactory() throws Exception {
        Reader rdr = Resources.getResourceAsReader("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(rdr);
        rdr.close();
        sessionFactory.getConfiguration().addMapper(ProvinciaMapper.class);
    }
}
