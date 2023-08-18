package com.example.springtset;

import com.example.springtset.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class SpringTsetApplicationTests {
    private SqlSession sqlSession;
    @Before
    public void init(){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory =ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();
    }
    @Test
    public void testSelectOne(){
        //查询单个对象
        System.out.println("查询单个对象");
        User user = sqlSession.selectOne("findOne");
        System.out.println(user);
    }
    @Test
    public void testSelectList(){
        //查询多个对象的list集合
        System.out.println("查询多个对象的list集合");
        List<User> list = sqlSession.selectList("UserMapper.findAll");
        System.out.println(list);
    }
    @Test
    public void testSelectMap(){
        //查询多个对象的map集合
        System.out.println("查询多个对象的map集合");
        Map<Integer,User> map = sqlSession.selectMap("findUserMap","NAME");
        Set<Integer> names = map.keySet();
        for (Integer name:names) {
            System.out.println(name+""+map.get(name));
        }
    }

    @Test
    void contextLoads() {
    }

}
