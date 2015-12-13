package grinnell.edu.GrinProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import grinnell.edu.Streams.BitOutputStream;
import grinnell.edu.Utils.HuffmanTree;

public class GrinEncoder {

	private static Map<Integer, Integer> createFrequencyMap(String file) throws IOException {
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		BufferedReader infileReader = new BufferedReader(new FileReader(file));

		int ch;
		
		while ((ch = infileReader.read()) != -1) {
			if (frequencyMap.containsKey(ch)) {
				frequencyMap.put(ch, frequencyMap.get(ch) + 1);
			} else {
				frequencyMap.put(ch, 1);
			}
		}
		
		infileReader.close();

		return frequencyMap;
	}

	public static void encode(String infile, String outfile) throws IOException {
		Map<Integer, Integer> freqMap = createFrequencyMap(infile);
		Set<Integer> keySet = freqMap.keySet();
		
		BitOutputStream outputStream = new BitOutputStream(outfile);
		
		outputStream.writeBits(1846, 32);
		outputStream.writeBits(freqMap.size(), 32);
		
		for (Integer ch : keySet) {
			outputStream.writeBits(ch, 32);
			outputStream.writeBits(freqMap.get(ch), 32);
		}
		
		List<Integer> charMap = new ArrayList<Integer>();
		BufferedReader infileReader = new BufferedReader(new FileReader(infile));
		int ch = -1;
		while ((ch = infileReader.read()) != -1) {
			charMap.add(ch);
		}
		
		HuffmanTree HASSLEHOFF = new HuffmanTree(freqMap);
		HASSLEHOFF.encode(charMap, outputStream);

		infileReader.close();
		outputStream.close();
	}
}
