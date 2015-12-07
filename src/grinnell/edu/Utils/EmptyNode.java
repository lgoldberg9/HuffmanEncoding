package grinnell.edu.Utils;

public class EmptyNode implements Node {

	public EmptyNode() {}

	@Override
	public Node insert(char c, int freq) {
		return new LeafNode(c, freq);
	}

	@Override
	public boolean isEmptyNode() {
		return true;
	}

}
