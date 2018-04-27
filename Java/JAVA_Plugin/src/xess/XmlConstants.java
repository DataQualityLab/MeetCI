//
// $Id: $
//
package xess;

/**
 * An interface that provides its implementing classes with access to a 
 * complete set of useful constants for parsing or generating valid XESS 
 * documents.
 *
 * @author rstjacques
 */
public interface XmlConstants {
	/**
	 * The XML version tag.
	 */
	public static final String XML_VERSION = "<?xml version=\"1.0\"?>";
	
	/**
	 * The top-level tag in an XESS document.  For example:<BR>
	 * <tt>&lt;xess><BR>
	 * &nbsp;&nbsp;&lt;!-- the body of the document goes here --><BR>
	 * &lt;/xess></tt>
	 */
	public static final String XESS = "ExpertSystem";
	
	/**
	 * The tag used wherever comments are allowed within an XESS document. For
	 * example:<BR><tt>&lt;comment>This is a comment.&lt;/comment></tt>
	 */
	public static final String COMMENT = "comment";
	
	/**
	 * The attribute used to specify the name of an element within an XESS
	 * document; for example, this may be used to specify the name of an
	 * XESS {@link #RULE}.
	 */
	public static final String NAME = "name";
	
	/**
	 * The attribute used to indicate the string value of an element witin an
	 * XESS document; for example, this may be used to indicate the initial
	 * value of a {@link #FIELD field} within an XESS {@link #STRUCT}.
	 */
	public static final String VALUE = "value";
	
	/**
	 * The attribute used to indicate the first string value of an element 
	 * within an XESS document that has multiple values; for example, this
	 * may be used to indicate the first of two values in a 
	 * {@link #GREATER_THAN} element.
	 */
	public static final String VALUE1 = "value1";
	
	/**
	 * The attribute used to indicate the second string value of an element 
	 * within an XESS document that has multiple values; for example, this
	 * may be used to indicate the second of two values in a 
	 * {@link #GREATER_THAN} element.
	 */
	public static final String VALUE2 = "value2";
	
	/**
	 * The attribute used to indicate the minimum value of an element within
	 * an XESS document; for example, this may be used to indicate the lower
	 * of two values used in a {@link #BETWEEN} element.
	 */
	public static final String MIN = "min";
	
	/**
	 * The attribute used to indicate the maximum value of an element within
	 * an XESS document; for example, this may be used to indicate the upper
	 * of two values used in a {@link #BETWEEN} element.
	 */
	public static final String MAX = "max";
	
	/**
	 * The attribute used to indicate the type of an element within an XESS
	 * document; for example, this may be used to indicate the {@link #STRUCT}
	 * type of an argument to a {@link #RULE}.
	 */
	public static final String TYPE = "type";
	
	/**
	 * The tag used to specify a field within a {@link #STRUCT} or an 
	 * {@link #INSTANCE} in an XESS document.
	 */
	public static final String FIELD = "field";
	
	/**
	 * The attribute used wherever descriptions are allowed within an XESS 
	 * document.
	 */
	public static final String DESCRIPTION = "description";
	
	/**
	 * The tag used to create the <b>if</b> within a {@link #RULE}.
	 */
	public static final String IF = "if";
	
	/**
	 * The tag used to create the <b>then</b> within a {@link #RULE}.
	 */
	public static final String THEN = "then";
	
	/**
	 * The tag used to create the <b>else</b> within a {@link #RULE}.
	 */
	public static final String ELSE = "else";
	
	/**
	 * The tag used to create a parameter element within a {@link #RULE}.
	 */
	public static final String PARAMETER = "parameter";
	
	/**
	 * The tag used to create a predicate element within an XESS document. For
	 * example:<BR>
	 * <TT>&lt;predicate name="example-predicate" value="example-value"/></tt>
	 */
	public static final String PREDICATE = "predicate";
	
	/**
	 * The tag used to create a struct element within an XESS document.  For
	 * example:<BR>
	 * <TT>&lt;struct name="ExampleStruct"><BR>
	 * &nbsp;&nbsp;&lt;field name="field1" initialValue="value1"/><BR>
	 * &nbsp;&nbsp;&lt;field name="field2" initialValue="value2"/><BR>
	 * &lt;/struct></TT>
	 */
	public static final String STRUCT = "struct";
	
