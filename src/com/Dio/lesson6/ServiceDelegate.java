package com.Dio.lesson6;

import java.util.ArrayList;

public class ServiceDelegate {
    private final ArrayHelper resourse;

    public ServiceDelegate(ArrayHelper resourse) {
        this.resourse = resourse;
    }

    public ArrayList <Person> merge(ArrayList<Person> leftArray, ArrayList <Person> rightArray) {
        printArray(leftArray);
        printArray(rightArray);

        ArrayList<Person> result = resourse.merge(leftArray, rightArray);

        printArray(result);

        return result;
    }

    public ArrayList <Person> innerUnion(ArrayList <Person> leftArray, ArrayList <Person> rightArray) {
        printArray(leftArray);
        printArray(rightArray);

        ArrayList<Person> result = resourse.innerUnion(leftArray, rightArray);

        printArray(result);

        return result;
    }

    public ArrayList <Person> outerUnion (ArrayList <Person> leftArray,  ArrayList <Person> rightArray) {
        printArray(leftArray);
        printArray(rightArray);

        ArrayList<Person> result = resourse.outerUnion(leftArray, rightArray);

        printArray(result);

        return result;
    }



    public void printArray(ArrayList<Person>persons) {
        for(Person p : persons){
            System.out.println(p);
        }
        System.out.println();
    }
}

