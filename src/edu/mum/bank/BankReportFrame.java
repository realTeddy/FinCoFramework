//package edu.mum.bank;
//
//public class BankReportFrame extends javax.swing.JDialog {
//	private static final long serialVersionUID = -7959942998204795897L;
//
//	String billstring;
//
//	public BankReportFrame(String report) {
//		getContentPane().setLayout(null);
//		setSize(405, 367);
//		setVisible(false);
//		getContentPane().add(JScrollPane1);
//		JScrollPane1.setBounds(24, 24, 358, 240);
//		JScrollPane1.getViewport().add(JTextField1);
//		JTextField1.setBounds(0, 0, 355, 237);
//		JButton_OK.setText("OK");
//		JButton_OK.setActionCommand("OK");
//		getContentPane().add(JButton_OK);
//		JButton_OK.setBounds(156, 276, 96, 24);
//		JTextField1.setText(report);
//		SymAction lSymAction = new SymAction();
//		JButton_OK.addActionListener(lSymAction);
//		// }}
//	}
//
//	// {{DECLARE_CONTROLS
//	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
//	javax.swing.JTextField JTextField1 = new javax.swing.JTextField();
//	javax.swing.JButton JButton_OK = new javax.swing.JButton();
//	// }}
//
//	class SymAction implements java.awt.event.ActionListener {
//		public void actionPerformed(java.awt.event.ActionEvent event) {
//			Object object = event.getSource();
//			if (object == JButton_OK)
//				JButtonOK_actionPerformed(event);
//		}
//	}
//
//	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
//		dispose();
//
//	}
//}
