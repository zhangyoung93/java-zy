package com.zy.demo.junit;

import org.junit.jupiter.api.*;

/**
 * Junit用法，可直接测试整个类
 * TestMethodOrder表示开启按顺序运行测试用例；OrderAnnotation表示根据Order注解设置顺序
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitTest {

    /**
     * 当前类所有测试用例运行前执行，必须用static修饰，表示仅执行一次
     */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    /**
     * 当前类所有测试用例运行后执行，必须用static修饰，表示仅执行一次
     */
    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    /**
     * 当前类每个测试用例运行后都会执行
     */
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    /**
     * 当前类每个测试用例运行前都会执行
     */
    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    /**
     * 单元测试用例1，设置@Disabled则不执行当前测试用例
     */
    @Test
    @Disabled
    public void test0() {
        System.out.println("test0");
    }

    @Test
    @Order(2)
    public void test1() {
        System.out.println("test1");
    }

    /**
     * 单元测试用例2
     */
    @Test
    @Order(1)
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void assertion() {
        Object object = "null";
        Assertions.assertEquals(1, 1);
        Assertions.assertNotNull(object);
    }
}
