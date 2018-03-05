package iteratorExample;

public class SumFunctor implements Functor<Integer,Double>{
	Double sum=0.0;
	@Override
	public void compute(Integer element) {
		// TODO Auto-generated method stub
		sum=sum + element;
		//return sum;
	}

	@Override
	public Double getValue() {
		// TODO Auto-generated method stub
		return sum;
	}

	
	
}
