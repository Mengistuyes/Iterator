package iteratorExample;

import java.util.Iterator;
import java.util.function.Predicate;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyVector<Integer> myVector=new MyVector();
		for(int i=1;i<=10;i++)	{myVector.add(i);}
		System.out.println("\nIteration Exercise(s)\n");
		internalAndCompleteSumFunctor(myVector);
		internalAndCompleteAvergeFunctor(myVector);
		ExternalAndSelectiveSumFunctor(myVector);
		ExternalAndSelectiveAverageFunctor(myVector);
		internalAndSelectiveAvergeFunctor(myVector);
		ExternalSelectivePlusIterable(myVector);
	}

	public static void internalAndCompleteSumFunctor(MyVector<Integer> myVector){
		Functor<Integer,Double> sumFunctor=new SumFunctor();
		myVector.doAll(sumFunctor);
		Display.display("Summing Integers using Internal / Complete Style",sumFunctor.getValue());
	}
	
	public static void internalAndCompleteAvergeFunctor(MyVector<Integer> myVector){
		Functor<Integer,Double> averageFunctor=new AverageFunctor();
		myVector.doAll(averageFunctor);
		Display.display("Finding Average of Integers using Internal / Complete Style",averageFunctor.getValue());
	}
	
	public static void ExternalAndSelectiveSumFunctor(MyVector<Integer> myVector){
		Functor<Integer,Double> sumFunctor=new SumFunctor();
		Predicate<Integer> predicate=new PredicateCriteria();
		Iterator<Integer> iterator=myVector.mySelectiveiterator(predicate);
		while(iterator.hasNext())
		{
			sumFunctor.compute(iterator.next());
		}
		Display.display("Finding Sum of Integers that are greater than 2 using External / Selective Iterator Style",sumFunctor.getValue());
	}
	
	public static void ExternalAndSelectiveAverageFunctor(MyVector<Integer> myVector){
		Functor<Integer,Double> averageFunctor=new AverageFunctor();
		Predicate<Integer> predicate=new PredicateCriteria();
		Iterator<Integer> iterator=myVector.mySelectiveiterator(predicate);
		while(iterator.hasNext())
		{
			averageFunctor.compute(iterator.next());
		}
		Display.display("Finding Average of Integers  that are greater than 2 using External / Selective Iterator Style",averageFunctor.getValue());
	}
	
	public static void internalAndSelectiveAvergeFunctor(MyVector<Integer> myVector){
		Functor<Integer,Double> sumFunctor=new SumFunctor();
		Predicate<Integer> predicate=new PredicateCriteria();
	//	Iterator<Integer> iterator=myVector.mySelectiveiterator(predicate);
		myVector.doAll(sumFunctor,predicate);
		Display.display("Finding Sum of Integers using Internal / Selective Style",sumFunctor.getValue());
	}
	
	public static void ExternalSelectivePlusIterable(MyVector<Integer> myVector)
	{
		Double sum=0.0;
		Functor<Integer,Double> sumFunctor=new SumFunctor();
		Predicate<Integer> predicate=new PredicateCriteria();
		//myVector.doAll(predicate);
		for(Integer myReturnedInteger:myVector.doAllFilter(predicate))
		{
			sum=sum+myReturnedInteger;
		}
		
		Display.display("Finding Sum of Integers greater than 2 using External / Selective + Iterable Style",sum);
	}
}
