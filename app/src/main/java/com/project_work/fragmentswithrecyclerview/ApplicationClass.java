package com.project_work.fragmentswithrecyclerview;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ApplicationClass extends Application {
    public static ArrayList<Person> people;
    @Override
    public void onCreate() {
        super.onCreate();
        people=new ArrayList<Person>();
        people.add(new Person("Jhon Dough","9839323885"));
        people.add(new Person("Rany Disoza","7893483293"));
        people.add(new Person("Brayan Rosewell","6789432234"));
    }

}
