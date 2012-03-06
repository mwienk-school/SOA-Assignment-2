package org.pahospital.www.radiologyservice.server;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.axis2.AxisFault;
import org.pahospital.www.radiologycallbackservice.RadiologyCallbackServiceStub;
import org.pahospital.www.radiologyservice.RadiologyOrderID;
import org.pahospital.www.radiologycallbackservice.RadiologyCallbackServiceStub.RadiologyReport;

public class RadiologyReporter implements Runnable {
	
	private HashMap<RadiologyOrderID,RadiologyReport> reports;
	private RadiologyOrderID id;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RadiologyCallbackServiceStub stub;
		try {
			stub = new RadiologyCallbackServiceStub();
			stub.sendRadiologyReport(reports.get(id));
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A radiology reporter returns the report when it is finished (in this case, after 5 seconds).
	 * @param reports
	 */
	public RadiologyReporter(HashMap<RadiologyOrderID,RadiologyReport> reports, RadiologyOrderID id) {
		this.reports = reports;
		this.id = id;
	}
}
