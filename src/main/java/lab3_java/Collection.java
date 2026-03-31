package lab3_java;

import java.util.List;


/**
 * Класс для тестирования производительности коллекций.
 * Позволяет измерять время выполнения основных методов (add, get, remove).
 */
public class Collection
{
	private List<Integer> list;
	
	public Collection(List<Integer> list)
	{
		this.list = list;
	}
	
	/**
     * Выполняет тестирование метода add.
     *
     * @param list список для тестирования
     * @param iterations количество элементов для добавления
     * @return объект {@link Result} с результатами тестирования
     */
    public Result testAdd(int iterations)
    {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++)
        	list.add(i);
        
        long endTime = System.nanoTime();
        return new Result(list.getClass().getSimpleName(), "add", iterations, endTime - startTime);
    }

    /**
     * Выполняет тестирование метода get.
     *
     * @param list список для тестирования
     * @param iterations количество вызовов метода get
     * @return объект {@link Result} с результатами тестирования
     */
    public Result testGet(int iterations)
    {
        if (list.isEmpty())	throw new IllegalStateException("Список пуст! Сначала заполните его.");
        
        int middleIndex = list.size() / 2;
        
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++)
            list.get(middleIndex);
        
        long endTime = System.nanoTime();
        return new Result(list.getClass().getSimpleName(), "get", iterations, endTime - startTime);
    }

    /**
     * Выполняет тестирование метода remove.
     *
     * @param list список для тестирования
     * @param iterations количество элементов для удаления
     * @return объект {@link Result} с результатами тестирования
     */
    public Result testRemove(int iterations)
    {
        if (list.size() < iterations) throw new IllegalArgumentException("В списке недостаточно элементов для удаления!");
        
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++)
            list.remove(0);
        
        long endTime = System.nanoTime();
        return new Result(list.getClass().getSimpleName(), "remove", iterations, endTime - startTime);
    }
}