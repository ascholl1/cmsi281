import java.util.Iterator;

public class JosephusSolver {

  public static void main(String[] args) {
    int k1 = 5;
    int k2 = 3;
    String [] test1 = { "Fido", "Delilah", "Rugrat", "Joshua", "Sid", 
                        "Bow-wow", "Bogo", "Pogo", "Mimi", "Chloe" };
    CircularArrayList arrayList = new CircularArrayList(test1);
    for (CircularIterator i = arrayList.iterator(); !i.oneElementLeft(); ) {
      i.removeKthElement(k1);
    }
    assert arrayList.first() == "Rugrat";

    CircularLinkedList linkedList = new CircularLinkedList(test1);
    for (CircularIterator i = linkedList.iterator(); !i.oneElementLeft(); ) {
      i.removeKthElement(k1);
    }
    assert linkedList.first() == "Rugrat";

    String [] test2 = { "element1", "element2", "element3", "element4", "element5", 
                        "element6", "element7", "element8" };
    CircularArrayList arrayList2 = new CircularArrayList(test2);
    for (CircularIterator i = arrayList2.iterator(); !i.oneElementLeft(); ) {
      i.removeKthElement(k2);
    }
    assert arrayList.first() == "element7";

    CircularLinkedList linkedList2 = new CircularLinkedList(test2);
        for (CircularIterator i = linkedList2.iterator(); !i.oneElementLeft(); ) {
            i.removeKthElement(k2);
        }
        assert linkedList.first() == "element7";
    }
}
