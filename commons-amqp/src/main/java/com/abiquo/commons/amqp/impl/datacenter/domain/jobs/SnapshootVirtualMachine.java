/**
 * Abiquo community edition
 * cloud management application for hybrid clouds
 * Copyright (C) 2008-2010 - Abiquo Holdings S.L.
 *
 * This application is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC
 * LICENSE as published by the Free Software Foundation under
 * version 3 of the License
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * LESSER GENERAL PUBLIC LICENSE v.3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.02 at 03:37:41 PM CET 
//


package com.abiquo.commons.amqp.impl.datacenter.domain.jobs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SnapshootVirtualMachine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SnapshootVirtualMachine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hypervisorConnection" type="{http://abiquo.com/tarantino/model/jobs}HypervisorConnection"/>
 *         &lt;element name="sourceDisk">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="diskStandard" type="{http://abiquo.com/tarantino/model/jobs}DiskStandard"/>
 *                   &lt;element name="diskStatefull" type="{http://abiquo.com/tarantino/model/jobs}DiskStatefull"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="destinationDisk" type="{http://abiquo.com/tarantino/model/jobs}DiskStandard"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SnapshootVirtualMachine", propOrder = {
    "hypervisorConnection",
    "sourceDisk",
    "destinationDisk"
})
public class SnapshootVirtualMachine {

    @XmlElement(required = true)
    protected HypervisorConnectionDto hypervisorConnection;
    @XmlElement(required = true)
    protected SnapshootVirtualMachine.SourceDisk sourceDisk;
    @XmlElement(required = true)
    protected DiskStandard destinationDisk;

    /**
     * Gets the value of the hypervisorConnection property.
     * 
     * @return
     *     possible object is
     *     {@link HypervisorConnectionDto }
     *     
     */
    public HypervisorConnectionDto getHypervisorConnection() {
        return hypervisorConnection;
    }

    /**
     * Sets the value of the hypervisorConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link HypervisorConnectionDto }
     *     
     */
    public void setHypervisorConnection(HypervisorConnectionDto value) {
        this.hypervisorConnection = value;
    }

    /**
     * Gets the value of the sourceDisk property.
     * 
     * @return
     *     possible object is
     *     {@link SnapshootVirtualMachine.SourceDisk }
     *     
     */
    public SnapshootVirtualMachine.SourceDisk getSourceDisk() {
        return sourceDisk;
    }

    /**
     * Sets the value of the sourceDisk property.
     * 
     * @param value
     *     allowed object is
     *     {@link SnapshootVirtualMachine.SourceDisk }
     *     
     */
    public void setSourceDisk(SnapshootVirtualMachine.SourceDisk value) {
        this.sourceDisk = value;
    }

    /**
     * Gets the value of the destinationDisk property.
     * 
     * @return
     *     possible object is
     *     {@link DiskStandard }
     *     
     */
    public DiskStandard getDestinationDisk() {
        return destinationDisk;
    }

    /**
     * Sets the value of the destinationDisk property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiskStandard }
     *     
     */
    public void setDestinationDisk(DiskStandard value) {
        this.destinationDisk = value;
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
     *         &lt;element name="diskStandard" type="{http://abiquo.com/tarantino/model/jobs}DiskStandard"/>
     *         &lt;element name="diskStatefull" type="{http://abiquo.com/tarantino/model/jobs}DiskStatefull"/>
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
        "diskStandard",
        "diskStatefull"
    })
    public static class SourceDisk {

        protected DiskStandard diskStandard;
        protected DiskStatefull diskStatefull;

        /**
         * Gets the value of the diskStandard property.
         * 
         * @return
         *     possible object is
         *     {@link DiskStandard }
         *     
         */
        public DiskStandard getDiskStandard() {
            return diskStandard;
        }

        /**
         * Sets the value of the diskStandard property.
         * 
         * @param value
         *     allowed object is
         *     {@link DiskStandard }
         *     
         */
        public void setDiskStandard(DiskStandard value) {
            this.diskStandard = value;
        }

        /**
         * Gets the value of the diskStatefull property.
         * 
         * @return
         *     possible object is
         *     {@link DiskStatefull }
         *     
         */
        public DiskStatefull getDiskStatefull() {
            return diskStatefull;
        }

        /**
         * Sets the value of the diskStatefull property.
         * 
         * @param value
         *     allowed object is
         *     {@link DiskStatefull }
         *     
         */
        public void setDiskStatefull(DiskStatefull value) {
            this.diskStatefull = value;
        }

    }

}
