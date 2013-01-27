
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MTTest
{
	public int minValue=(int)Double.POSITIVE_INFINITY;
	public int minIndex=0;
	public final int testSize=200;
	public int noOfThreads;
	public int[] array;
	public Minimum[] mins;
	public Thread[] threads; 
	public MTTest(int n) throws InterruptedException, ExecutionException
	{
		noOfThreads=n;
		System.out.println("Creating "+n+" threads...");
		array=new int[testSize];
	    for (int i=0;i<array.length;i++)
	      array[i] = testSize-i;
	    ExecutorService pool = Executors.newFixedThreadPool(noOfThreads);
	    Future<int[]>[] future=new Future[noOfThreads];
	    for(int i=0;i<noOfThreads;i++)
	    {
	    	Callable<int[]> callable=new Minimum(i,noOfThreads);
	    	future[i]=pool.submit(callable);
	    }
	    for(int i=0;i<noOfThreads;i++)
	    	if(future[i].get()[0]<minValue)
	    	{
	    		minValue=future[i].get()[0];
	    		minIndex=future[i].get()[1];
	    	}
	}
	public class Minimum implements Callable<int[]>
	{
		int factor1;
		int factor2;
		int minVal=(int)Double.POSITIVE_INFINITY;
		int minInd;
		public Minimum()
		{
			
		}
		public Minimum(int f1,int f2)
		{
			factor1=f1;
			factor2=f2;
		}
		public void run()
		{
			for(int i=factor1;i<MTTest.this.testSize;i+=factor2)
				if(MTTest.this.array[i]<minVal)
				{
					minVal=MTTest.this.array[i];
					minInd=i;
				}
		}
		public int[] call() throws Exception
		{
			int[] returnArray=new int[2];
			run();
			System.out.println(minVal+","+minInd);
			returnArray[0]=minVal;
			returnArray[1]=minInd;
			return returnArray;
		}
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		//Create as many threads as there are available (logical) processor cores
		MTTest test=new MTTest(Runtime.getRuntime().availableProcessors());
		System.out.println("Final Minimum:"+test.minValue+","+test.minIndex);
	}
}