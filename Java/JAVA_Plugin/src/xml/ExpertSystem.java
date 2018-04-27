
package xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExpertSystem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpertSystem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fact" type="{}factType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rule" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="parameter" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="if">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="clause" type="{}clauseType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="then">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="action" type="{}actionType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="else" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="action" type="{}actionType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "ExpertSystem", propOrder = {
    "comment",
    "fact",
    "rule"
})
public class ExpertSystem {

    protected List<String> comment;
    protected List<FactType> fact;
    protected List<ExpertSystem.Rule> rule;

    /**
     * Gets the value of the comment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getComment() {
        if (comment == null) {
            comment = new ArrayList<String>();
        }
        return this.comment;
    }

    /**
     * Gets the value of the fact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FactType }
     * 
     * 
     */
    public List<FactType> getFact() {
        if (fact == null) {
            fact = new ArrayList<FactType>();
        }
        return this.fact;
    }

    /**
     * Gets the value of the rule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExpertSystem.Rule }
     * 
     * 
     */
    public List<ExpertSystem.Rule> getRule() {
        if (rule == null) {
            rule = new ArrayList<ExpertSystem.Rule>();
        }
        return this.rule;
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
     *       &lt;sequence>
     *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="parameter" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="if">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="clause" type="{}clauseType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="then">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="action" type="{}actionType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="else" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="action" type="{}actionType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "comment",
        "parameter",
        "_if",
        "then",
        "_else"
    })
    public static class Rule {

        protected String comment;
        protected List<ExpertSystem.Rule.Parameter> parameter;
        @XmlElement(name = "if", required = true)
        protected ExpertSystem.Rule.If _if;
        @XmlElement(required = true)
        protected ExpertSystem.Rule.Then then;
        @XmlElement(name = "else")
        protected ExpertSystem.Rule.Else _else;
        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Gets the value of the comment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComment() {
            return comment;
        }

        /**
         * Sets the value of the comment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComment(String value) {
            this.comment = value;
        }

        /**
         * Gets the value of the parameter property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the parameter property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParameter().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExpertSystem.Rule.Parameter }
         * 
         * 
         */
        public List<ExpertSystem.Rule.Parameter> getParameter() {
            if (parameter == null) {
                parameter = new ArrayList<ExpertSystem.Rule.Parameter>();
            }
            return this.parameter;
        }

        /**
         * Gets the value of the if property.
         * 
         * @return
         *     possible object is
         *     {@link ExpertSystem.Rule.If }
         *     
         */
        public ExpertSystem.Rule.If getIf() {
            return _if;
        }

        /**
         * Sets the value of the if property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExpertSystem.Rule.If }
         *     
         */
        public void setIf(ExpertSystem.Rule.If value) {
            this._if = value;
        }

        /**
         * Gets the value of the then property.
         * 
         * @return
         *     possible object is
         *     {@link ExpertSystem.Rule.Then }
         *     
         */
        public ExpertSystem.Rule.Then getThen() {
            return then;
        }

        /**
         * Sets the value of the then property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExpertSystem.Rule.Then }
         *     
         */
        public void setThen(ExpertSystem.Rule.Then value) {
            this.then = value;
        }

        /**
         * Gets the value of the else property.
         * 
         * @return
         *     possible object is
         *     {@link ExpertSystem.Rule.Else }
         *     
         */
        public ExpertSystem.Rule.Else getElse() {
            return _else;
        }

        /**
         * Sets the value of the else property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExpertSystem.Rule.Else }
         *     
         */
        public void setElse(ExpertSystem.Rule.Else value) {
            this._else = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
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
         *       &lt;sequence>
         *         &lt;element name="action" type="{}actionType"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "action"
        })
        public static class Else {

            @XmlElement(required = true)
            protected ActionType action;

            /**
             * Gets the value of the action property.
             * 
             * @return
             *     possible object is
             *     {@link ActionType }
             *     
             */
            public ActionType getAction() {
                return action;
            }

            /**
             * Sets the value of the action property.
             * 
             * @param value
             *     allowed object is
             *     {@link ActionType }
             *     
             */
            public void setAction(ActionType value) {
                this.action = value;
            }

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
         *       &lt;sequence>
         *         &lt;element name="clause" type="{}clauseType"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "clause"
        })
        public static class If {

            @XmlElement(required = true)
            protected ClauseType clause;

            /**
             * Gets the value of the clause property.
             * 
             * @return
             *     possible object is
             *     {@link ClauseType }
             *     
             */
            public ClauseType getClause() {
                return clause;
            }

            /**
             * Sets the value of the clause property.
             * 
             * @param value
             *     allowed object is
             *     {@link ClauseType }
             *     
             */
            public void setClause(ClauseType value) {
                this.clause = value;
            }

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
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Parameter {

            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "type")
            protected String type;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

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
         *       &lt;sequence>
         *         &lt;element name="action" type="{}actionType"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "action"
        })
        public static class Then {

            @XmlElement(required = true)
            protected ActionType action;

            /**
             * Gets the value of the action property.
             * 
             * @return
             *     possible object is
             *     {@link ActionType }
             *     
             */
            public ActionType getAction() {
                return action;
            }

            /**
             * Sets the value of the action property.
             * 
             * @param value
             *     allowed object is
             *     {@link ActionType }
             *     
             */
            public void setAction(ActionType value) {
                this.action = value;
            }

        }

    }

}
