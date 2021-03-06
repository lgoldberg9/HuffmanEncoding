package grinnell.edu.Utils;

import java.util.Map;

public class HuffmanNode implements Node, Comparable<Node> {
	private int summaryFreq;
	private int character;
	private Node left;
	private Node right;
	
	/**
	 * 
	 * @param summaryFreq, sum of freq of subtree characters.
	 * @param character, character stored at node.
	 * @param left, left branch of node.
	 * @param right, right branch of node.
	 */
	public HuffmanNode(int character, int summaryFreq, Node left, Node right) {
		this.character = character;
		this.summaryFreq = summaryFreq;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * 
	 * @param value, T to be at the node.
	 */
	public HuffmanNode(int character, int summaryFreq) {
		this(character, summaryFreq, new EmptyNode(), new EmptyNode());
	}

	@Override
	public int getSummaryFreq() { return this.summaryFreq; }

	@Override
	public int getCharacter() { return this.character; }

	@Override
	public Node getLeft() { return this.left; }

	@Override
	public Node getRight() { return this.right; }

	@Override
	public void setLeft(Node left) { this.left = left; }

	@Override
	public void setRight(Node right) { this.right = right; }

	@Override
	public boolean isHuffmanNode() { return true; }

	@Override
	public void inorderTraversalToBinaryMap(Map<Integer, String> pathMap, String path) {
		if (isHuffmanNode()) {
			this.left.inorderTraversalToBinaryMap(pathMap, path + "0");
			pathMap.put(this.character, path);
			this.right.inorderTraversalToBinaryMap(pathMap, path + "1");
		}
	}

	@Override
	public int compareTo(Node o) {
		if (o.getSummaryFreq() > this.summaryFreq) {
			return -1;
		} else if (o.getSummaryFreq() < this.summaryFreq) {
			return 1;
		} else {
			return 0;
		}
	}
}