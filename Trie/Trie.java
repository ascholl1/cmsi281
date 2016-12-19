//public void addWord(String word)
//public int countPreffixes(String prefix)
//public int countWords(String word)
//int words;
//int prefixes;
//int edges[26];
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Trie {
    TrieNode root;

    public Trie() {
	root = new TrieNode('\0');
    }

    class TrieNode {
	char value;
	int wordCount;
	TrieNode[] children;
	boolean isLeaf;
	String word;
	
	public TrieNode(char value) {
	    this.value = value;
	    this.wordCount = 0;
	    this.isLeaf = true;
	    this.children = new TrieNode[26];
	    this.word = "";
	}
    }    
 
	public void addWord(String word) {
	    TrieNode currentNode = root;
	    char c = ' ';
	    for (int i = 0; i < word.length(); i++){ 
		if (Character.isLetter(word.charAt(i))) {
		    c = word.charAt(i);
		    if ((currentNode.children[getIndex(c)] == null)) { //if letter isn't there and it is a Letter
		        TrieNode nextLetter = new TrieNode(c);
		        currentNode.children[getIndex(c)] = nextLetter;
		        currentNode.isLeaf = false;
		        currentNode = nextLetter;
		    } else { //if letter is there
		        currentNode = currentNode.children[getIndex(c)]; //set currentnode to corresponding child node
		    }
		}
	    }
	    currentNode.wordCount++;
	}

	public int getIndex(char c) {
	    if (c == 'a') {
		return 0;
	    } 
	    if (c == 'b') {
		return 1;
	    }
	    if (c == 'c') {
		return 2;
	    }
	    if (c == 'd') {
		return 3;
	    }
  	    if (c == 'e') {
		return 4;
	    } 
	    if (c == 'f') {
		return 5;
	    }
	    if (c == 'g') {
		return 6;
	    }
	    if (c == 'h') {
		return 7;
	    }
	    if (c == 'i') {
		return 8;
	    } 
	    if (c == 'j') {
		return 9;
	    }
	    if (c == 'k') {
		return 10;
	    }
	    if (c == 'l') {
		return 11;
	    }
  	    if (c == 'm') {
		return 12;
	    } 
	    if (c == 'n') {
		return 13;
	    }
	    if (c == 'o') {
		return 14;
	    }
	    if (c == 'p') {
		return 15;
	    }
	    if (c == 'q') {
		return 16;
	    } 
	    if (c == 'r') {
		return 17;
	    }
	    if (c == 's') {
		return 18;
	    }
	    if (c == 't') {
		return 19;
	    }
  	    if (c == 'u') {
		return 20;
	    } 
	    if (c == 'v') {
		return 21;
	    }
	    if (c == 'w') {
		return 22;
	    }
	    if (c == 'x') {
		return 23;
	    }
	    if (c == 'y') {
		return 24;
	    } 
	    if (c == 'z') {
		return 25;
	    } else {
	        return -1;
	    }
	}

	public void traverseTrie(TrieNode node, String partialWord) {
	    String s = partialWord + node.value;
	    if (node.wordCount > 0) {
	        System.out.println(s + "  " + node.wordCount);
	    }
	    for(int i = 0; i < 26; i++) {
		if(node.children[i] != null) {
		    traverseTrie(node.children[i], s);
		}
	    }
	}

	public ArrayList<TrieNode> findMaxes(TrieNode node, String partialWord, ArrayList<TrieNode> words) {
	    String s = partialWord + node.value;
	    if (node.wordCount > 0) {
		if (!isArticle(s)) {
                    node.word = s;
		
		    words.add(node);
		}
		
	       // System.out.println("added to max array " + s + "  " + node.wordCount);
	    }
	    for(int i = 0; i < 26; i++) {
		if(node.children[i] != null) {
		    findMaxes(node.children[i], s, words);
		}
	    }
	    return words;
	}

	public boolean isArticle(String word) {
	    String str = word.trim();
	    if (str.equals("a")) {
		return true;
	    }
	    if (str.equals("and")) {
		return true;
	    }
	    if (str.equals("of")) {
		return true;
	    }
	    if (str.equals("to")) {
		return true;
	    }
	     if (str.equals("that")) {
		return true;
	    }
	    if (str.equals("is")) {
		return true;
	    }
	    if (str.equals("in")) {
		return true;
	    }
	    if (str.equals("for")) {
		return true;
	    }
	     if (str.equals("are")) {
		return true;
	    }
	    if (str.equals("from")) {
		return true;
	    }
	    if (str.equals("")) {
		return true;
	    }
	    if (str.equals("it")) {
		return true;
	    }
	    if (str.equals("with")) {
		return true;
	    }
	    if (str.equals("were")) {
		return true;
	    }
	    if (str.equals("what")) {
		return true;
	    }
	    if (str.equals("on")) {
		return true;
	    }
	    if (str.equals("out")) {
		return true;
	    }
	    if (str.equals("this")) {
		return true;
	    }
	    if (str.equals("its")) {
		return true;
	    }
	    if (str.equals("the")) {
		return true;
	    } else {
	        return false;
	    }
	}
	 
        // Bubble Sort Method for Descending Order 
        public static void BubbleSort(ArrayList<TrieNode> num) {
            int j;
            boolean flag = true;   // set flag to true to begin first pass
            TrieNode temp;   //holding variable

            while (flag) {
                flag= false;    //set flag to false awaiting a possible swap
                for( j=0;  j < num.size()-1;  j++ ) {
                    if (num.get(j).wordCount < num.get(j+1).wordCount) {  
                        temp = num.get(j);                //swap elements
                        num.set(j, num.get(j+1));
                        num.set((j+1), temp);
                        flag = true;              //shows a swap occurred  
                    } 
                } 
            } 
        } 

	public static void main(String[] args) throws IOException {
	    Trie trie1 = new Trie();
	    Scanner s = null;
	    try {
	        s = new Scanner(System.in);
		while (s.hasNext()) {
		    String item = s.next().toLowerCase();
		    //item.replaceAll(".,:;'?!", "");
		    trie1.addWord(item);
		} 
	    } finally {
		    if (s != null) {
			s.close();
		    }
	    }
	    trie1.addWord("apple");
	    trie1.addWord("apple");
	    trie1.addWord("app");
	    trie1.addWord("pizza");
	    trie1.addWord("ape");
	    trie1.addWord("zoo");
	    trie1.addWord("pizza");
	    TrieNode rootNode = trie1.root;
	    TrieNode aNode = rootNode.children[0];
	    TrieNode apNode = aNode.children[15];
	    TrieNode appNode = apNode.children[15];
	  //  System.out.println("aNode: " + aNode.value);
	    //System.out.println("pNode: " + rootNode.children[15].value);
	    //System.out.println("apNode: " + apNode.value);
	    //System.out.println("appNode: " + apNode.value);
	    //trie1.printTrie(root, "");
	    //System.out.println(trie1.words[0]);
	    ArrayList<TrieNode> words = new ArrayList<TrieNode>();
	   // trie1.traverseTrie(trie1.root, "");
	    LinkedList list = new LinkedList();
	    ArrayList<TrieNode> wordList = trie1.findMaxes(trie1.root, "", words);
	    BubbleSort(wordList);
	    
	    for(int i = 0; i < 20; i++) {
		System.out.println((i + 1) + ". " + wordList.get(i).word);
		System.out.println("Frequency: " + wordList.get(i).wordCount);
		System.out.println();
	    }
	    
	}

}