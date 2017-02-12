package com.betaben.inventory;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private JButton button = new JButton();
	private JTextField textField;
	private JScrollPane scrollPane;
	private JPanel scrollPanel;

	public SearchFrame() {
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("Search");
		button.setBounds(12, 82, 338, 60);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = textField.getText();
				for(ItemPanel panels : Main.hashes.keySet()){
					if(Main.hashes.get(panels).getName() == "apple"){
						System.out.println("This item is in your inventory.");
					} else {
						System.out.println("This item is not in your inventory.");
					}
				}
			}
		});
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(12, 13, 338, 60);
		contentPane.add(textField);
		textField.setColumns(10);

		scrollPanel = new JPanel();
		scrollPanel.setPreferredSize(new Dimension(141, 1000));
		scrollPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(362, 13, 208, 527);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(scrollPanel);
		contentPane.add(scrollPane);
		
	}
}
