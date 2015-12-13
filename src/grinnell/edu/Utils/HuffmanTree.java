package grinnell.edu.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

import grinnell.edu.Streams.BitInputStream;
import grinnell.edu.Streams.BitOutputStream;

public class HuffmanTree {

	private Node root;
	
	// Map is character in ASCII to frequency.
	public HuffmanTree(Map<Integer, Integer> m) {
		if (m == null) {
			throw new IllegalArgumentException();
		} else {
			PriorityQueue<Node> queue = new PriorityQueue<Node>();

			for (Entry<Integer, Integer> keys : m.entrySet()) {
				HuffmanNode node = new HuffmanNode(keys.getKey(), keys.getValue());
				queue.add(node);
			}

			while (queue.size() > 1) {
				Node left = queue.poll();
				Node right = queue.poll();
				HuffmanNode node = new HuffmanNode(-1, left.getSummaryFreq() + right.getSummaryFreq(), 
						left, right);
				queue.add(node);
			}
			this.root = queue.poll();
		}
	}
	
	public void encode(List<Integer> charList, BitOutputStream stream) {
		if (charList == null || stream == null) {
			throw new IllegalArgumentException();
		} else {
			Map<Integer, String> encodeMap = this.inorderTraversalToBinaryMap();

			for (Integer ch : charList) {
				String bitsToWrite = encodeMap.get(ch);
				for (int chIndex = 0; chIndex < bitsToWrite.length(); chIndex++) {
					Character bit = bitsToWrite.charAt(chIndex);
					if (bit.equals('0')) {
						stream.writeBit(0);
					} else if (bit.equals('1')) {
						stream.writeBit(1);
					} else {
						throw new IllegalArgumentException();
					}
				}
			}
		}
	}
	
	public List<Character> decode(BitInputStream stream) {
		if (stream == null) {
			throw new IllegalArgumentException();
		} else {
			Node currentNode = this.root;
			List<Character> charList = new ArrayList<Character>();

			int bit = -1;

			while ((bit = stream.readBit()) != -1) {
				if (bit == 0) {
					currentNode = currentNode.getLeft();
				} else if (bit == 1) {
					currentNode = currentNode.getRight();
				} else {
					throw new IllegalArgumentException();
				}
				int currentCh = currentNode.getCharacter();
				if (currentCh != -1) {
					charList.add((char) currentCh);
					currentNode = this.root;
				}
			}
			return charList;
		}
	}
	
	public Map<Integer, String> inorderTraversalToBinaryMap() {
		Map<Integer, String> pathMap = new TreeMap<Integer, String>();
		this.root.inorderTraversalToBinaryMap(pathMap, "");
		return pathMap;
	}
	
}
