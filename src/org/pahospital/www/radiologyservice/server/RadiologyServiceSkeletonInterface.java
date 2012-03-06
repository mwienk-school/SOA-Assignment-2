/**
 * RadiologyServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.pahospital.www.radiologyservice.server;

import org.pahospital.www.radiologyservice.*;
import javax.xml.soap.SOAPException;

/**
 * RadiologyServiceSkeletonInterface java skeleton interface for the axisService
 */
public interface RadiologyServiceSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param appointment
	 * @throws SOAPException 
	 */

	public Appointment requestAppointment(Appointment appointment) throws SOAPException;

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyOrderID
	 * @throws SOAPException 
	 */

	public OrderStatus getOrderStatus(RadiologyOrderID radiologyOrderID) throws SOAPException;

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyOrderIDForPayment
	 * @throws SOAPException 
	 */

	public void makePayment(RadiologyOrderIDForPayment radiologyOrderIDForPayment) throws SOAPException;

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyOrder
	 * @throws SOAPException
	 * @throws InterruptedException 
	 */

	public RadiologyOrderID orderRadiologyExamination(RadiologyOrder radiologyOrder) throws SOAPException, InterruptedException;

}
