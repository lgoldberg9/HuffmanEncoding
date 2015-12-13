/**
 * 
 */
package grinnell.edu.GrinProgram;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import grinnell.edu.Streams.BitInputStream;

/**
 * @author goldberg, takayesu17
 *
 */
public final class grin {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//GrinDecoder.decode("data/huffman-example.grin", "data/huffman-example-try.txt");

		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		Reader infileStream = new StringReader("data/huffman-example.txt");
		
		int pointer;
		while ((pointer = infileStream.read()) != -1) {
			System.out.println(pointer);
		};
		
		
	}

}
