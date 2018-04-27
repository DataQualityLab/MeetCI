
package xml;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for MeetCI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeetCI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="MachineLearning" type="{}MachineLearning"/>
 *           &lt;element name="ExpertSystem" type="{}ExpertSystem"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeetCI", propOrder = {
    "machineLearning",
    "expertSystem"
})
@XmlRootElement(name = "MeetCI")
public class MeetCI {

    @XmlElement(name = "MachineLearning")
    protected MachineLearning machineLearning;
    @XmlElement(name = "ExpertSystem")
    protected ExpertSystem expertSystem;

    /**
     * Gets the value of the machineLearning property.
     * 
     * @return
     *     possible object is
     *     {@link MachineLearning }
     *     
     */
    public MachineLearning getMachineLearning() {
        return machineLearning;
    }

    /**
     * Sets the value of the machineLearning property.
     * 
     * @param value
     *     allowed object is
     *     {@link MachineLearning }
     *     
     */
    public void setMachineLearning(MachineLearning value) {
        this.machineLearning = value;
    }

    /**
     * Gets the value of the expertSystem property.
     * 
     * @return
     *     possible object is
     *     {@link ExpertSystem }
     *     
     */
    public ExpertSystem getExpertSystem() {
        return expertSystem;
    }

    /**
     * Sets the value of the expertSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpertSystem }
     *     
     */
    public void setExpertSystem(ExpertSystem value) {
        this.expertSystem = value;
    }

}
