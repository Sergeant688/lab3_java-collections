package lab3_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int add_iter = 10000;
    static int get_iter = 10000;
    static int rm_iter = 10000;

    public static void main(String[] args) 
    {

        List<Integer> arrayList = new ArrayList<>();
        Collection List = new Collection(arrayList);
        long timeTestAdd = List.testAdd(add_iter);
        long timeTestGet = List.testGet(get_iter);
        long timeTestRemove = List.testRemove(rm_iter);
        
        System.out.println(timeTestAdd);
        System.out.println(timeTestGet);
        System.out.println(timeTestRemove);

        List<Integer> linkedList = new LinkedList<>();
        Collection linkList = new Collection(linkedList);
        timeTestAdd = linkList.testAdd(add_iter);
        timeTestGet = linkList.testGet(get_iter);
        timeTestRemove = linkList.testRemove(rm_iter);
        
        System.out.println(timeTestAdd);
        System.out.println(timeTestGet);
        System.out.println(timeTestRemove);

    }
}