	/**
	 * Used to specify the initial (or default) value of a {@link Field} 
	 * within a {@link Struct}.
	 */
	public static final String INITIAL_VALUE = "initialValue";
	
	/**
	 * The tag used to create an instance element within an XESS document; 
	 * each instance must be associated with a {@link #STRUCT} with the same
	 * basic structure.  For example:<BR>
	 * <TT>&lt;instance name="MyInstance" type="ExampleStruct"><BR>
	 * &nbsp;&nbsp;&lt;field name="field1" value="new value 1"/><BR>
	 * &nbsp;&nbsp;&lt;field name="field1" value="new value 2"/><BR>
	 * &lt;/instance></TT>
	 */
	public static final String INSTANCE = "instance";
	
	/**
	 * The tag used to define a rule within an XESS document.  For 
	 * example:<BR>
	 * <tt>&lt;rule name="example-rule"><BR>
	 * &nbsp;&nbsp;&lt;parameter name="arg1" type="ExampleStruct"/><BR>
	 * &nbsp;&nbsp;&lt;parameter name="arg2" type="ExampleStruct"/><BR>
	 * &nbsp;&nbsp;&lt;if><BR>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;!-- body of the if goes here --><BR>
	 * &nbsp;&nbsp;&lt;/if><BR>
	 * &nbsp;&nbsp;&lt;then><BR>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;!-- body of the then goes here --><BR>
	 * &nbsp;&nbsp;&lt;/then><BR>
	 * &nbsp;&nbsp;&lt;else><BR>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;!-- body of the else goes here --><BR>
	 * &nbsp;&nbsp;&lt;/else><BR>
	 * &lt;/rule></tt>
	 */
	public static final String RULE = "rule";
	
	/**
	 * The tag used to create an equal clause within the body of the <b>if</b> 
	 * in a {@link #RULE}; an equal clause compares two values for equality.  
	 * For example:<BR>
	 * <TT>&lt;equal value1="arg1.field1" value2="arg2.field1"/></TT><BR>
	 */
	public static final String EQUAL = "equal";
	
	/**
	 * The tag used to create an not-equal clause within the body of the 
	 * <b>if</b> in a {@link #RULE}; a not-equal clause compares two values 
	 * for inequality.  For example:<BR>
	 * <TT>&lt;notEqual value1="arg1.field1" value2="arg2.field1"/></TT>
	 */
	public static final String NOT_EQUAL = "notEqual";
	
	/**
	 * The tag used to create an greater-than clause within the body of the 
	 * <b>if</b> in a {@link #RULE}; a greater-than clause compares two values
	 * to determine if the first is larger than the second.  For example:<BR>
	 * <TT>&lt;greaterThan value1="arg1.field1" value2="arg2.field1"/></TT>
	 */
	public static final String GREATER_THAN = "greaterThan";
	
	/**
	 * The tag used to create an grater-than-or-equal clause within the body 
	 * of the <b>if</b> in a {@link #RULE}; a greater-than-or-equal clause
	 * compares two values to determine if the first is larger than or equal
	 * to the second.  For example:<BR>
	 * <TT>&lt;greaterThanOrEqual value1="arg1.field1" 
	 * value2="arg2.field1"/></TT>
	 */
	public static final String GREATER_THAN_OR_EQUAL = "greaterThanOrEqual";
	
	/**
	 * The tag used to create an less-than clause within the body of the 
	 * <b>if</b> in a {@link #RULE}; a less-than clause compares two values 
	 * to determine if the first is smaller than the second.  For example:<BR>
	 * <TT>&lt;lessThan value1="arg1.field1" value2="arg2.field1"/></TT>
	 */
	public static final String LESS_THAN = "lessThan";
	
