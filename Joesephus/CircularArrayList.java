public class CircularArrayList extends AbstractArrayList implements CircularCollectible {  
    
    int indexOfLast;

    public CircularArrayList() {
        super();
	indexOfLast = 0;
    }

    public CircularArrayList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        return (elements[0] == null);
    }

    public int size() {
        return size;
    }

    public void add(String s) {
        super.add(s);
	indexOfLast = size - 1;
    }
    
    public String first() {
	return elements[0];
    }

    public void remove(String s) {
        for (int i = 0; i < size; i++) {
	    if (elements[i] == s) {
		for (int j = i; j < size; j++) {
		    elements[j] = elements[j+1];
		}
		size--;
		return;
	    }
	}
    }

    public void removeAll(String s) {
	int currentIndex = 0;
	while (elements[currentIndex] != null) {
	    if (elements[currentIndex] == s) {	
	        for (int i = currentIndex; i < size; i++) {
		    elements[i] = elements[i+1];
	        }
	        size--;
	    }
	    if (elements[currentIndex] != s) {
		currentIndex++;
	    }
	}
    }

    public CircularIterator iterator() {
        return new CircularArrayListIterator(elements, size, indexOfLast);
    }

    class CircularArrayListIterator implements CircularIterator {
	
	int currentIndex;
	int count;

        public CircularArrayListIterator(String [] elements, int size, int indexOfLast) {
	    currentIndex = 0;
	    count = 1;
        }
        
        public boolean hasNext() {
            return (elements[currentIndex + 1] != null);
        }

        public String next() {
	    int previousIndex = currentIndex;
	    if (currentIndex < size - 1) {
		currentIndex++;	
	    } else {
                currentIndex = 0;
	    }
	    count++;
	    return elements[previousIndex];
        }

        public void remove() { //removes the String at the currentIndex
            for (int i = currentIndex; i < size; i++) {
		    elements[i] = elements[i+1];
	    }
	    size--;
	    if (elements[currentIndex] == null) {
	        currentIndex = 0;
	    }
        }

        public String removeKthElement(int k) {
	    while(count != k) {
	        this.next();
	    }
	    this.remove();
	    count = 1;
	    return elements[currentIndex];
        }

        public boolean oneElementLeft() {
            return (size == 1);
        }
    }

     public static void main(String[] args) {
	CircularArrayList cal1 = new CircularArrayList();
	int k1 = 5;
        String [] test1 = { "Fido", "Delilah", "Rugrat", "Joshua", "Sid", 
                        "Bow-wow", "Bogo", "Pogo", "Mimi", "Chloe" };
        CircularArrayList arrayList = new CircularArrayList(test1);
        for (CircularIterator i = arrayList.iterator(); !i.oneElementLeft(); ) {
            i.removeKthElement(k1);
        }
        System.out.println("first element" + arrayList.elements[0]);
	cal1.add("element1");	
	cal1.add("element2");
	cal1.add("element3");
	cal1.add("element4");
	cal1.add("element5");
	cal1.add("element6");
	cal1.add("element7");
	cal1.add("element8");
	CircularIterator i = cal1.iterator();
	i.removeKthElement(3);
        i.removeKthElement(3);
	i.removeKthElement(3);
	i.removeKthElement(3);
	i.removeKthElement(3);
	i.removeKthElement(3);
	i.removeKthElement(3);
 	System.out.println("cal1 first: " + cal1.first());
	CircularArrayList cal2 = new CircularArrayList();
	cal2.add("Fido");
	cal2.add("Delilah");
	cal2.add("Rugrat");
	cal2.add("Joshua");
	cal2.add("Sid");
	cal2.add("Bowow");
	cal2.add("Bogo");
	cal2.add("Pogo");
	cal2.add("Mimi");
	cal2.add("Chloe");
	for (CircularIterator f = cal2.iterator(); !f.oneElementLeft(); ) {
      	    f.removeKthElement(k1);
        }
	System.out.println("cal2 first: " + cal2.first());
/*
	System.out.println(i.next());
	System.out.println(i.next());
	System.out.println(i.next());
	System.out.println(i.next());
	System.out.println(i.next());
	System.out.println(i.next());
	System.out.println(i.next());
	System.out.println(i.next());
*/
    }


}
