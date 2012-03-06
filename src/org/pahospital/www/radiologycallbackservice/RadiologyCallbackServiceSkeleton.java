/**
 * RadiologyCallbackServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.pahospital.www.radiologycallbackservice;

/**
 * RadiologyCallbackServiceSkeleton java skeleton for the axisService
 */
public class RadiologyCallbackServiceSkeleton implements RadiologyCallbackServiceSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyReport0
	 * @return
	 */

	public void sendRadiologyReport(RadiologyReport radiologyReport) {
		System.out.println("======================================");
		System.out.println("=====       Radiology report     =====");
		System.out.println("======================================");
		System.out.println("== Patient id: " + radiologyReport.getPatientID());
		System.out.println("== Order id  : " + radiologyReport.getRadiologyOrderID());
		System.out.println("== Date      : " + radiologyReport.getDateOfExamination());
		System.out.println("== Report    :");
		System.out.println(radiologyReport.getReportText());
	}

}
