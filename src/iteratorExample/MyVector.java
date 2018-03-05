package iteratorExample;

import java.util.Iterator;
import java.util.Vector;
import java.util.function.Predicate;

public class MyVector<T> extends Vector<T> {
	
	public <R> void doAll(Functor<T,R> functor){
		Iterator iterator=this.iterator();
		while(iterator.hasNext())
		{
			functor.compute((T)iterator.next());
		}
	}
	//For External
	public Iterator<T> mySelectiveiterator(Predicate<T> predicate){
		return new ExternalSelectiveIterator<T>(this,predicate);	 
	 }
	
	public <R> void doAll(Functor<T,R> functor,Predicate<T> predicate){
		Iterator iterator=this.iterator();
		T value;
		while(iterator.hasNext())
		{
			value=(T)iterator.next();
			if(predicate.test(value))
			{
				functor.compute(value);
			}
			
		}
	}
	//For No4
	public View doAllFilter(Predicate<T> predicate){
		View returnView=new View(this, predicate);
		return returnView;
	}
	public class View implements Iterable<T>{
		private MyVector<T> myVector;
		private Predicate<T> predicate;
	
		View(MyVector<T> myVector,Predicate<T> predicate)
		{
			this.myVector=myVector;
			this.predicate=predicate;
		}
		@Override
		public Iterator<T> iterator(){
			return myVector.mySelectiveiterator(predicate);		 
		 }

	}
	public class ExternalSelectiveIterator<T> implements Iterator<T> {
		private MyVector<T> myVector;
		private Predicate<T> predicate;
		int index=0;
		
		ExternalSelectiveIterator(MyVector<T> myVector,Predicate<T> predicate)
		{
			this.myVector=myVector;
			this.predicate=predicate;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			while(index<myVector.size())
			{
				if(predicate.test(myVector.get(index)))
					{
						return true;
					}
				else
				{
					index++;
				}
					
			}
			return false;
		}

		@Override
		public T next() {
				T nextValue=myVector.get(index);
				index++;
				return nextValue;
		}
		
	}
}
