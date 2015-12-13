package grinnell.edu.GrinProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GrinEncoder {

	private static Map<Integer, Integer> createFrequencyMap(String file) {
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		Scanner infileScanner = new Scanner(file);
		
		while (infileScanner.hasNext()) {
			int ch = Integer.parseInt(infileScanner.next());
			if (frequencyMap.containsKey(ch)) {
				frequencyMap.put(ch, frequencyMap.get(ch) + 1);
			} else {
				frequencyMap.put(ch, 1);
			}
		}
		infileScanner.close();
		
		return null;
	}
	
	public static void encode(String infile, String outfile) {
		
	}

}
