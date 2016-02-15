package edu.mum.ccard;

import java.time.LocalDate;
import java.util.Arrays;

import edu.mum.finco.AddPersonalAccountFrame;
import edu.mum.finco.Helper;
import edu.mum.finco.IAccount;
import edu.mum.finco.IAddress;
import edu.mum.finco.ICustomer;
import edu.mum.finco.IFinCo;
import edu.mum.finco.Injector;
import edu.mum.finco.MainFrame;

public class AddCCardPersonalAccountFrame extends AddPersonalAccountFrame {
	private static final long serialVersionUID = 7926689701576982786L;

	public AddCCardPersonalAccountFrame(MainFrame parent, IFinCo model) {
		super(parent, model);
		Helper.pushControls(this, 45);
		
		JLabel8.setText("CC Number");

		JRadioButton_Gold.setText("Gold");
		JRadioButton_Gold.setActionCommand("Gold");
		JRadioButton_Gold.setSelected(true);
		getContentPane().add(JRadioButton_Gold);
		JRadioButton_Gold.setBounds(36, 0, 84, 24);
		
		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Silver");
		getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(36, 20, 84, 24);

		JRadioButton_Bronze.setText("Bronze");
		JRadioButton_Bronze.setActionCommand("Bronze");
		getContentPane().add(JRadioButton_Bronze);
		JRadioButton_Bronze.setBounds(36, 40, 84, 24);
		
		JLabel_Email.setText("Exp Date");
		getContentPane().add(JLabel_Email);
		JLabel_Email.setForeground(java.awt.Color.black);
		JLabel_Email.setBounds(12, 260, 48, 24);
		
		getContentPane().add(JTextField_ExpDate);
		JTextField_ExpDate.setBounds(84, 260, 156, 20);

		JButton_OK.setBounds(48, 284, 84, 24);
		JButton_Cancel.setBounds(156, 284, 84, 24);

		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Gold.addMouseListener(aSymMouse);
		JRadioButton_Silver.addMouseListener(aSymMouse);
		JRadioButton_Bronze.addMouseListener(aSymMouse);
	}

	javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
	javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();
	javax.swing.JLabel JLabel_Email = new javax.swing.JLabel();

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_Gold)
				JRadioButton_Gold_mouseClicked(event);
			else if (object == JRadioButton_Silver)
				JRadioButton_Silver_mouseClicked(event);
			else if (object == JRadioButton_Bronze)
				JRadioButton_Bronze_mouseClicked(event);
		}
	}

	void JRadioButton_Gold_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Gold.setSelected(true);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Bronze.setSelected(false);
	}

	void JRadioButton_Silver_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Silver.setSelected(true);
		JRadioButton_Gold.setSelected(false);
		JRadioButton_Bronze.setSelected(false);
	}

	void JRadioButton_Bronze_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Bronze.setSelected(true);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Gold.setSelected(false);
	}

	@Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		Long accountnr = Long.valueOf(JTextField_ACNR.getText());
		String name = JTextField_NAME.getText();
		String street = JTextField_STR.getText();
		String city = JTextField_CT.getText();
		int zip = Integer.parseInt(JTextField_ZIP.getText());
		String state = JTextField_ST.getText();
		String email = JTextField_EM.getText();
		String[] rawBirthDate = JTextField_BD.getText().split("/");
		String expDate = JTextField_ExpDate.getText();
		String accountTypeBeanId = JRadioButton_Gold.isSelected() ? "goldAccount" : JRadioButton_Silver.isSelected() ? "silverAccount" : "bronzeAccount";
		LocalDate birthDate = LocalDate.of(Integer.parseInt(rawBirthDate[2]), Integer.parseInt(rawBirthDate[0]),
				Integer.parseInt(rawBirthDate[1]));
		IAddress address = Injector.createObject("address", street, city, state, zip);
		IAccount account = Injector.createObject(accountTypeBeanId, expDate, accountnr, null, true, null);
		ICustomer customer = Injector.createObject("person", birthDate, name, email, address, Arrays.asList(account), true);
		account.setCustomer(customer);
		model.addCustomer(customer);
		dispose();
	}

}
