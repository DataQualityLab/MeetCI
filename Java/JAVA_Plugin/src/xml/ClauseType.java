
package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for clauseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="clauseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clauseType")
@XmlSeeAlso({
    NotEqualType.class,
    OrType.class,
    EqualType.class,
    BetweenType.class,
    NotBetweenType.class,
    GreaterThanOrEqualType.class,
    AndType.class,
    LessThanType.class,
    GreaterThanType.class,
    LessThanOrEqualType.class
})
public abstract class ClauseType {


}
