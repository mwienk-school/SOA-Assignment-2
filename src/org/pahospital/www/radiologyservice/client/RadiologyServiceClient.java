package org.pahospital.www.radiologyservice.client;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

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

	// URL
	private String url;
	private JLabel urlLabel = null;
	private JTextField urlField = null;

	// OrderRadologyExamination
	private JTextField patientId = null;
	private JTextField caseId = null;
	private ButtonGroup examinationType = null;
	private JRadioButton xray;
	private JRadioButton ct;
	private ExaminationType_type1 examtype = null;
	private JButton orderExamButton = null;

	// RequestAppointment
	private JTextField orderId;
	private JTextField appointmentDate;
	private JButton appointmentButton;

	// GetOrderStatus
	private JTextField statusOrderId;
	private JButton statusOrderButton;
	
	// MakePayment
	private JTextField paymentOrderId;
	private JButton paymentOrderButton;
	
	// Response pane
	private JTextPane responsePane;

	/**
	 * Constructor
	 */
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

		// Endpoint textfield
		urlLabel = new JLabel();
		urlLabel.setText("URL:");
		url = defaultUrl;
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

		// --- OrderRadiologyExamination ---
		patientId = new JTextField(10);
		caseId = new JTextField(10);
		xray = new JRadioButton("XRAY");
		xray.setActionCommand("XRAY");
		ct = new JRadioButton("CT");
		ct.setActionCommand("CT");
		examinationType = new ButtonGroup();
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
		orderExamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update endpoint URL with the value of urlfield
				url = urlField.getText();
				try {
					RadiologyOrder ro = new RadiologyOrder();
					ro.setPatientID(patientId.getText());
					ro.setCaseID(caseId.getText());
					ro.setExaminationType(examtype);
					RadiologyOrderID id = stub.orderRadiologyExamination(ro);
					responsePane.setText("Assigned ID: " + id.getRadiologyOrderID());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// --- RequestAppointment ---
		orderId = new JTextField(10);
		appointmentDate = new JTextField(10);
		appointmentButton = new JButton();
		appointmentButton.setText("Request appoinment");
		appointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// update endpoint URL with the value of urlfield
					url = urlField.getText();
					Appointment app = new Appointment();
					app.setOrderID(orderId.getText());
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date;
					date = formatter.parse(appointmentDate.getText());
					app.setDate(date);
					Appointment appointment = stub.requestAppointment(app);
					responsePane.setText("Appointment made: " + appointment.getDate());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		// RequestOrderStatus
		statusOrderId = new JTextField(10);
		statusOrderButton = new JButton();
		statusOrderButton.setText("GetOrderStatus");
		statusOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// update endpoint URL with the value of urlfield
					url = urlField.getText();
					RadiologyOrderID roi = new RadiologyOrderID();
					roi.setRadiologyOrderID(statusOrderId.getText());
					OrderStatus status = stub.getOrderStatus(roi);
					responsePane.setText("ID:" + status.getOrderID() + " Status: " + status.getOrderStatus());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		// MakePayment
		paymentOrderId = new JTextField(10);
		paymentOrderButton = new JButton();
		paymentOrderButton.setText("Make Payment");
		paymentOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// update endpoint URL with the value of urlfield
					url = urlField.getText();
					RadiologyOrderIDForPayment roifp = new RadiologyOrderIDForPayment();
					roifp.setRadiologyOrderIDForPayment(paymentOrderId.getText());
					stub.makePayment(roifp);
					responsePane.setText("Exam paid.");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		// Response Pane
		responsePane = new JTextPane();

		// GUI Building: adding to container
		// Endpoint textfield
		JPanel urlPanel = new JPanel();
		urlPanel.add(urlLabel);
		urlPanel.add(urlField);
		c.add(urlPanel);

		// --- OrderRadiologyExamination ---
		JPanel orderExamPanel = new JPanel();
		orderExamPanel.add(new JLabel("PartientID:"));
		orderExamPanel.add(patientId);
		orderExamPanel.add(new JLabel("CaseID:"));
		orderExamPanel.add(caseId);
		orderExamPanel.add(xray);
		orderExamPanel.add(ct);
		orderExamPanel.add(orderExamButton);
		c.add(orderExamPanel);

		// RequestAppointment
		JPanel requestAppointmentPanel = new JPanel();
		requestAppointmentPanel.add(new JLabel("OrderID:"));
		requestAppointmentPanel.add(orderId);
		requestAppointmentPanel.add(new JLabel("Date (yyyy-MM-dd):"));
		requestAppointmentPanel.add(appointmentDate);
		requestAppointmentPanel.add(appointmentButton);
		c.add(requestAppointmentPanel);

		// GetOrderStatus
		JPanel getOrderStatusPanel = new JPanel();
		getOrderStatusPanel.add(new JLabel("OrderID:"));
		getOrderStatusPanel.add(statusOrderId);
		getOrderStatusPanel.add(statusOrderButton);
		c.add(getOrderStatusPanel);

		// MakePayment
		JPanel makePaymentPanel = new JPanel();
		makePaymentPanel.add(new JLabel("OrderID:"));
		makePaymentPanel.add(paymentOrderId);
		makePaymentPanel.add(paymentOrderButton);
		c.add(makePaymentPanel);
		
		// Response Pane
		JPanel responsePanel = new JPanel();
		responsePanel.add(new JLabel("Response"));
		responsePanel.add(responsePane);
		c.add(responsePanel);

		// Some other window stuff...
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setSize(900, 450);
		this.setVisible(true);
	}
}
