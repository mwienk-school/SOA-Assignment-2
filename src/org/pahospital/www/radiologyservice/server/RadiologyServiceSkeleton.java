/**
 * RadiologyServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.pahospital.www.radiologyservice.server;

/**
 * RadiologyServiceSkeleton java skeleton for the axisService
 */
public class RadiologyServiceSkeleton implements
		RadiologyServiceSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param appointment2
	 * @return appointment3
	 */

	public org.pahospital.www.radiologyservice.Appointment requestAppointment(
			org.pahospital.www.radiologyservice.Appointment appointment2) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#requestAppointment");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyOrderID4
	 * @return orderStatus5
	 */

	public org.pahospital.www.radiologyservice.OrderStatus getOrderStatus(
			org.pahospital.www.radiologyservice.RadiologyOrderID radiologyOrderID4) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#getOrderStatus");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyOrderIDForPayment6
	 * @return
	 */

	public void makePayment(
			org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment radiologyOrderIDForPayment6) {
		// TODO : fill this with the necessary business logic

	}

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyOrder7
	 * @return radiologyOrderID8
	 */

	public org.pahospital.www.radiologyservice.RadiologyOrderID orderRadiologyExamination(
			org.pahospital.www.radiologyservice.RadiologyOrder radiologyOrder7) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#orderRadiologyExamination");
	}

}
