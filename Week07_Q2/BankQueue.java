
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}
	public int getNeededQueueLength() {
		int totalPeople = 0;
		int totalCounters = counters.length + 1;
		
		for (DeQ deQ: counters) {
			totalPeople += deQ.size();
		}
		
		double result = (float) totalPeople/ totalCounters;
		return ((int)Math.round(result));
	}
	
	public void distribute() throws Exception {
		
		int neededQeueueLength = getNeededQueueLength();
		
	
		for (DeQ counter: counters) {
			DeQArray tempQ = new DeQArray();
			
			while (counter.size() != neededQeueueLength) {
				tempQ.insertFirst(counter.removeLast());
			}
			
			while (!tempQ.isEmpty()) {
				if (special.size() == neededQeueueLength) {
					while (!tempQ.isEmpty()) {
						counter.insertLast(tempQ.removeFirst());
					}
					return;
				}
				special.insertLast(tempQ.removeFirst());;
			}
		}
		
		if (special.isEmpty()) {
			special.insertFirst(counters[counters.length - 1].removeLast());
		}

	}

}