	/**
	 * The tag used to create an less-than-or-equal clause within the body of
	 * the <b>if</b> in a {@link #RULE}; a less-than-or-equal clause compares
	 * two values to determine if the first is smaller than or equal to the 
	 * second.  For example:<BR>
	 * <TT>&lt;lessThanOrEqual value1="arg1.field1" 
	 * value2="arg2.field1"/></TT>
	 */
	public static final String LESS_THAN_OR_EQUAL = "lessThanOrEqual";
	
	/**
	 * The tag used to create a between class within the body of the <b>if</b>
	 * in a {@link #RULE}; a between clause uses minimum and maximum limits to
	 * determine if a single value is greater than or equal to the minimum and
	 * less than or equal to the maximum.  For example:<BR>
	 * <TT>&lt;between value="arg1.field2" min="100" max="200"/></TT>
	 */
	public static final String BETWEEN = "between";
	
	/**
	 * The tag used to create a not-between class within the body of the 
	 * <b>if</b> in a {@link #RULE}; a between clause uses minimum and maximum
	 * limits to determine if a single value is greater than or equal to the
	 * minimum and less than or equal to the maximum.  For example:<BR>
	 * <TT>&lt;notBetween value="arg1.field2" min="100" max="200"/></TT>
	 */
	public static final String NOT_BETWEEN = "notBetween";
	
	/**
	 * The tag used to create an and clause within the body of the <b>if</b>
	 * in a {@link #RULE}; an and clause evaluates two or more sub-clauses; if
	 * every clause evaluates to true, the and evaluates to true, otherwise 
	 * the and evaluates to false.  For example:<BR>
	 * <TT>&lt;and><BR>
	 * &nbsp;&nbsp;&lt;equal value1="arg1.field1" value2="arg2.field1"/><BR>
	 * &nbsp;&nbsp;&lt;notEqual value1="arg1.field2" 
	 * value2="arg2.field2"/><BR>
	 * &lt;/and></TT> 
	 */
	public static final String AND = "and";
	
	/**
	 * The tag used to create an or clause within the body of the <b>if</b>
	 * in a {@link #RULE}; an or clause evaluates two or more sub-clauses; if
	 * at least one clause evaluates to true, the or evaluates to true, 
	 * otherwise the or evaluates to false.  For example:<BR>
	 * <TT>&lt;or><BR>
	 * &nbsp;&nbsp;&lt;equal value1="arg1.field1" value2="arg2.field1"/><BR>
	 * &nbsp;&nbsp;&lt;notEqual value1="arg1.field2" 
	 * value2="arg2.field2"/><BR>
	 * &lt;/or></TT> 
	 */
	public static final String OR = "or";
	
	/**
	 * One of the possible actions taken in the <b>then</b> or <b>else</b>
	 * elements within a {@link #RULE}.  The set is used to modify the value
	 * of a variable within the system.  For example:<BR>
	 * <TT>&lt;set name="arg1.field1" value="updated value 1"/></TT>
	 */
	public static final String SET = "set";
	
	/**
	 * One of the possible actions taken in the <b>then</b> or <b>else</b>
	 * elements within a {@link #RULE}.  The runRule is used to execute a
	 * rule within the system.  For example:<BR>
	 * <TT>&lt;runRule name="example-rule"><BR>
	 * &nbsp;&nbsp;&lt;argument name="arg1" value="arg1"/><BR>
	 * &nbsp;&nbsp;&lt;argument name="arg2" value="arg2"/><BR>
	 * &lt;/runRule>
	 */
	public static final String RUN_RULE = "runRule";
	
	/**
	 * The tag used to specify an argument to a {@link #RUN_RULE}.
	 */
	public static final String ARGUMENT = "argument";
	
	/**
	 * One of the possible actions taken in the <b>then</b> or <b>else</b>
	 * elements within a {@link #RULE}.  The setInstance action is used to
	 * create or modify an existing instance.
	 */
	public static final String SET_INSTANCE = "setInstance";
	
	/**
	 * One of the possible actions taken in the <b>then</b> or <b>else</b>
	 * elements within a {@link #RULE}.  The setPredicate action is used to
	 * create or modify a predicate.
	 */
	public static final String SET_PREDICATE = "setPredicate";
} // XmlConstants
