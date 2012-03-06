package org.pahospital.www.radiologyservice.server;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.axis2.AxisFault;
import org.pahospital.www.radiologycallbackservice.RadiologyCallbackServiceStub;
import org.pahospital.www.radiologyservice.RadiologyOrderID;
import org.pahospital.www.radiologycallbackservice.RadiologyCallbackServiceStub.RadiologyReport;

public class RadiologyReporter implements Runnable {
	private HashMap<String,RadiologyReport> reports;
	private String id;

	@Override
	public void run() {
		RadiologyCallbackServiceStub stub;
		try {
			Thread.sleep(5000);
			stub = new RadiologyCallbackServiceStub();
			stub.sendRadiologyReport(reports.get(id));
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A radiology reporter returns the report after a period of time.
	 * @param id
	 * @param reports
	 */
	public RadiologyReporter(String id, HashMap<String,RadiologyReport> reports) {
		this.id = id;
		this.reports = reports;
	}
}
