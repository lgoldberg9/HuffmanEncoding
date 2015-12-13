package grinnell.edu.GrinProgram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

import grinnell.edu.Streams.BitInputStream;
import grinnell.edu.Utils.HuffmanTree;

public class GrinDecoder {
	
	private static void writeToFile(List<Character> charList, String outfile) 
			throws FileNotFoundException {
		PrintStream output = new PrintStream(outfile);
		
		for (Character ch : charList) {
			output.write(ch);
		}
		output.close();
	}

	public static void decode(String infile, String outfile) {
		
		BitInputStream inputStream = new BitInputStream(infile);
		
		if (inputStream.readBits(32) != 1846) {
			throw new IllegalArgumentException();
		} else {
			int sizeOfCharMap = inputStream.readBits(32);
			Map<Integer, Integer> charMap = new HashMap<Integer, Integer>(sizeOfCharMap);
			for (int i = 0; i < sizeOfCharMap; i++) {
				charMap.put(inputStream.readBits(32), inputStream.readBits(32));
			}
			HuffmanTree HASSLEHOFF = new HuffmanTree(charMap);
			try {
				writeToFile(HASSLEHOFF.decode(inputStream), outfile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		inputStream.close();
	}
}
