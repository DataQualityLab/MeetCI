//
// $Id: $
//
package xess;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * An {@link Xess} is an object representation of an expert system; 
 * essentially it is a collection of {@link Fact facts}, {@link Rule rules}, 
 * and comments.  The {@link Xess} provides methods for adding and removing
 * each of these expert system components, as well as generating an XML 
 * snapshot of the system through the {@link #toXml()} method.<P> 
 *
 * @author rstjacques
 */
public class Xess implements XmlElement {	
	/**
	 * The current {@link Collection} of {@link Rule Rules} in the system.
	 */
	private final Collection<Rule> rules;
	
	/**
	 * The current {@link Collection} of {@link Fact Facts} that represent the
	 * knowledge base of the system.
	 */
	private final Collection<Fact> facts;
	
	/**
	 * The current {@link Collection} of comments in the system.
	 */
	private final Collection<String> comments;
	
	/**
	 * A {@link Collection} used to store the step-by-step trace that is used
	 * to determine how the expert system arrived at its conclusions.
	 */
	private final Collection<String> trace;
	
	/**
	 * Creates a new {@link Xess} with empty collections of 
	 * {@link Fact facts}, {@link Rule rules}, and comments.
	 */
	public Xess() {
		rules = new LinkedList<Rule>();
		facts = new LinkedList<Fact>();
		comments = new HashSet<String>();
		trace = new LinkedList<String>();
	}
	
	public String toXml() {
		StringBuffer buf = new StringBuffer();
		buf.append( XML_VERSION );
		buf.append( "<" );
		buf.append( XESS );
		buf.append( ">" );
		// comments
		synchronized( comments ) {
			for( String comment : comments ) {
				buf.append( "<" );
				buf.append( COMMENT );
				buf.append( ">" );
				buf.append( comment );
				buf.append( "</" );
				buf.append( COMMENT );
				buf.append( ">" );
			}
		}
		// facts
		synchronized( facts ) {
			for( Fact fact : facts ) {
				buf.append( fact.toXml());
			}
		}
		// rules
		synchronized( rules ) {
			for( Rule rule : rules ) {
				buf.append( rule.toXml());
			}
		}
		buf.append( "</" );
		buf.append( XESS );
		buf.append( ">" );
		return buf.toString();
	}

	//
	// methods for manipulating rules
	//
	
	/**
	 * Returns a {@link Collection} containing the 
	 * {@link Rule#getName() names} of the {@link Rule rules} currently in the
	 * system.
	 * 
	 * @return A {@link Collection} containing the 
	 * {@link Rule#getName() names} of the {@link Rule rules} in the system.
	 */
	public Collection<String> getRuleNames() {
		synchronized( rules ) {
			Collection<String> names = new ArrayList<String>( rules.size());
			for( Rule rule : rules ) {
				names.add( rule.getName());
			}
			return names;
		}
	}
	
	/**
	 * Returns a {@link Collection} containing the {@link Rule rules}
	 * currently in the system.
	 * 
	 * @return A {@link Collection} containing the {@link Rule rules}
	 * currently in the system.
	 */
	public Collection<Rule> getRules() {
		synchronized( rules ) {
			//copy and return
			return new ArrayList<Rule>( rules );
		}
	}
	
	/**
	 * Returns the {@link Rule} with the specified 
	 * {@link Rule#getName() name}.
	 * 
	 * @param name The {@link Rule#getName() name} of the {@link Rule} that
	 * should be retrieved.
	 * 
	 * @return The {@link Rule} with the specified 
	 * {@link Rule#getName() name}, if it exists; null otherwise.
	 */
	public Rule getRule( String name ) {
		synchronized( rules ) {
			Rule match = null;
			for( Rule r : rules ) {
				if( r.getName().equals( name )) {
					match = r;
					break;
				}
			}
			return match;
		}
	}
	
	/**
	 * Adds the specified {@link Rule} to the system.  If a {@link Rule} with
	 * the same {@link Rule#getName() name} already exists, it will be 
	 * replaced by the new {@link Rule}.
	 * 
	 * @param r The {@link Rule} to add to the system.
	 */
	public void addRule( Rule r ) {
		synchronized( rules ) {
			rules.add( r );
		}
	}
	
	/**
	 * Removes the specified {@link Rule} from the system.
	 * 
	 * @param r The {@link Rule} to be removed from the system.
	 */
	public void removeRule( Rule r ) {
		synchronized( rules ) {
			rules.remove( r );
		}
	}
	
	/**
	 * Clears all of the current {@link Rule rules} from the system.
	 */
	public void clearRules() {
		synchronized( rules ) {
			rules.clear();
		}
	}
	
	//
	// methods for manipulating facts
	//
	
	/**
	 * Returns a {@link Collection} containing the names of all of the 
	 * {@link Fact facts} currently in the system.
	 * 
	 * @return A {@link Collection} containing the names of all of the
	 * {@link Fact facts} in the system.
	 */
	public Collection<String> getFactNames() {
		synchronized( facts ) {
			Collection<String> names = new ArrayList<String>();
			for( Fact f : facts ) {
				names.add( f.getName());
			}
			return names;
		}
	}
	
	/**
	 * Returns a {@link Collection} containing the {@link Fact facts}
	 * currently in the system.
	 * 
	 * @return A {@link Collection} containing the {@link Fact facts}
	 * currently in the system.
	 */
	public Collection<Fact> getFacts() {
		synchronized( facts ) {
			return new ArrayList<Fact>( facts );
		}
	}
	
	/**
	 * Returns the {@link Fact} with the specified 
	 * {@link Fact#getName() name}.
	 * 
	 * @param name The {@link Fact#getName() name} of the {@link Fact} that
	 * should be retrieved.
	 * 
	 * @return The {@link Fact} with the specified 
	 * {@link Fact#getName() name}, if it exists; null otherwise.
	 */
	public Fact getFact( String name ) {
		synchronized( facts ) {
			Fact match = null;
			for( Fact f : facts ) {
				if( f.getName().equals( name )) {
					match = f;
					break;
				}
			}
			return match;
		}
	}
	
	/**
	 * Adds the specified {@link Fact} to the system.  If a {@link Fact} with
	 * the same {@link Fact#getName() name} already exists, it will be 
	 * replaced by the new {@link Fact}.
	 * 
	 * @param f The {@link Fact} to add to the system.
	 */
	public void addFact( Fact f ) {
		synchronized( facts ) {
			facts.add( f );
		}
	}
	
	/**
	 * Removes the specified {@link Fact} from the system.
	 * 
	 * @param f The {@link Fact} to be removed from the system.
	 */
	public void removeFact( Fact f ) {
		synchronized( facts ) {
			facts.remove( f );
		}
	}
	
	/**
	 * Clears all of the current {@link Fact facts} from the system.
	 */
	public void clearFacts() {
		synchronized( facts ) {
			facts.clear();
		}
	}
	
	//
	// methods for manipulating comments
	//	
	
	/**
	 * Returns a {@link Collection} containing all of the comments currently 
	 * in the system.
	 * 
	 * @return A {@link Collection} containing all of the comments currently
	 * in the system.
	 */
	public Collection getComments() {
		synchronized( comments ) {
			Collection<String> copy = new HashSet<String>();
			copy.addAll( comments );
			return copy;
		}
	}
	
	/**
	 * Adds the specified comment to the system.
	 * 
	 * @param c The comment to add to the system.
	 */
	public void addComment( String c ) {
		synchronized( comments ) {
			comments.add( c );
		}
	}
	
	/**
	 * Removes the specified comment from the system.
	 * 
	 * @param comment The comment to be removed from the system.
	 */
	public void removeComment( String comment ) {
		synchronized( comments ) {
			comments.remove( comment );
		}
	}
	
	/**
	 * Clears all of the current comments from the system.
	 *
	 */
	public void clearComments() {
		synchronized( comments ) {
			comments.clear();
		}
	}
	
	//
	// trace functions
	//
	
	/**
	 * Adds the specified trace message to the end of the current trace.
	 * 
	 * @param toTrace The string containing the trace message.
	 */
	public void trace( String toTrace ) {
		synchronized( trace ) {
			trace.add( toTrace );
		}
	}
	
	/**
	 * Clears all messages from the current trace.
	 */
	public void clearTrace() {
		synchronized( trace ) {
			trace.clear();
		}
	}
	
	/**
	 * Returns the current trace as an ordered {@link Collection} of messages
	 * that have been traced since the last {@link #clearTrace() clear}.
	 * 
	 * @return The current trace as an ordered {@link Collection} of messages.
	 */
	public Collection<String> getTrace() {
		synchronized( trace ) {
			Collection<String> copy = new LinkedList<String>();
			Iterator<String> it = trace.iterator();
			while( it.hasNext()) {
				copy.add( it.next());
			}
			return copy;
		}
	}
	
	/**
	 * Writes each message in the current trace to a separate line using the
	 * specified {@link Writer}.
	 * 
	 * @param w The {@link Writer} that should be used to display the current
	 * trace.
	 */
	public void dumpTrace( Writer w ) {
		synchronized( trace ) {
			PrintWriter pw = new PrintWriter( w );
			Iterator<String> it = trace.iterator();
			while( it.hasNext()) {
				pw.println( it.next());
			}
			pw.flush();
		}
	}
} // Xess
