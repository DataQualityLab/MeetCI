
package xml;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for classification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="classification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datafile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="input" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="output" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="classes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="split" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="delimiter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="algorithm">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="RadialBasisFunctionNetwork" type="{}RadialBasisFunctionNetwork"/>
 *                   &lt;element name="MultiLayerPerceptron" type="{}MultiLayerPerceptron"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classification", propOrder = {
    "datafile",
    "input",
    "output",
    "classes",
    "split",
    "delimiter",
    "algorithm"
})
public class Classification {

    @XmlElement(required = true)
    protected String datafile;
    protected int input;
    protected int output;
    protected int classes;
    @XmlElement(required = true)
    protected BigDecimal split;
    @XmlElement(required = true)
    protected String delimiter;
    @XmlElement(required = true)
    protected Classification.Algorithm algorithm;

    /**
     * Gets the value of the datafile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatafile() {
        return datafile;
    }

    /**
     * Sets the value of the datafile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatafile(String value) {
        this.datafile = value;
    }

    /**
     * Gets the value of the input property.
     * 
     */
    public int getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     */
    public void setInput(int value) {
        this.input = value;
    }

    /**
     * Gets the value of the output property.
     * 
     */
    public int getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     */
    public void setOutput(int value) {
        this.output = value;
    }

    /**
     * Gets the value of the classes property.
     * 
     */
    public int getClasses() {
        return classes;
    }

    /**
     * Sets the value of the classes property.
     * 
     */
    public void setClasses(int value) {
        this.classes = value;
    }

    /**
     * Gets the value of the split property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSplit() {
        return split;
    }

    /**
     * Sets the value of the split property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSplit(BigDecimal value) {
        this.split = value;
    }

    /**
     * Gets the value of the delimiter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Sets the value of the delimiter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelimiter(String value) {
        this.delimiter = value;
    }

    /**
     * Gets the value of the algorithm property.
     * 
     * @return
     *     possible object is
     *     {@link Classification.Algorithm }
     *     
     */
    public Classification.Algorithm getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the value of the algorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Classification.Algorithm }
     *     
     */
    public void setAlgorithm(Classification.Algorithm value) {
        this.algorithm = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="RadialBasisFunctionNetwork" type="{}RadialBasisFunctionNetwork"/>
     *         &lt;element name="MultiLayerPerceptron" type="{}MultiLayerPerceptron"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "radialBasisFunctionNetwork",
        "multiLayerPerceptron"
    })
    public static class Algorithm {

        @XmlElement(name = "RadialBasisFunctionNetwork")
        protected RadialBasisFunctionNetwork radialBasisFunctionNetwork;
        @XmlElement(name = "MultiLayerPerceptron")
        protected MultiLayerPerceptron multiLayerPerceptron;

        /**
         * Gets the value of the radialBasisFunctionNetwork property.
         * 
         * @return
         *     possible object is
         *     {@link RadialBasisFunctionNetwork }
         *     
         */
        public RadialBasisFunctionNetwork getRadialBasisFunctionNetwork() {
            return radialBasisFunctionNetwork;
        }

        /**
         * Sets the value of the radialBasisFunctionNetwork property.
         * 
         * @param value
         *     allowed object is
         *     {@link RadialBasisFunctionNetwork }
         *     
         */
        public void setRadialBasisFunctionNetwork(RadialBasisFunctionNetwork value) {
            this.radialBasisFunctionNetwork = value;
        }

        /**
         * Gets the value of the multiLayerPerceptron property.
         * 
         * @return
         *     possible object is
         *     {@link MultiLayerPerceptron }
         *     
         */
        public MultiLayerPerceptron getMultiLayerPerceptron() {
            return multiLayerPerceptron;
        }

        /**
         * Sets the value of the multiLayerPerceptron property.
         * 
         * @param value
         *     allowed object is
         *     {@link MultiLayerPerceptron }
         *     
         */
        public void setMultiLayerPerceptron(MultiLayerPerceptron value) {
            this.multiLayerPerceptron = value;
        }

    }

}
