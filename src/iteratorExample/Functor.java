package iteratorExample;

public interface Functor<T,R> {
	public void compute(T element);
	public R getValue();
}

