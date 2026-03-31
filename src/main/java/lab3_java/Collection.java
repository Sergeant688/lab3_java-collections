package lab3_java;

import java.util.List;

public class Collection
{
	private List<Integer> list;
	
	public Collection(List<Integer> list)
	{
		this.list = list;
	}
	
    public long testAdd(int iterations)
    {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++)
        	list.add(i);
        
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public long testGet(int iterations)
    {
        if (list.isEmpty())	throw new IllegalStateException("Список пуст! Сначала заполните его.");
        
        int middleIndex = list.size() / 2;
        
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++)
            list.get(middleIndex);
        
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public long testRemove(int iterations)
    {
        if (list.size() < iterations) throw new IllegalArgumentException("В списке недостаточно элементов для удаления!");
        
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++)
            list.remove(0);
        
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}