//
// $Id: $
//

package xess;

/**
 * A simple interface for objects that can translate themselves into 
 * XML-formatted {@link String Strings}.
 *
 * @author rstjacques
 */
public interface XmlElement extends XmlConstants {
	/**
	 * Returns the {@link XmlElement} as an XML-formatted {@link String}.
	 * 
	 * @return The {@link XmlElement} as an XML-formatted {@link String}.
	 */
	public String toXml();
} // XmlElement
