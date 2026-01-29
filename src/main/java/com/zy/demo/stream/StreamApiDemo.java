package com.zy.demo.stream;

import com.zy.demo.obj.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream API
 *
 * @author zy
 */
public class StreamApiDemo {

    private static final List<User> USER_LIST = new ArrayList<>();

    static {
        User user = new User(3L, "zhangsan", true, 80);
        USER_LIST.add(user);
        user = new User(4L, "lisi", false, 53);
        USER_LIST.add(user);
        user = new User(5L, "wangwu", true, 98);
        USER_LIST.add(user);
        user = new User(6L, "wangwu", true, 99);
        USER_LIST.add(user);
        user = new User(7L, "xueqi", true, 60);
        USER_LIST.add(user);
    }

    public static void streamApi() {
        System.out.println("before=" + USER_LIST);
        //用于去重
        Set<String> set = new HashSet<>();
        //数据校验。根据性别过滤，对姓名去查，对得分降序排列
        List<User> userList = USER_LIST.stream()
                .filter(user -> user.isSex() && set.add(user.getUserName()))
                .sorted((o1, o2) -> o2.getScore() - o1.getScore())
                .collect(Collectors.toList());
        System.out.println("after=" + userList);
    }

    public static void main(String[] args) {
        streamApi();
    }
}
