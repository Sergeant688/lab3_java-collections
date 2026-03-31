package lab3_java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test_lab3 
{

    @Test
    void testAdd()
    {
        List<Integer> list = new ArrayList<>();
        Collection tester = new Collection(list); 
        
        Result result = tester.testAdd(1000);

        assertEquals(1000, list.size(), "В список должно быть добавлено 1000 элементов");
        assertEquals("ArrayList", result.getCollectionType());
        assertEquals("add", result.getMethod());
        assertEquals(1000, result.getIterations());
        assertTrue(result.getTimeInNanos() > 0, "Время выполнения должно быть больше нуля");
    }

    @Test
    void testGet() 
    {
        List<Integer> list = new LinkedList<>();
        Collection tester = new Collection(list);
        
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            tester.testGet(100);
        });
        assertEquals("Список пуст! Сначала заполните его.", exception.getMessage());
    }

    @Test
    void testRemove() 
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Collection tester = new Collection(list);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tester.testRemove(10);
        });
        assertEquals("В списке недостаточно элементов для удаления!", exception.getMessage());
    }
}