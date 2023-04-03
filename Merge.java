import java.util.Comparator;
import java.util.PriorityQueue;

// A Linked List Node
class Node
{
	int data;
	Node next;

	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

class Merge
{
	public static Node mergeKLists(Node[] lists)
	{
		
		PriorityQueue<Node> pq;
		pq = new PriorityQueue<>(Comparator.comparingInt(a -> ((Node) a).data));

		
		Node head = null, last = null;


		// insert the heads of all the lists in the priority queue
		for (Node node : lists) {
			if (node != null) {
				pq.offer(node); // "offer" inserts the element into the priority queue in a way that the minimum element always at the head of the queue
			} 
		}
		while (!pq.isEmpty()) { // run through the priority queue until it is empty
			Node curr = pq.poll(); // "poll" returns the head of the queue (minimum value)
			if (head == null) {
				head = curr; // first element
			} else {
				last.next = curr;
			}
			last = curr;
			if (curr.next != null) {// If the minimum node selected has a next node (in it's list).. add it to the priority queue
				pq.offer(curr.next);
			}
		}
		return head;
	}	
}

