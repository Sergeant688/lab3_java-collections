package lab3_java;

public class Result 
{
    private String collectionType;
    private String method;
    private int iterations;
    private long timeIn;

    public Result(String collectionType, String method, int iterations, long timeIn) 
    {
        this.collectionType = collectionType;
        this.method = method;
        this.iterations = iterations;
        this.timeIn = timeIn;
    }

    public double getTimeInMillis() 
    {
        return timeIn / 1000000.0;
    }

    public String getCollectionType() { return collectionType; }
    public String getMethod() { return method; }
    public int getIterations() { return iterations; }
    public long getTimeInNanos() { return timeIn; }
}