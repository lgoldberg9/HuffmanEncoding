package grinnell.edu.Utils;

import java.util.Map;

public interface Node {

	/**
	 * 
	 * @return
	 */
	public int getSummaryFreq();
	
	/**
	 * 
	 * @return
	 */
	public int getCharacter();
	
	/**
	 * 
	 * @return
	 */
	public Node getLeft();
	
	/**
	 * 
	 * @return
	 */
	public Node getRight();
	
	/**
	 * 
	 * @param left
	 */
	public void setLeft(Node left);
	
	/**
	 * 
	 * @param right
	 */
	public void setRight(Node right);
	
	/**
	 * 
	 * @return 
	 */
	public boolean isHuffmanNode();
	
	/**
	 * Produces a Map<Integer, String> where each key is the character
	 * and each string is the binary representation of the path taken to that character.
	 * @return treeMap, a path map of all the characters from the root.
	 */
	public Map<Integer, String> inorderTraversalToBinaryMap();
	
}
