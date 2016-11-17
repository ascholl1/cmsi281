class LinkedListSet {
    class Node {
	Node next;
	String value;

	public Node(Node next, String value) {
	    this.next = next;
            this.value = value;
	}
    }

    Node first;
    int n;

    public LinkedListSet() {
        first = null;
        n = 0;
    } 

    public void add(String s) {
	if (first == null) {
	    first = new Node(first, s);
            n++;
	    return;
	}
	if (first.value.equals(s)) {
	    return;
	}
	Node current = first.next;
	Node previous = first;
	while (current != null) {
	    if ((current.value).equals(s)) {
		return;
	    } else {
		previous = current;
		current = current.next;
	    }
	}
	first = new Node(first, s);
        n++;
    }

    public String remove(String s) {
	String temp = s;
	if (first.value.equals(s)) {
	    first = first.next;
	    n--;
	    return temp;
	}
	Node current = first.next;
	Node previous = first;
	while (current != null) {
	    if ((current.value).equals(s)) {
		previous.next = current.next;
		n--;
		return temp;
	    } else {
		previous = current;
		current = current.next;
	    }
	}
	return "String not present";
    }

    public static void main(String[] args) {
	LinkedListSet list1 = new LinkedListSet();
	list1.add("six");
	list1.add("six");
	list1.add("six");
	list1.add("three");	
	list1.add("five");
	list1.add("three");
	list1.add("five");
	list1.add("three");
	list1.add("two");
	System.out.println(list1.first.value);
	System.out.println(list1.first.next.value);
	System.out.println(list1.first.next.next.value);
	System.out.println(list1.first.next.next.next.value);
        //System.out.println(list1.first.next.next.next.next.value);
	System.out.println("Removed string: " + list1.remove("two"));
	System.out.println(list1.first.value);
	System.out.println(list1.first.next.value);
	System.out.println(list1.first.next.next.value);
	System.out.println(list1.first.next.next.next.value);
    }
    
}