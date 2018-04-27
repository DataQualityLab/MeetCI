
package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for greaterThanOrEqualType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="greaterThanOrEqualType">
 *   &lt;complexContent>
 *     &lt;extension base="{}clauseType">
 *       &lt;attribute name="value1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "greaterThanOrEqualType")
public class GreaterThanOrEqualType
    extends ClauseType
{

    @XmlAttribute(name = "value1")
    protected String value1;
    @XmlAttribute(name = "value2")
    protected String value2;

    /**
     * Gets the value of the value1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue1() {
        return value1;
    }

    /**
     * Sets the value of the value1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue1(String value) {
        this.value1 = value;
    }

    /**
     * Gets the value of the value2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue2() {
        return value2;
    }

    /**
     * Sets the value of the value2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue2(String value) {
        this.value2 = value;
    }

}
