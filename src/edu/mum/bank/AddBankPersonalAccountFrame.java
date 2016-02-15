package edu.mum.bank;

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

public class AddBankPersonalAccountFrame extends AddPersonalAccountFrame {
	private static final long serialVersionUID = 7926689701576982786L;

	public AddBankPersonalAccountFrame(MainFrame parent, IFinCo model) {
		super(parent, model);
		Helper.pushControls(this, 40);
		
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		JRadioButton_Chk.setSelected(true);
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36, 0, 84, 24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36, 24, 84, 24);
		
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
	}
	
	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
		// When Checking radio is clicked make this radio on
		// and make Saving account radio off
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
		// When Saving radio is clicked make this radio on
		// and make Checking account radio off
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);

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
		String accountTypeBeanId = JRadioButton_Chk.isSelected() ? "checking" : "saving";
		LocalDate birthDate = LocalDate.of(Integer.parseInt(rawBirthDate[2]), Integer.parseInt(rawBirthDate[0]),
				Integer.parseInt(rawBirthDate[1]));
		IAddress address = Injector.createObject("address", street, city, state, zip);
		IAccount account = Injector.createObject(accountTypeBeanId, accountnr, null, true, null);
		ICustomer customer = Injector.createObject("person", birthDate, name, email, address, Arrays.asList(account), true);
		account.setCustomer(customer);
		model.addCustomer(customer);
		dispose();
	}

}
