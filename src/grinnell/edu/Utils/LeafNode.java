package grinnell.edu.Utils;

public class LeafNode implements Node {

	private char storedChar;
	private int charFreq;
	
	public LeafNode(char c, int freq) {
		this.storedChar = c;
		this.charFreq = freq;
	}
	
	@Override
	public Node insert(char c, int freq) {
		if (this.storedChar == c) {
			return new LeafNode(c, freq);
		} else {
			InternalNode newInternalNode = new InternalNode(0, new EmptyNode(), new EmptyNode());
			
			newInternalNode.insert(this.storedChar, this.charFreq);
			newInternalNode.insert(c, freq);
			
			return newInternalNode;
		}
	}

	@Override
	public boolean isEmptyNode() {
		return false;
	}
}
