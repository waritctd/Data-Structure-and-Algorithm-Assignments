
public class SimulateQueue {

	CustomerInfo[][] allEvents; //events in each and every queue
 
	MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		
		int index = 0;
		
		for (CustomerInfo[] event: allEvents) {
			for (CustomerInfo customerInfo: event) {
				if (customerInfo.getTime() < t) {
					if (customerInfo.getEvent() == -1) {
						allQueues[index].removeFirst();
					} else {
						allQueues[index].insertLast(1);
					}

				}
			}
			index++;
		}
	}
}
