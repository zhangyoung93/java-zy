package com.zy.demo.optional;

import com.zy.demo.obj.User;

import java.util.Optional;

/**
 * Optional
 *
 * @author zy
 */
public class OptionalDemo {

    public static void optional(User user) {
        //对象是否存在
        System.out.println(Optional.ofNullable(user).isPresent());
        //如果对象为空，延迟创建新对象
        User newUser = Optional.ofNullable(user).orElseGet(() -> new User(8L, "victor"));
        System.out.println(newUser);
        //对象如果存在，则设置分数为100
        Optional.of(newUser).ifPresent(user1 -> user1.setScore(100));
        System.out.println(newUser);
    }

    public static void main(String[] args) {
        optional(null);
    }
}
