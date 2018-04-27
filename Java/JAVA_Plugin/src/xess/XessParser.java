//
// $Id: $
//
package xess;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * A simple interface for classes that may be used to parse an {@link Xess} 
 * from the source XML.  XML can be provided as the name of a file in the 
 * local file system, an {@link InputStream} that points to the XML data, or
 * a {@link Reader} that can be used to read the XML data.
 *
 * @author rstjacques
 */
public interface XessParser extends XmlConstants {	
	/**
	 * Parses an {@link Xess} from the specified file.
	 * 
	 * @param filename The name of the file containing the XML source for the
	 * {@link Xess} to be parsed.
	 * 
	 * @return The {@link Xess} parsed from the XML in the specified file.
	 * 
	 * @throws IOException If there is an error parsing.
	 */
	public Xess parseXess(String filename) throws IOException;
	
	/**
	 * Parses an {@link Xess} from the specified {@link InputStream}.
	 * 
	 * @param is The {@link InputStream} that contains the XML source for the
	 * {@link Xess} to be parsed.
	 * 
	 * @return The {@link Xess} parsed from the XML in the specified 
	 * {@link InputStream}.
	 * 
	 * @throws IOException If there is an error parsing.
	 */
	public Xess parseXess(InputStream is) throws IOException;
	
	/**
	 * Parses an {@link Xess} from the specified {@link Reader}.
	 * 
	 * @param r The {@link Reader} that contains the XML source for the
	 * {@link Xess} to be parsed.
	 * 
	 * @return The {@link Xess} parsed from the XML in the specified 
	 * {@link Reader}.
	 * 
	 * @throws IOException If there is an error parsing.
	 */
	public Xess parseXess(Reader r) throws IOException;
} // XessParser
