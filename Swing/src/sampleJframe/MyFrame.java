package sampleJframe;

import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel jlabel;
	private JTextField textField;
	private JButton button1;
	public MyFrame() throws HeadlessException {
		super();
		this.setTitle("JFRAME");
		this.setSize(350,400);
		this.setLayout(new FlowLayout());
		this.jlabel = new JLabel("ENTER YOUR NAME");
		this.textField = new JTextField(25);
		this.button1 = new JButton("SayHello!");
		button1.addActionListener(this);
		this.add(jlabel);
		this.add(textField);
		this.add(button1);
		this.setVisible(true);
		}
	private void setSize(String string) {
		// TODO Auto-generated method stub
		
	}
	public JLabel getJlabel() {
		return jlabel;
	}
	public void setJlabel(JLabel jlabel) {
		this.jlabel = jlabel;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JButton getButton1() {
		return button1;
	}
	public void setButton1(JButton button1) {
		this.button1 = button1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(button1, "HELLO "+textField.getText());
		
	}
}
