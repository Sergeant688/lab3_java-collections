package lab3_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Главный класс приложения.
 * Запускает тесты производительности для ArrayList и LinkedList и выводит результаты в виде таблицы.
 */
public class Main 
{
    static int add_iter = 10000;
    static int get_iter = 10000;
    static int rm_iter = 10000;
    
    public static void main(String[] args) 
    {
        List<Result> results = new ArrayList<>();

        List<Integer> arrayList = new ArrayList<>();
        Collection arrayListTest = new Collection(arrayList); 
        results.add(arrayListTest.testAdd(add_iter));
        results.add(arrayListTest.testGet(get_iter));
        results.add(arrayListTest.testRemove(rm_iter));
        
        List<Integer> linkedList = new LinkedList<>();
        Collection linkList = new Collection(linkedList);
        results.add(linkList.testAdd(add_iter));
        results.add(linkList.testGet(get_iter));
        results.add(linkList.testRemove(rm_iter));
        
        printTable(results);
    }
    
    /**
     * Выводит результаты тестирования в виде отформатированной таблицы в консоль.
     *
     * @param results список результатов
     */
    private static void printTable(List<Result> results) 
    {
        String format = "| %-12s | %-16s | %-12d | %-15.3f | %-15d |%n";
        
        System.out.println("Сравнение производительности коллекций:");
        System.out.println();

        System.out.printf("| %-12s | %-16s | %-12s | %-15s | %-15s |%n", 
                "Коллекция", "Метод", "Кол-во раз", "Время (мс)", "Время (нс)");

        for (Result res : results) 
        {
            System.out.printf(format, 
                    res.getCollectionType(),
                    res.getMethod(),
                    res.getIterations(),
                    res.getTimeInMillis(),
                    res.getTimeInNanos());
        }
        System.out.println();
    }
}