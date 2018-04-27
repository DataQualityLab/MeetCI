
package xml;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RandomForest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RandomForest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nTrees" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;choice>
 *           &lt;element name="maxDepth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *           &lt;element name="maxLeafNodes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;/choice>
 *         &lt;element name="minSamplesSplit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minSamplesLeaf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minFractionLeaf" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RandomForest", propOrder = {
    "nTrees",
    "maxDepth",
    "maxLeafNodes",
    "minSamplesSplit",
    "minSamplesLeaf",
    "minFractionLeaf"
})
public class RandomForest {

    protected int nTrees;
    protected Integer maxDepth;
    protected Integer maxLeafNodes;
    protected int minSamplesSplit;
    protected int minSamplesLeaf;
    @XmlElement(required = true)
    protected BigDecimal minFractionLeaf;

    /**
     * Gets the value of the nTrees property.
     * 
     */
    public int getNTrees() {
        return nTrees;
    }

    /**
     * Sets the value of the nTrees property.
     * 
     */
    public void setNTrees(int value) {
        this.nTrees = value;
    }

    /**
     * Gets the value of the maxDepth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxDepth() {
        return maxDepth;
    }

    /**
     * Sets the value of the maxDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxDepth(Integer value) {
        this.maxDepth = value;
    }

    /**
     * Gets the value of the maxLeafNodes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxLeafNodes() {
        return maxLeafNodes;
    }

    /**
     * Sets the value of the maxLeafNodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxLeafNodes(Integer value) {
        this.maxLeafNodes = value;
    }

    /**
     * Gets the value of the minSamplesSplit property.
     * 
     */
    public int getMinSamplesSplit() {
        return minSamplesSplit;
    }

    /**
     * Sets the value of the minSamplesSplit property.
     * 
     */
    public void setMinSamplesSplit(int value) {
        this.minSamplesSplit = value;
    }

    /**
     * Gets the value of the minSamplesLeaf property.
     * 
     */
    public int getMinSamplesLeaf() {
        return minSamplesLeaf;
    }

    /**
     * Sets the value of the minSamplesLeaf property.
     * 
     */
    public void setMinSamplesLeaf(int value) {
        this.minSamplesLeaf = value;
    }

    /**
     * Gets the value of the minFractionLeaf property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinFractionLeaf() {
        return minFractionLeaf;
    }

    /**
     * Sets the value of the minFractionLeaf property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinFractionLeaf(BigDecimal value) {
        this.minFractionLeaf = value;
    }

}
