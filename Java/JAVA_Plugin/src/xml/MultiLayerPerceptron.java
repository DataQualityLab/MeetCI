
package xml;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultiLayerPerceptron complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultiLayerPerceptron">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inputLayerActivation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Linear"/>
 *               &lt;enumeration value="Ramp"/>
 *               &lt;enumeration value="Step"/>
 *               &lt;enumeration value="Sigmoid"/>
 *               &lt;enumeration value="Tanh"/>
 *               &lt;enumeration value="Gaussian"/>
 *               &lt;enumeration value="Trapezoid"/>
 *               &lt;enumeration value="Sgn"/>
 *               &lt;enumeration value="Sin"/>
 *               &lt;enumeration value="Log"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="hiddenLayerActivation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Linear"/>
 *               &lt;enumeration value="Ramp"/>
 *               &lt;enumeration value="Step"/>
 *               &lt;enumeration value="Sigmoid"/>
 *               &lt;enumeration value="Tanh"/>
 *               &lt;enumeration value="Gaussian"/>
 *               &lt;enumeration value="Trapezoid"/>
 *               &lt;enumeration value="Sgn"/>
 *               &lt;enumeration value="Sin"/>
 *               &lt;enumeration value="Log"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="hiddenLayers">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="([0-9])+(,([0-9])+)"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="outputLayerActivation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Linear"/>
 *               &lt;enumeration value="Ramp"/>
 *               &lt;enumeration value="Step"/>
 *               &lt;enumeration value="Sigmoid"/>
 *               &lt;enumeration value="Tanh"/>
 *               &lt;enumeration value="Gaussian"/>
 *               &lt;enumeration value="Trapezoid"/>
 *               &lt;enumeration value="Sgn"/>
 *               &lt;enumeration value="Sin"/>
 *               &lt;enumeration value="Log"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="momentum" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="epochs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="learningRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiLayerPerceptron", propOrder = {
    "inputLayerActivation",
    "hiddenLayerActivation",
    "hiddenLayers",
    "outputLayerActivation",
    "momentum",
    "epochs",
    "learningRate"
})
public class MultiLayerPerceptron {

    @XmlElement(required = true, defaultValue = "Linear")
    protected String inputLayerActivation;
    @XmlElement(required = true)
    protected String hiddenLayerActivation;
    @XmlElement(required = true)
    protected String hiddenLayers;
    @XmlElement(required = true)
    protected String outputLayerActivation;
    @XmlElement(required = true)
    protected BigDecimal momentum;
    protected int epochs;
    @XmlElement(required = true)
    protected BigDecimal learningRate;

    /**
     * Gets the value of the inputLayerActivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputLayerActivation() {
        return inputLayerActivation;
    }

    /**
     * Sets the value of the inputLayerActivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputLayerActivation(String value) {
        this.inputLayerActivation = value;
    }

    /**
     * Gets the value of the hiddenLayerActivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHiddenLayerActivation() {
        return hiddenLayerActivation;
    }

    /**
     * Sets the value of the hiddenLayerActivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHiddenLayerActivation(String value) {
        this.hiddenLayerActivation = value;
    }

    /**
     * Gets the value of the hiddenLayers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHiddenLayers() {
        return hiddenLayers;
    }

    /**
     * Sets the value of the hiddenLayers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHiddenLayers(String value) {
        this.hiddenLayers = value;
    }

    /**
     * Gets the value of the outputLayerActivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputLayerActivation() {
        return outputLayerActivation;
    }

    /**
     * Sets the value of the outputLayerActivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputLayerActivation(String value) {
        this.outputLayerActivation = value;
    }

    /**
     * Gets the value of the momentum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMomentum() {
        return momentum;
    }

    /**
     * Sets the value of the momentum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMomentum(BigDecimal value) {
        this.momentum = value;
    }

    /**
     * Gets the value of the epochs property.
     * 
     */
    public int getEpochs() {
        return epochs;
    }

    /**
     * Sets the value of the epochs property.
     * 
     */
    public void setEpochs(int value) {
        this.epochs = value;
    }

    /**
     * Gets the value of the learningRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLearningRate() {
        return learningRate;
    }

    /**
     * Sets the value of the learningRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLearningRate(BigDecimal value) {
        this.learningRate = value;
    }

}
