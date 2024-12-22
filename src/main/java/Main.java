
public class Main {
	
	public static Node<Integer> buildList(int[] a) { 
		Node<Integer> h = new Node<Integer>(-1); 
		Node<Integer> p = h; 
		Node<Integer> x; 
		for (int i = 0; i < a.length; i++) { 
			x = new Node<Integer>(a[i]); 
			p.setNext(x); 
			p = p.getNext(); 
		} 
		return h.getNext(); 
	} 

	public static Node<Integer> ex1(Node<Integer> L1, Node<Integer> L2){
		Node<Integer> L3 = new Node<Integer>(-1);
		Node<Integer> current = L3;
		Node<Integer> h = L1;
		Node<Integer> p = L2;
		while (h != null && p != null) {
			if (h.getValue() <= p.getValue()) {
				current.setNext(h);
				h = h.getNext();
			}
			else {
				current.setNext(p);
				p = p.getNext();
			}
			current = current.getNext();
		}
		
		if (h != null) {
			current.setNext(h);
		}
		
		if (p != null) {
			current.setNext(p);
		}
		return L3.getNext();
	}

	public static Node<Integer> ex2(Node<Integer> L){
		Node<Integer> dummy = new Node<Integer>(-1, L);
		Node<Integer> head = new Node<Integer>(-1);
		Node<Integer> p = dummy;
		Node<Integer> h = head;
		
		while (p.hasNext()) {
			p = dummy;
			Node<Integer> m = dummy;
			int min = p.getNext().getValue();
			
			while (p.hasNext()) {
				if(p.getNext().getValue() < min) {
					m=p;
					min = p.getNext().getValue();
				}
				p = p.getNext();
			}
			
			h.setNext(m.getNext());
			h = h.getNext();
			m.setNext(m.getNext().getNext());
		}
		return head.getNext();
	}
	
	public static void main(String[] args) {
		
		int[] arr = {8,4,2,9};
		int[] arr1 = {1,3,3,5,6};
	
		Node<Integer> L1 = buildList(arr1); 		
		Node<Integer> L2 = buildList(arr); 	
		
		System.out.println(ex1(L1,L2));
		System.out.println(ex2(L2));

	}
}


