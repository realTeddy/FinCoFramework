package edu.mum.finco;

import java.time.LocalDate;
import java.util.Arrays;

public class AddPersonalAccountFrame extends javax.swing.JDialog {
	private static final long serialVersionUID = 6896307053396115556L;

	protected IFinCo model;

	public AddPersonalAccountFrame(MainFrame parent, IFinCo model) {
		super(parent);
		this.model = model;
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		// {{INIT_CONTROLS
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 303);
		setVisible(false);
		
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 44, 48, 24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 68, 48, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 92, 48, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 116, 48, 24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 140, 48, 24);
		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 164, 96, 24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 188, 48, 24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 44, 156, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84, 92, 156, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84, 116, 156, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84, 68, 156, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84, 140, 156, 20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84, 164, 156, 20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84, 188, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 224, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 224, 84, 24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84, 20, 156, 20);
		JTextField_ACNR.setText(model.generateAccountNumber().toString());
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12, 20, 48, 24);
		// }}

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		// }}
	}

	// {{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	protected javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	protected javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	protected javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
	// }}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		Long accountnr = Long.valueOf(JTextField_ACNR.getText());
		String name = JTextField_NAME.getText();
		String street = JTextField_STR.getText();
		String city = JTextField_CT.getText();
		int zip = Integer.parseInt(JTextField_ZIP.getText());
		String state = JTextField_ST.getText();
		String email = JTextField_EM.getText();
		String[] rawBirthDate = JTextField_BD.getText().split("/");
		LocalDate birthDate = LocalDate.of(Integer.parseInt(rawBirthDate[2]), Integer.parseInt(rawBirthDate[0]),
				Integer.parseInt(rawBirthDate[1]));
		IAddress address = Injector.createObject("address", street, city, state, zip);
		IAccount account = Injector.createObject("account", accountnr, null, true, null);
		ICustomer customer = Injector.createObject("person", birthDate, name, email, address, Arrays.asList(account), true);
		account.setCustomer(customer);
		model.addCustomer(customer);
		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		// make this frame invisible if Cancel button is clicked
		dispose();
	}
}
