package iteratorExample;

import java.util.function.Predicate;

public class PredicateCriteria implements Predicate<Integer> {

	@Override
	public boolean test(Integer value) {
		// TODO Auto-generated method stub
		if(value>2)
			return true;
		else
		return false;
	}

}
