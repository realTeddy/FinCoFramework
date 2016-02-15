package edu.mum.bank;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import edu.mum.finco.IAccount;
import edu.mum.finco.IFinCo;
import edu.mum.finco.Injector;
import edu.mum.finco.MainFrame;

public class BankFrame extends MainFrame {
	private static final long serialVersionUID = -281321034122568665L;
	
	public BankFrame(IFinCo model) {
		super(model);

		JButton_Withdraw.setBounds(468, 150, 96, 33);
		JButton_Report.setText("Report");
		JPanel1.add(JButton_Report);
		JButton_Report.setBounds(468, 194, 96, 33);
		SymAction lSymAction = new SymAction();
		JButton_Report.addActionListener(lSymAction);
	}

	javax.swing.JButton JButton_Report = new javax.swing.JButton();

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Report)
				JButton_Report_actionPerformed(event);
		}
	}

	private void JButton_Report_actionPerformed(ActionEvent event) {
		String report = model.generateReport();
		JDialog reportFrame = Injector.createObject("bankReportFrame", report);
		reportFrame.setVisible(true);
	}

	@Override
	protected void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog pac = Injector.createObject("addBankPersonalAccountFrame", myframe, model);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

	@Override
	protected void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog pac = Injector.createObject("addBankCompanyAccountFrame", myframe, model);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

	@Override
	protected void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			IAccount account = (IAccount) model.getMainFormTableModel().getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			JDialog dep = Injector.createObject("depositFrame", myframe, model, account, selection);
			dep.setBounds(430, 15, 275, 140);
			dep.setVisible(true);
		}

	}

	@Override
	protected void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			IAccount account = (IAccount) model.getMainFormTableModel().getValueAt(selection, 0);
			// Show the dialog for adding withdraw amount for the current mane
			JDialog wd = Injector.createObject("withdrawFrame", myframe, model, account, selection);
			wd.setBounds(430, 15, 275, 140);
			wd.setVisible(true);
		}

	}
}