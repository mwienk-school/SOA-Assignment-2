
/**
 * RadiologyServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package org.pahospital.www.radiologyservice.server;

        /**
        *  RadiologyServiceMessageReceiverInOut message receiver
        */

        public class RadiologyServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        RadiologyServiceSkeletonInterface skel = (RadiologyServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("requestAppointment".equals(methodName)){
                
                org.pahospital.www.radiologyservice.Appointment appointment10 = null;
	                        org.pahospital.www.radiologyservice.Appointment wrappedParam =
                                                             (org.pahospital.www.radiologyservice.Appointment)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahospital.www.radiologyservice.Appointment.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               appointment10 =
                                                   
                                                   
                                                         skel.requestAppointment(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), appointment10, false, new javax.xml.namespace.QName("http://www.PAHospital.org/RadiologyService/",
                                                    "requestAppointment"));
                                    } else 

            if("getOrderStatus".equals(methodName)){
                
                org.pahospital.www.radiologyservice.OrderStatus orderStatus12 = null;
	                        org.pahospital.www.radiologyservice.RadiologyOrderID wrappedParam =
                                                             (org.pahospital.www.radiologyservice.RadiologyOrderID)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahospital.www.radiologyservice.RadiologyOrderID.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               orderStatus12 =
                                                   
                                                   
                                                         skel.getOrderStatus(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), orderStatus12, false, new javax.xml.namespace.QName("http://www.PAHospital.org/RadiologyService/",
                                                    "getOrderStatus"));
                                    } else 

            if("orderRadiologyExamination".equals(methodName)){
                
                org.pahospital.www.radiologyservice.RadiologyOrderID radiologyOrderID14 = null;
	                        org.pahospital.www.radiologyservice.RadiologyOrder wrappedParam =
                                                             (org.pahospital.www.radiologyservice.RadiologyOrder)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahospital.www.radiologyservice.RadiologyOrder.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               radiologyOrderID14 =
                                                   
                                                   
                                                         skel.orderRadiologyExamination(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), radiologyOrderID14, false, new javax.xml.namespace.QName("http://www.PAHospital.org/RadiologyService/",
                                                    "orderRadiologyExamination"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.radiologyservice.Appointment param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.radiologyservice.Appointment.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.radiologyservice.RadiologyOrderID param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.radiologyservice.RadiologyOrderID.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.radiologyservice.OrderStatus param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.radiologyservice.OrderStatus.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.radiologyservice.RadiologyOrder param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.radiologyservice.RadiologyOrder.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahospital.www.radiologyservice.Appointment param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahospital.www.radiologyservice.Appointment.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahospital.www.radiologyservice.Appointment wrapRequestAppointment(){
                                org.pahospital.www.radiologyservice.Appointment wrappedElement = new org.pahospital.www.radiologyservice.Appointment();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahospital.www.radiologyservice.OrderStatus param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahospital.www.radiologyservice.OrderStatus.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahospital.www.radiologyservice.OrderStatus wrapGetOrderStatus(){
                                org.pahospital.www.radiologyservice.OrderStatus wrappedElement = new org.pahospital.www.radiologyservice.OrderStatus();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahospital.www.radiologyservice.RadiologyOrderID param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahospital.www.radiologyservice.RadiologyOrderID.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahospital.www.radiologyservice.RadiologyOrderID wrapOrderRadiologyExamination(){
                                org.pahospital.www.radiologyservice.RadiologyOrderID wrappedElement = new org.pahospital.www.radiologyservice.RadiologyOrderID();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (org.pahospital.www.radiologyservice.Appointment.class.equals(type)){
                
                           return org.pahospital.www.radiologyservice.Appointment.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.radiologyservice.Appointment.class.equals(type)){
                
                           return org.pahospital.www.radiologyservice.Appointment.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.radiologyservice.RadiologyOrderID.class.equals(type)){
                
                           return org.pahospital.www.radiologyservice.RadiologyOrderID.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.radiologyservice.OrderStatus.class.equals(type)){
                
                           return org.pahospital.www.radiologyservice.OrderStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment.class.equals(type)){
                
                           return org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.radiologyservice.RadiologyOrder.class.equals(type)){
                
                           return org.pahospital.www.radiologyservice.RadiologyOrder.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.radiologyservice.RadiologyOrderID.class.equals(type)){
                
                           return org.pahospital.www.radiologyservice.RadiologyOrderID.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    