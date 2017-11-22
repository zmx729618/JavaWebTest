package org.zwc.classloadertest;

/**
 * Created by zhangwenchao on 2017/11/22.
 */
public class Person {

    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {

        return "I am a person, my name is " + name;

    }

}
