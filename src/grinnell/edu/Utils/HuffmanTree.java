package grinnell.edu.Utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import grinnell.edu.Streams.BitInputStream;
import grinnell.edu.Streams.BitOutputStream;

public class HuffmanTree {

	private Node root;
	
	// Map is character in ASCII to frequency.
	public HuffmanTree(Map<Integer, Integer> m) {
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		
		for (Entry<Integer, Integer> keys : m.entrySet()) {
			queue.add(new HuffmanNode(keys.getKey(), keys.getValue()));
		}
		
		while (queue.size() > 1) {
			Node left = queue.poll();
			Node right = queue.poll();
			queue.add(new HuffmanNode(-1, left.getSummaryFreq() + right.getSummaryFreq(), left, right));
		}
		
		this.root = queue.poll();
		
	}
	
	public void encode(List<Character> charList, BitOutputStream stream) {
		Map<Integer, String> encodeMap = root.inorderTraversalToBinaryMap();
	}
	
	public List<Character> decode(BitInputStream stream) {
		Map<Integer, String> decodeMap = root.inorderTraversalToBinaryMap();
		
		
		return null;
	}
}
