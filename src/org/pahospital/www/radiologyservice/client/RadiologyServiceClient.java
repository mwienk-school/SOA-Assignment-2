package org.pahospital.www.radiologyservice.client;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.async.AxisCallback;
import org.pahospital.www.radiologyservice.*;
import org.pahospital.www.radiologyservice.server.RadiologyServiceCallbackHandler;
import org.pahospital.www.radiologyservice.server.RadiologyServiceStub;

public class RadiologyServiceClient extends JFrame {

	public static void main(String[] args) {
		new RadiologyServiceClient();
	}
	
	private RadiologyServiceStub stub;
	private final String defaultUrl = "http://localhost:8080/SOA_-_Assignment_2/services/RadiologyService";
	private String url;
	// URL
	private JLabel urlLabel = null;
	private JTextField urlField = null;
	// PartientID
	private JTextField patientId = null;
	private JTextField caseId = null;
	private ButtonGroup examinationType = null;
	private JRadioButton xray;
	private JRadioButton ct;
	private ExaminationType_type1 examtype = null;
	
	// orderExamButton
	private JButton orderExamButton = null;
	
	public RadiologyServiceClient() {
		super("RadiologyService Client");
		try {
			stub = new RadiologyServiceStub(defaultUrl);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		initialize();
	}
		
	public void wsInit(String endpoint) throws AxisFault {
		stub = new RadiologyServiceStub(endpoint);
	}

	private void initialize() {
		Container c = this.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		urlLabel = new JLabel();
		urlLabel.setText("URL:");
		
		patientId = new JTextField(10);
		caseId = new JTextField(10);
		
		// Radiobuttons operationtype
		xray = new JRadioButton("XRAY");
		xray.setActionCommand("XRAY");
		ct = new JRadioButton("CT");
		ct.setActionCommand("CT");
		examinationType =  new ButtonGroup();
		examinationType.add(xray);
		examinationType.add(ct);
		
		ActionListener radioListener = new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == xray) {
					examtype = ExaminationType_type1.XRAY;
				} else {
					examtype = ExaminationType_type1.CT;
				}
			}
		};
		
		xray.addActionListener(radioListener);
		ct.addActionListener(radioListener);
		
		orderExamButton = new JButton();
		orderExamButton.setText("Order Examination");

		url = defaultUrl;

		orderExamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update endpoint URL with the value of urlfield
				url = urlField.getText();
				try {
					stub = new RadiologyServiceStub();
					RadiologyOrder ro = new RadiologyOrder();
					ro.setPatientID(patientId.getText());
					ro.setCaseID(caseId.getText());
					ro.setExaminationType(examtype);
					stub.orderRadiologyExamination(ro);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


		urlField = new JTextField(url);
		urlField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == urlField) {
					try {
						stub = new RadiologyServiceStub(url);
					} catch (AxisFault e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JPanel urlPanel = new JPanel();
		urlPanel.add(urlLabel);
		urlPanel.add(urlField);
		c.add(urlPanel);
		
		JPanel infoPanel = new JPanel();
		infoPanel.add(new JLabel("PartientID:"));
		infoPanel.add(patientId);
		infoPanel.add(new JLabel("CaseID:"));
		infoPanel.add(caseId);
		infoPanel.add(xray);
		infoPanel.add(ct);
		infoPanel.add(orderExamButton);
		c.add(infoPanel);


		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(900, 250);
		this.setVisible(true);
	}
	


}
