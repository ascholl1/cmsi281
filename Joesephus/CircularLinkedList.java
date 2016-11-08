import java.util.NoSuchElementException;

public class CircularLinkedList extends AbstractLinkedList implements CircularCollectible {
    Node last;

    public CircularLinkedList() {
        super();
	last = null;
    }

    public CircularLinkedList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        return (first == null);
    }

    public int size() {
        return n;
    }

    public void add(String s) {
	if (isEmpty()) {
	    super.add(s);
	    last = first; //if this is the first node to be added, it will be the last
	} else {
	    super.add(s);
	}
	last.next = first; //have the last node point to the first node
    }

    public String first() {
        return first.value;
    }

    public void remove(String s) {
            Node current = first;
	    Node previous = last;
	    if (first.value.equals(s)) {
		System.out.println("first: " + first.value);
		System.out.println("first.next: " + first.next.value);
		first = first.next;
		last.next = first;
		System.out.println("first: " + first.value);
	 	System.out.println("found it");
		System.out.println("found it");
		n--;
		return;
	    }
	    while(current != last) {
		if (current.value.equals(s)) {
		    previous.next = current.next;
		    n--; 
		    return;
		}
		previous = current;
		current = current.next;
	    }
	    if (last.value.equals(s)) {
		previous.next = first;
	        last = previous;
		n--;
	    }
		
        }

    public void removeAll(String s) {
	Node current = first;
	Node previous = last;
	while (first.value.equals(s)) {
	    System.out.println("first: " + first.value);
	    System.out.println("first.next: " + first.next.value);
	    first = first.next;
	    last.next = first;
	    System.out.println("first: " + first.value);
	    System.out.println("found it");
	    n--;
	}
	previous = first;
	current = previous.next;
	while(current != last) {
	    if (current.value.equals(s)) {
		previous.next = current.next;
		current = previous.next;
		n--; 
	    } else {
	    previous = current;
	    current = current.next;
	    }
	}
	if (last.value.equals(s)) {
	    previous.next = first;
	    last = previous;
	    n--;
	}
    }

    public CircularIterator iterator() {
        return new CircularLinkedListIterator(first, last, n);
    }

    class CircularLinkedListIterator implements CircularIterator {
	Node current;
	Node end;
	Node previous;
	int  elementNumber;
	int size;        

        public CircularLinkedListIterator(Node first, Node last, int n) {
            current = first;
	    previous = last;
	    end = last;
	    elementNumber = 1;
	    size = n;
        }

        public boolean hasNext() {
            return current != null;
        }

        public String next() { 
            if (!hasNext()) throw new NoSuchElementException();
	    previous = current;
	    current = current.next;
	    elementNumber++;
	    return previous.value;
        }

        public void remove() { //remove current node and return the value (string value)
            previous.next = current.next;
	    current = previous.next;
	    size--;
        }

        public String removeKthElement(int k) {
	    while (elementNumber != k) {
		this.next();
		System.out.println("current: " + this.current.value);
		System.out.println(elementNumber);
	    }
	    this.remove();
	    elementNumber = 1;
	    return current.value;
        }

        public boolean oneElementLeft() {
            return (size == 1);
        }

    }

    public static void main(String[] args) {
/*
	CircularLinkedList cll1 = new CircularLinkedList();
	cll1.add("lastpuppy");
	cll1.add("puppy2");
cll1.add("puppy");
	cll1.add("puppy3");
	cll1.add("puppy4");
cll1.add("puppy");
cll1.add("puppy");
cll1.add("puppy");
	System.out.println("First: " + cll1.first());
	System.out.println("First.next: " + cll1.first.next.value);
	System.out.println("Last: " + cll1.last.value);
	System.out.println("Last.next: " + cll1.last.next.value);
	System.out.println("Size: " + cll1.n);
	
	String string1 = "puppy";
	//cll1.removeAll(string1);
	//cll1.remove("puppy2");
CircularIterator i = cll1.iterator();
	System.out.println(i.hasNext());
	System.out.println(i.next());

System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
i.remove();
System.out.println("removed");
System.out.println(i.next());

System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
System.out.println(i.next());
System.out.println(cll1.n);
System.out.println("First: " + cll1.first());
System.out.println("Last: " + cll1.last.value);
*/

CircularLinkedList cll2 = new CircularLinkedList();
	cll2.add("element8");
	cll2.add("element7");
	cll2.add("element6");
	cll2.add("element5");
	cll2.add("element4");
	cll2.add("element3");
	cll2.add("element2");
	cll2.add("element1");
	CircularIterator f = cll2.iterator();
	
	f.removeKthElement(3);
	f.removeKthElement(3);
	f.removeKthElement(3);
	f.removeKthElement(3);
	f.removeKthElement(3);
	f.removeKthElement(3);
f.removeKthElement(3);
	System.out.println(f.next());
	System.out.println(f.next());
	System.out.println(f.next());
	System.out.println(f.next());
	System.out.println(f.next());
	System.out.println(f.next());
	System.out.println(f.next());
	System.out.println(f.next());
int k1 = 5;
    String [] test1 = { "Fido", "Delilah", "Rugrat", "Joshua", "Sid", 
                        "Bow-wow", "Bogo", "Pogo", "Mimi", "Chloe" };
CircularLinkedList linkedList = new CircularLinkedList(test1);
    for (CircularIterator i = linkedList.iterator(); !i.oneElementLeft(); ) {
      i.removeKthElement(k1);
    }
	System.out.println(linkedList.first());
	System.out.println(linkedList.first());
    assert linkedList.first() == "Rugrat";
	
    }
}

