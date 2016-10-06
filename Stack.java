public class Stack {
	Node top;
	int size;

	public Stack() {
		top = null;
		size = 0;
	}
	
	public void push(String s) {
		Node newTop = new Node(top, s);
		top = newTop;
		size++;
	}
	
	public String pop() {
		String removed = top.value;
		top = top.next;
		size--;
		return removed;
	}

	public String peek() {
		return top.value;
	}

	class Node {
		Node next;
		String value;	
		
		public Node(Node next, String value) {
			this.next = next;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Stack stack1 = new Stack();
		stack1.push("hello");
		System.out.println(stack1.peek());
	}

}

