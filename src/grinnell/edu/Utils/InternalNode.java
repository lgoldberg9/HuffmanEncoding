package grinnell.edu.Utils;

public class InternalNode implements Node {

	private int summaryOfChildrenFreq;
	private Node left;
	private Node right;
	
	public InternalNode(int freq, Node left, Node right) {
		this.summaryOfChildrenFreq = freq;
		this.left = left;
		this.right = right;
	}
	
	public int getFreq() {
		return this.summaryOfChildrenFreq;
	}
	
	public void addFreq(int n) {
		this.summaryOfChildrenFreq += n;
	}
	
	public Node insert(char c, int freq) {
		this.summaryOfChildrenFreq += freq;
		
		if (this.left.isEmptyNode()) {
			this.left = left.insert(c, freq);
		} else {
			this.right = right.insert(c, freq);
		}
		
		return this;
	}

	@Override
	public boolean isEmptyNode() {
		return false;
	}

}
