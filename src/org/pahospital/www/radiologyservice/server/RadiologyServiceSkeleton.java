/**
 * RadiologyServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.pahospital.www.radiologyservice.server;

import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.soap.SOAPException;

import org.pahospital.www.radiologyservice.*;

/**
 * RadiologyServiceSkeleton java skeleton for the axisService
 */
public class RadiologyServiceSkeleton implements RadiologyServiceSkeletonInterface {
	//Keep track of the RadiologyOrder objects with their IDs, statuses and payments
	protected HashMap<RadiologyOrderID,RadiologyOrder> orderList = new HashMap<RadiologyOrderID,RadiologyOrder>();
	protected int maxOrderId = 0;
	protected HashMap<RadiologyOrderID,OrderStatus> orderStatuses = new HashMap<RadiologyOrderID, OrderStatus>();
	protected HashMap<RadiologyOrderID,Boolean> payments = new HashMap<RadiologyOrderID, Boolean>();
	//Keep track of the Appointments
	protected ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	

	/**
	 * Request an appointment for a radiology exam.
	 * 
	 * @param appointment the request
	 * @return the appointment
	 * @throws SOAPException 
	 */

	public Appointment requestAppointment(Appointment appointment) throws SOAPException {
		if(orderList.containsKey(appointment.getOrderID())) {
			//Insert the appointment
			appointments.add(appointment);
			//Change OrderStatus
			orderStatuses.get(appointment.getOrderID()).setOrderStatus("appointment made");
			return appointment;
		} else {
			throw new SOAPException("Radiology order ID unknown, please provide an existing order ID.");
		}
	}

	/**
	 * Get the status of an radiology order.
	 * 
	 * @param radiologyOrderID The radiology order id
	 * @return orderStatus the status object of an order
	 * @throws SOAPException 
	 */
	public OrderStatus getOrderStatus(RadiologyOrderID radiologyOrderID) throws SOAPException {
		if(orderStatuses.containsKey(radiologyOrderID)) {
			OrderStatus status = orderStatuses.get(radiologyOrderID);
			return status;
		} else {
			throw new SOAPException("Radiology order ID unknown, please provide an existing order ID.");
		}
	}

	/**
	 * Make a payment for a radiology order
	 * 
	 * @param radiologyOrderIDForPayment
	 * @return
	 * @throws SOAPException 
	 */

	public void makePayment(RadiologyOrderIDForPayment radiologyOrderIDForPayment) throws SOAPException {
		//Convert RadiologyOrderIDForPayment to RadiologyOrderID
		RadiologyOrderID id = new RadiologyOrderID();
		id.setRadiologyOrderID(radiologyOrderIDForPayment.getRadiologyOrderIDForPayment());
		
		//Set RadiologyOrder as paid
		if(!payments.get(id)) {
			payments.put(id,true);
		} else {
			throw new SOAPException("This order has already been paid");
		}
	}

	/**
	 * Request an radiology examination.
	 * 
	 * @param radiologyOrder the radiology order
	 * @return radiologyOrderID the radiology order ID
	 * @throws SOAPException 
	 */
	public RadiologyOrderID orderRadiologyExamination(RadiologyOrder radiologyOrder) throws SOAPException {
		RadiologyOrderID id = new RadiologyOrderID();
		id.setRadiologyOrderID(String.valueOf(this.maxOrderId));
		if(!this.orderList.containsKey(id)) {
			//Insert the order
			this.orderList.put(id,radiologyOrder);
			//Insert the status
			OrderStatus status = new OrderStatus();
			status.setOrderID(id.getRadiologyOrderID());
			status.setOrderStatus("ordered");
			this.orderStatuses.put(id, status);
			//Insert the payment
			payments.put(id, false);
			//Increment the id
			this.maxOrderId++;
			return id;
		}
		throw new SOAPException("Internal error: RadiologyOrderID exists.");
	}

}
