package com.example.class4simplelist.model;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class Model {

    static final public Model instance = new Model();
    private List<Student> data = new LinkedList<Student>();

    private  Model()
    {
    }

    public List<Student> getStudentList(){
        return data;
    }

    public Student getStudentById(String id)
    {
        for (Student s_:data)
        {
            if (s_.id.equals(id))
            {
                return s_;
            }
        }
            return null;
    }

    public void addNewStudent(Student student){ data.add(student); }

    public void editStudent(int pos,Student student) {
        data.set(pos,student);
    }

    public void deleteStudent(Student student) {
        data.remove(student);
    }
}
