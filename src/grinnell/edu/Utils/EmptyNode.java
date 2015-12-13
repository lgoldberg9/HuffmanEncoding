package grinnell.edu.Utils;

import java.util.Map;

public class EmptyNode implements Node {
	
	public EmptyNode() {}

	@Override
	public int getSummaryFreq() { return 0; }

	@Override
	public int getCharacter() { return -1; }

	@Override
	public Node getLeft() { return null; }

	@Override
	public Node getRight() { return null; }

	@Override
	public void setLeft(Node left) {}

	@Override
	public void setRight(Node right) {}

	@Override
	public boolean isHuffmanNode() { return false; }

	@Override
	public void inorderTraversalToBinaryMap(Map<Integer, String> pathMap, String path) {}
	
	@Override
	public int compareTo(Node o) {
		return 1;
	}
}
