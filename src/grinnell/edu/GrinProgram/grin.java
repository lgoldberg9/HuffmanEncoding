/**
 * 
 */
package grinnell.edu.GrinProgram;

import java.io.IOException;

/**
 * @author goldberg, takayesu17, cummings
 *
 */
public final class grin {
	
	private static final boolean debug = true;
	
	public static void usage() {
		System.out.println("Usage: grin <encode|decode> <infile> <outfile>");
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		if (debug) {
			GrinEncoder.encode("data/huffman-example.txt", "data/huffman-example-try.grin");
			GrinDecoder.decode("data/huffman-example-try.grin", "data/huffman-example-good.txt");
		} else {
			if (args.length != 3) {
				usage();
			} else {
				String code = args[0].toLowerCase().trim();
				if (code.equals("encode")) {
					GrinEncoder.encode(args[1], args[2]);
				} else if (code.equals("decode")) {
					GrinDecoder.decode(args[1], args[2]);
				} else {
					usage();
				}
			}
		}
	}
}
