package com.company;

import java.io.Serializable;

public class User implements Serializable {

    // модификатор доступа не вляет на процес сериализации

    private final static long serialVersionUID = 2;
    private int age;
    protected String name;

    //transient игнарирует поле при сериализации
    public transient Job job;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
