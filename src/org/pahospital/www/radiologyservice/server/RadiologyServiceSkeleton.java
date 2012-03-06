/**
 * RadiologyServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.pahospital.www.radiologyservice.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.soap.SOAPException;

import org.pahospital.www.radiologycallbackservice.*;
import org.pahospital.www.radiologycallbackservice.RadiologyCallbackServiceStub.RadiologyReport;
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
	protected HashMap<RadiologyOrderID,RadiologyReport> reports = new HashMap<RadiologyOrderID, RadiologyReport>();
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
		RadiologyOrderID id = new RadiologyOrderID();
		id.setRadiologyOrderID(appointment.getOrderID());
		if(orderList.containsKey(id.getRadiologyOrderID())) {
			//Insert the appointment
			appointments.add(appointment);
			//Change OrderStatus
			orderStatuses.get(appointment.getOrderID()).setOrderStatus("appointment made");
			reports.get(id.getRadiologyOrderID()).setDateOfExamination(appointment.getDate());
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
	 * @throws InterruptedException 
	 */
	public RadiologyOrderID orderRadiologyExamination(RadiologyOrder radiologyOrder) throws SOAPException, InterruptedException {
		RadiologyOrderID result = null;
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
			
			//Create a report for this order
			RadiologyReport report = new RadiologyReport();
			report.setRadiologyOrderID(id.getRadiologyOrderID());
			report.setReportText("The result was very positive");
			report.setRadiologyOrderID(radiologyOrder.getPatientID());
			report.setDateOfExamination(null);
			reports.put(id, report);
			
			//Increment the id
			this.maxOrderId++;
			
			//Send the report back tot the client
			Thread.sleep(5000);
			try {
				this.returnRadiologyReport(id);
			} catch (RemoteException e) {
				throw new SOAPException("External error: Remote address error");
			}
		} else {
			throw new SOAPException("Internal error: RadiologyOrderID exists.");
		}
		return result;
	}
	
	/**
	 * Return the report to the client's callback service
	 * @throws RemoteException 
	 */
	private void returnRadiologyReport(RadiologyOrderID id) throws RemoteException {
		RadiologyCallbackServiceStub stub = new RadiologyCallbackServiceStub("http://localhost:8080/SOA_-_Assignment_2/services/RadiologyCallbackService");
		stub.sendRadiologyReport(this.reports.get(id));
	}
}
