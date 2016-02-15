package edu.mum.finco;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JDialog;

public class Helper {

	public static String prepend(Long no, int length) {
		String newNo = no.toString();
		while(newNo.length() < length)
			newNo = "0" + newNo;
		
		return newNo;
				
	}
	
	public static void pushControls(JDialog dialog, int l) {
		for (Component component : dialog.getContentPane().getComponents()) {
			int x = component.getX();
			int y = component.getY();
			int width = component.getWidth();
			int height = component.getHeight();
			component.setBounds(x, y + l, width, height);
		}

		Dimension dimention = dialog.getSize();
		dialog.setSize((int)dimention.getWidth(), (int)dimention.getHeight() + l + 100);
	}
}
