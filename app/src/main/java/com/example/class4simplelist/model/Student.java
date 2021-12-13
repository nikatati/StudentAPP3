package com.example.class4simplelist.model;

public class Student
{
    public String name ;
    public String id ;
    public boolean cb = false;


    public Student() { }

    public Student(boolean cb, String name1, String id1)
    {
        this.name=name1;
        this.id=id1;
        this.cb=cb;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
