package java8functional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BehaviorParameterization {

	// 0 - begin
	public static Collection<Transaction> filter(Collection<Transaction> transactions) {
		List<Transaction> res = new ArrayList<>();
		for (Transaction t : transactions) {
			if (1000 < t.getPrice()) {
				res.add(t);
			}
		}
		return res;
	}

	// 1 - getting better
	public static Collection<Transaction> filter(Collection<Transaction> transactions, 
			Predicate<Transaction> p) {
		
		List<Transaction> res = new ArrayList<>();
		for (Transaction t : transactions) {
			if (p.test(t)) {
				res.add(t);
			}
		}
		return res;
	}
	
	private static int compareTransactions(Transaction t1, Transaction t2) {
		int res = t1.getCurrency().compareToIgnoreCase(t2.getCurrency());
		if (res == 0) {
			res = Double.compare(t1.getPrice(), t2.getPrice());
		}
		return res;
	}

	/**
	 * 3 variants reference to function
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<Transaction> transactions = 
				Util.createRandomTransactions(5, 2000, Util.f, ArrayList<Transaction>::new);
		System.out.println(transactions );
		System.out.println(filter(transactions));

		System.out.println(filter(transactions, new Predicate<Transaction>() {
			@Override
			public boolean test(Transaction t) {
				return 1000 < t.getPrice();
			}
		}));
		System.out.println(filter(transactions, t -> 1000 < t.getPrice()));
//
		Collections.sort(new ArrayList<Transaction>(), Comparator.comparing(Transaction::getPrice));
		Collections.sort(new ArrayList<Transaction>(), BehaviorParameterization::compareTransactions);
	}
}

interface Predicate<T> {
	boolean test(T t);
}
