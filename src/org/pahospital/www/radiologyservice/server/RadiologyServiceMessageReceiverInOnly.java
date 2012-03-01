

/**
 * RadiologyServiceMessageReceiverInOnly.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package org.pahospital.www.radiologyservice.server;

        /**
        *  RadiologyServiceMessageReceiverInOnly message receiver
        */

        public class RadiologyServiceMessageReceiverInOnly extends org.apache.axis2.receivers.AbstractInMessageReceiver{

        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext inMessage) throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(inMessage);

        RadiologyServiceSkeletonInterface skel = (RadiologyServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = inMessage.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        
            if("makePayment".equals(methodName)){
            
            org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment wrappedParam = (org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment.class,
                                                        getEnvelopeNamespaces(inMessage.getEnvelope()));
                                            
                                                     skel.makePayment(wrappedParam);
                                                
                } else {
                  throw new java.lang.RuntimeException("method not found");
                }
            

        }
        } catch (java.lang.Exception e) {
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



        }//end of class

    