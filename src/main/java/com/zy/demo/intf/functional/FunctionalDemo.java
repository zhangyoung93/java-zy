package com.zy.demo.intf.functional;

import com.zy.demo.obj.User;
import com.zy.demo.obj.UserDo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 *
 * @author zy
 */
public class FunctionalDemo {

    private static final User USER = new User();

    static {
        USER.setUserId(1L);
        USER.setUserName("john");
        USER.setAge(18);
        USER.setSex(true);
        USER.setScore(99);
    }

    /**
     * 条件判断函数：Predicate<T>
     *
     * @return 判断结果
     */
    public static boolean predicate() {
        //定义函数
        Predicate<User> predicate = user -> user.getAge() > 18 && user.isSex();
        //执行函数
        boolean result = predicate.test(USER);
        System.out.println(result);
        return result;
    }

    /**
     * 批量消费数据函数：Consumer<T>
     */
    public static void consumer() {
        //定义函数
        Consumer<User> consumer = user -> {
            if (user.getAge() < 18) {
                user.setScore(user.getScore() + 1);
            }
        };
        //执行函数
        consumer.accept(USER);
        System.out.println(USER);
    }

    /**
     * 数据转换函数：Function<T, R>
     *
     * @return R
     */
    public static UserDo function() {
        //定义函数
        Function<User, UserDo> function = user -> {
            UserDo userDo = new UserDo();
            userDo.setUserId(user.getUserId());
            userDo.setUserName(user.getUserName());
            userDo.setAge(user.getAge());
            userDo.setSex(user.isSex());
            userDo.setScore(user.getScore());
            return userDo;
        };
        //执行函数
        UserDo userDo = function.apply(USER);
        System.out.println(userDo.toString());
        return userDo;
    }

    /**
     * 数据提供函数：supplier()
     * 延迟创建对象；为对象提供默认值。
     *
     * @return User
     */
    public static User supplier() {
        Supplier<User> supplier = () -> new User(2L, "Tom");
        User user = supplier.get();
        System.out.println(user);
        return user;
    }

    /**
     * 自定义函数接口
     *
     * @return Object Object
     */
    public static Object customizeFunction() {
        CustomizeFunctional<Object> customizeFunctional = () -> "customizeFunction";
        Object object = customizeFunctional.customizeFunction();
        System.out.println(object);
        return object;
    }

    public static void main(String[] args) {
        predicate();
        consumer();
        function();
        supplier();
        customizeFunction();
    }
}
