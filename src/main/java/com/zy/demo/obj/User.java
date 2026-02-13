package com.zy.demo.obj;

/**
 * User
 *
 * @author zy
 */
public class User {

    private Long userId;

    private String userName;

    private boolean sex;

    private int age;

    private int score;

    public User() {

    }

    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public User(Long userId, String userName, boolean sex, int score) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.score = score;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
