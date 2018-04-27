
package xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orType">
 *   &lt;complexContent>
 *     &lt;extension base="{}clauseType">
 *       &lt;sequence>
 *         &lt;element name="clause" type="{}clauseType" maxOccurs="unbounded" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orType", propOrder = {
    "clause"
})
public class OrType
    extends ClauseType
{

    @XmlElement(required = true)
    protected List<ClauseType> clause;

    /**
     * Gets the value of the clause property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clause property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClause().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClauseType }
     * 
     * 
     */
    public List<ClauseType> getClause() {
        if (clause == null) {
            clause = new ArrayList<ClauseType>();
        }
        return this.clause;
    }

}
