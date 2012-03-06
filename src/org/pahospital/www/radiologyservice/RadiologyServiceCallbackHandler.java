
/**
 * RadiologyServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

    package org.pahospital.www.radiologyservice;

    /**
     *  RadiologyServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class RadiologyServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public RadiologyServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public RadiologyServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for requestAppointment method
            * override this method for handling normal response from requestAppointment operation
            */
           public void receiveResultrequestAppointment(
                    org.pahospital.www.radiologyservice.RadiologyServiceStub.Appointment result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from requestAppointment operation
           */
            public void receiveErrorrequestAppointment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getOrderStatus method
            * override this method for handling normal response from getOrderStatus operation
            */
           public void receiveResultgetOrderStatus(
                    org.pahospital.www.radiologyservice.RadiologyServiceStub.OrderStatus result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getOrderStatus operation
           */
            public void receiveErrorgetOrderStatus(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for orderRadiologyExamination method
            * override this method for handling normal response from orderRadiologyExamination operation
            */
           public void receiveResultorderRadiologyExamination(
                    org.pahospital.www.radiologyservice.RadiologyServiceStub.RadiologyOrderID result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from orderRadiologyExamination operation
           */
            public void receiveErrororderRadiologyExamination(java.lang.Exception e) {
            }
                


    }
    