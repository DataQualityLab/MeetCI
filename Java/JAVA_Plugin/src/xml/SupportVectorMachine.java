
package xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SupportVectorMachine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupportVectorMachine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kernel">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Linear"/>
 *               &lt;enumeration value="RBF"/>
 *               &lt;enumeration value="Sigmoid"/>
 *               &lt;enumeration value="Poly"/>
 *               &lt;enumeration value="Precomputed"/>
 *               &lt;enumeration value="Trapezoid"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="degree" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gamma" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="coef" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tol" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxIter" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupportVectorMachine", propOrder = {
    "kernel",
    "degree",
    "gamma",
    "coef",
    "tol",
    "maxIter"
})
public class SupportVectorMachine {

    @XmlElement(required = true)
    protected String kernel;
    protected int degree;
    protected double gamma;
    protected double coef;
    protected double tol;
    protected int maxIter;

    /**
     * Gets the value of the kernel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKernel() {
        return kernel;
    }

    /**
     * Sets the value of the kernel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKernel(String value) {
        this.kernel = value;
    }

    /**
     * Gets the value of the degree property.
     * 
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Sets the value of the degree property.
     * 
     */
    public void setDegree(int value) {
        this.degree = value;
    }

    /**
     * Gets the value of the gamma property.
     * 
     */
    public double getGamma() {
        return gamma;
    }

    /**
     * Sets the value of the gamma property.
     * 
     */
    public void setGamma(double value) {
        this.gamma = value;
    }

    /**
     * Gets the value of the coef property.
     * 
     */
    public double getCoef() {
        return coef;
    }

    /**
     * Sets the value of the coef property.
     * 
     */
    public void setCoef(double value) {
        this.coef = value;
    }

    /**
     * Gets the value of the tol property.
     * 
     */
    public double getTol() {
        return tol;
    }

    /**
     * Sets the value of the tol property.
     * 
     */
    public void setTol(double value) {
        this.tol = value;
    }

    /**
     * Gets the value of the maxIter property.
     * 
     */
    public int getMaxIter() {
        return maxIter;
    }

    /**
     * Sets the value of the maxIter property.
     * 
     */
    public void setMaxIter(int value) {
        this.maxIter = value;
    }

}
