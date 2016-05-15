package com.system.entity;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by king on 2016/4/20.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-hibernate.xml" })
public class TestHospital {


    private static final Logger LOGGER = Logger.getLogger(TestHospital.class);

    @Test
    public void testSchemaExport(){
        //创建配置对象
        Configuration config = new Configuration().configure();

        //创建schemaExport对象
        SchemaExport export = new SchemaExport(config);

        export.execute(true, true, false, false);
    }

    @Test
    public void test(){
        Hospital hospital = new Hospital();
        LOGGER.info(hospital);
    }

}
