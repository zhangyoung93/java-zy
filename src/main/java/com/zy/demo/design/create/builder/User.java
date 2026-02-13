package com.zy.demo.design.create.builder;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * User
 *
 * @author zy
 */
public class User {

    private final long id;

    private final String name;

    private final int age;

    private final boolean sex;

    private final Date birthday;

    /**
     * 只允许通过Builder创建对象
     *
     * @param userBuilder builder
     */
    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.age = userBuilder.age;
        this.sex = userBuilder.sex;
        this.birthday = userBuilder.birthday;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }

    /**
     * UserBuilder
     */
    public static class UserBuilder {

        private long id;

        private String name;

        private int age;

        private boolean sex;

        private Date birthday;

        public UserBuilder id(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder sex(boolean sex) {
            this.sex = sex;
            return this;
        }

        public UserBuilder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        /**
         * 通过校验后创建对象
         *
         * @return User
         */
        public User build() {
            if (this.id <= 0) {
                throw new IllegalArgumentException("id must great than 0");
            }
            if (StringUtils.isBlank(this.name)) {
                throw new IllegalArgumentException("name must not be null or empty");
            }
            return new User(this);
        }
    }

    /**
     * 给外部提供建造者
     *
     * @return UserBuilder
     */
    public static UserBuilder builder() {
        return new UserBuilder();
    }
}
