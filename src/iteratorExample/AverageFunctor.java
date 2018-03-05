package iteratorExample;

public class AverageFunctor implements Functor<Integer,Double> {
Double average=0.0, sum=0.0;
Integer counter=1;
	@Override
	public void compute(Integer element) {
		// TODO Auto-generated method stub
		sum=sum+element;
		average=(sum/counter);
		counter++;
		//return average;
	}

	@Override
	public Double getValue() {
		// TODO Auto-generated method stub
		return average;
	}

}
