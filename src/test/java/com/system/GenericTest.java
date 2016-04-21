package com.system;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * 最基本的测试类，其他的测试类只需要继承该类，不用每次都编写类头的注解
 * Created by king on 2016/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-hibernate.xml" })
public class GenericTest {
}
