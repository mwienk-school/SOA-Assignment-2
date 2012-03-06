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

import org.pahospital.www.radiologycallbackservice.RadiologyCallbackServiceStub.RadiologyReport;
import org.pahospital.www.radiologyservice.*;

/**
 * RadiologyServiceSkeleton java skeleton for the axisService
 */
public class RadiologyServiceSkeleton implements RadiologyServiceSkeletonInterface {
	//Keep track of the RadiologyOrder objects with their IDs, statuses and payments
	protected static HashMap<String,RadiologyOrder> orderList = new HashMap<String,RadiologyOrder>();
	protected static int maxOrderId = 0;
	protected static HashMap<String,OrderStatus> orderStatuses = new HashMap<String, OrderStatus>();
	protected static HashMap<String,Boolean> payments = new HashMap<String, Boolean>();
	protected static HashMap<String,RadiologyReport> reports = new HashMap<String, RadiologyReport>();
	//Keep track of the Appointments
	protected static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	

	/**
	 * Request an appointment for a radiology exam.
	 * 
	 * @param appointment the request
	 * @return the appointment
	 * @throws SOAPException 
	 */

	public Appointment requestAppointment(Appointment appointment) throws SOAPException {
		Appointment result = null;
		if(orderList.containsKey(appointment.getOrderID())) {
			//Insert the appointment
			appointments.add(appointment);
			//Change OrderStatus
			orderStatuses.get(appointment.getOrderID()).setOrderStatus("appointment made");
			reports.get(appointment.getOrderID()).setDateOfExamination(appointment.getDate());
			result = appointment;
		} else {
			throw new SOAPException("Provide a valid OrderID");
		}
		return result;
	}

	/**
	 * Get the status of an radiology order.
	 * 
	 * @param radiologyOrderID The radiology order id
	 * @return orderStatus the status object of an order
	 * @throws SOAPException 
	 */
	public OrderStatus getOrderStatus(RadiologyOrderID radiologyOrderID) throws SOAPException {
		if(orderStatuses.containsKey(radiologyOrderID.getRadiologyOrderID())) {
			OrderStatus status = orderStatuses.get(radiologyOrderID.getRadiologyOrderID());
			return status;
		} else {
			throw new SOAPException("Radiology order ID unknown, please provide an existing order ID. Provided: " + radiologyOrderID.getRadiologyOrderID());
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
		//Set RadiologyOrder as paid
		if(!payments.get(radiologyOrderIDForPayment.getRadiologyOrderIDForPayment())) {
			payments.put(radiologyOrderIDForPayment.getRadiologyOrderIDForPayment(),true);
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
	 * @throws InterruptedException 
	 */
	public RadiologyOrderID orderRadiologyExamination(RadiologyOrder radiologyOrder) throws SOAPException, InterruptedException {
		RadiologyOrderID id = new RadiologyOrderID();
		id.setRadiologyOrderID(String.valueOf(maxOrderId));
		if(!orderList.containsKey(id.getRadiologyOrderID())) {
			//Insert the order
			orderList.put(id.getRadiologyOrderID(),radiologyOrder);
			//Insert the status
			OrderStatus status = new OrderStatus();
			status.setOrderID(id.getRadiologyOrderID());
			status.setOrderStatus("ordered");
			orderStatuses.put(id.getRadiologyOrderID(), status);
			//Insert the payment
			payments.put(id.getRadiologyOrderID(), false);
			
			//Create a report for this order
			RadiologyReport report = new RadiologyReport();
			report.setRadiologyOrderID(id.getRadiologyOrderID());
			report.setReportText("The result was very positive");
			report.setPatientID(radiologyOrder.getPatientID());
			report.setDateOfExamination(new java.util.Date());
			reports.put(id.getRadiologyOrderID(), report);
			
			//Increment the id
			maxOrderId++;
			
			//Send the report back tot the client
			(new Thread(new RadiologyReporter(id.getRadiologyOrderID(),reports))).start();
		} else {
			throw new SOAPException("Internal error: RadiologyOrderID exists.");
		}
		return id;
	}
}
