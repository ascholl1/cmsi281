import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Bag implements Collectible {
    private Node first;
    private int n; // number of nodes
    private int total; // total number of items in this bag

    // Implement a constructor
    public Bag() {
	first = null;
	n = 0;
	total = 0;
    }

    // Implement Collectible interface methods here
    public boolean isEmpty() {
	return first == null;
    }

    public int size() {
	return total;
    }

    public void add(String s) {
	int count = 1;
	Node node1 = new Node(first, s, count);
	node1.next = first;
	first = node1;
	n++;
    }

    public int uniqueSize() {
      return n;
    }

    public Obliterator iterator() {
        return new BagIterator(first);  
    }

    class BagIterator implements Obliterator {
        private Node current;

        public BagIterator(Node first) {
            current = first;
        }

        public boolean hasNext() { 
            return current != null;  
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Node next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = current;
            current = current.next; 
            return node;
        }
	
    }


    public static void main(String[] args) throws IOException {
        Bag bag = new Bag();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
		boolean unique = true;
		for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            	    Node node = i.next();
                    if (item.equals(node.item)) {
			unique = false;
			node.count++;
		    }
		}
		if (unique) {
		bag.add(item);
		}
		bag.total++;
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        // Print bag size and distinct contents
        System.out.format("Total number of items: %d\n", bag.size());
        System.out.format("Unique number of items: %d\n", bag.uniqueSize());

        // Print distinct items in bag and their frequency
        for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            Node node = i.next();
            System.out.format("%s %d\n", node.item, node.count);
        }
    }

}
