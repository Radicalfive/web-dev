package com.radical.listener;

import com.radical.entity.Book;
import com.radical.entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author : radical
 * @description :上下文加载监听，在服务器启动的时候即刻生效，用来生成用户数据和图书数据
 * @data : 2022/2/24
 **/
@WebListener
public class ContextLoaderListener implements ServletContextListener {

    /**
     * @Description 容器初始化方法
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
        //创建并生成用户数据列表(指定大小)
        List<User> userList = new ArrayList<>(3);
        User[] users = {
                new User(1, "123@qq.com", "698d51a19d8a121ce581499d7b701668", "radical", "user1.jpg", "江苏南京", LocalDate.of(2022, 1, 11)),
                new User(2, "234@qq.com", "698d51a19d8a121ce581499d7b701668", "如困兽之斗", "user2.jpg", "甘肃庆阳", LocalDate.of(2022, 2, 23)),
                new User(3, "345@qq.com", "698d51a19d8a121ce581499d7b701668", "诗酒趁年华", "user3.jpg", "宁夏银川", LocalDate.of(2020, 6, 18))
        };
        userList = Arrays.asList(users);

        //创建并生成图书数据列表
        List<Book> bookList = new ArrayList<>(10);
        Book[] books = {
                new Book(1, "漫长的婚约", "book1.jpg", "[法] 塞巴斯蒂安"),
                new Book(2, "庸人自扰", "book2.jpg", "[英]戴伦•麦加维"),
                new Book(3, "绿山墙的安妮", "book3.jpg", "[美]理查德·耶茨"),
                new Book(4, "敌人与邻居", "book4.jpg", "[英]伊恩·布莱克"),
                new Book(5, "哀伤纪", "book5.jpg", "钟晓阳"),
                new Book(6, "漫长的婚约", "book1.jpg", "[法] 塞巴斯蒂安"),
                new Book(7, "庸人自扰", "book2.jpg", "[英]戴伦•麦加维"),
                new Book(8, "绿山墙的安妮", "book3.jpg", "[美]理查德·耶茨"),
                new Book(9, "敌人与邻居", "book4.jpg", "[英]伊恩·布莱克"),
                new Book(10, "哀伤纪", "book5.jpg", "钟晓阳"),
                new Book(11, "漫长的婚约", "book1.jpg", "[法] 塞巴斯蒂安"),
                new Book(12, "庸人自扰", "book2.jpg", "[英]戴伦•麦加维")

        };
        bookList = Arrays.asList(books);

        //获得全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和图书列表数据记入，整个应用可以共享
        servletContext.setAttribute("userList", userList);
        servletContext.setAttribute("bookList", bookList);
    }
    /**
     * 销毁方法
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁");
    }
}

