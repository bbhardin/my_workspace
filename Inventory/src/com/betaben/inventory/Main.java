package com.betaben.inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class Main extends JFrame {

	private JPanel contentPane;

	JPanel scrollPanel;
	JScrollPane scrollPane;
	JLabel lblInventory;
	JLabel lblItemName;
	JLabel lblItemPrice;
	JLabel lbldisplay;
	JButton btnAddItem;
	JTextField nameTextField;
	JTextField priceTextField;
	JRadioButton rdbtnDarkMode;
	
	public static String nameText;
	public static Double priceText;
	
	//public static Library library = new Library();
	
	public static HashMap<ItemPanel, Item> hashes = new HashMap<ItemPanel, Item>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPanel = new JPanel();
		scrollPanel.setPreferredSize(new Dimension(141, 1000));
		scrollPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(292, 25, 141, 247);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(scrollPanel);
		contentPane.add(scrollPane);
		
		lblInventory = new JLabel("Inventory:");
		lblInventory.setBounds(292, 6, 141, 16);
		contentPane.add(lblInventory);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(6, 25, 274, 26);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(6, 91, 274, 26);
		contentPane.add(priceTextField);
		priceTextField.setColumns(10);
		
		lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(6, 6, 80, 16);
		contentPane.add(lblItemName);
		
		lblItemPrice = new JLabel("Item Price:");
		lblItemPrice.setBounds(6, 63, 80, 16);
		contentPane.add(lblItemPrice);
		
		lbldisplay = new JLabel("");
		lbldisplay.setBounds(6, 129, 274, 45);
		contentPane.add(lbldisplay);
		
		rdbtnDarkMode = new JRadioButton("Dark Mode");
		rdbtnDarkMode.setBounds(6, 198, 141, 23);
		rdbtnDarkMode.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		contentPane.add(rdbtnDarkMode);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(6, 227, 272, 45);
		btnAddItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String vowels = "aeiou";
				nameText = nameTextField.getText();
				if(priceTextField.getText().isEmpty()){
					priceText = 0.00;
				} else {
					priceText = Double.parseDouble(priceTextField.getText());
				}
				Item item = new Item(nameText, priceText);
//				library.addItem(item);
				if(vowels.indexOf(Character.toLowerCase(nameText.charAt(0))) != -1){
					lbldisplay.setText("<html>An " + nameText + " was added to your inventory.<html>");
				} else {
					lbldisplay.setText("<html>A " + nameText + " was added to your inventory.<html>");
				}
				
				ItemPanel panel = new ItemPanel(scrollPanel, nameText, "$" + priceTextField.getText());
				ItemPanel.yPos += 75;
				scrollPanel.add(panel);
				
				hashes.put(panel, item);
				
				nameTextField.setText("");
				priceTextField.setText("");
				
				System.out.println("\nItem Name: \tItem Price:");
				for(ItemPanel panels : hashes.keySet()){
					
					System.out.println(hashes.get(panels).getName() + "\t\t $" + hashes.get(panels).getPrice());
					
				}
				
				scrollPanel.revalidate();
				scrollPanel.repaint();
				
				scrollPane.revalidate();
				scrollPane.repaint();
				
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		contentPane.add(btnAddItem);
		
		contentPane.getRootPane().setDefaultButton(btnAddItem);
		
	}
	
	public void darkMode(){
		if(rdbtnDarkMode.isSelected()){
			contentPane.setBackground(Color.black);
		}else{
			contentPane.setBackground(Color.white);
		}
	}
	
}