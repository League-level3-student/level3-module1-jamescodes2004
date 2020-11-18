package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	 JFrame frame = new JFrame();
	 JButton add = new JButton();
	 JButton view = new JButton();
	 JPanel panel = new JPanel();
	 ArrayList<String> names = new ArrayList<String>();
	void buttons(){
		names.add("Bob Banders");
		names.add("Sandy Summers");
		names.add("Greg Ganders");
		names.add("Donny Doners");
		frame.setSize(500,500);
		frame.add(panel);
		panel.add(add);
		add.addActionListener(this);
		view.addActionListener(this);
		panel.add(view);
		add.setText("Add Name");
		view.setText("View Name");
		frame.setVisible(true);

		
	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			String ne;
			ne = JOptionPane.showInputDialog(null, "Enter your name:");	
			names.add(ne);
		}
		if(e.getSource()==view) {
			
				
			if(names.size()==4) {
			JOptionPane.showMessageDialog(null, "Guest #1: "+ names.get(0)+"\n"+ "Guest #2: "+  names.get(1) + "\n"+ "Guest #3: "+names.get(2) + "\n"+ "Guest #4: "+names.get(3));
			}
			if(names.size()==5) {
				JOptionPane.showMessageDialog(null, "Guest #1: "+ names.get(0)+"\n"+ "Guest #2: "+  names.get(1) + "\n"+ "Guest #3: "+names.get(2) + "\n"+ "Guest #4: "+names.get(3)+ "\n"+ "Guest #5: "+names.get(4));
				}
			if(names.size()==6) {
				JOptionPane.showMessageDialog(null, "Guest #1: "+ names.get(0)+"\n"+ "Guest #2: "+  names.get(1) + "\n"+ "Guest #3: "+names.get(2) + "\n"+ "Guest #4: "+names.get(3)+ "\n"+ "Guest #5: "+names.get(4)+ "\n"+ "Guest #6: "+names.get(5));
				}
			if(names.size()==7) {
				JOptionPane.showMessageDialog(null, "Guest #1: "+ names.get(0)+"\n"+ "Guest #2: "+  names.get(1) + "\n"+ "Guest #3: "+names.get(2) + "\n"+ "Guest #4: "+names.get(3)+ "\n"+ "Guest #5: "+names.get(4)+ "\n"+ "Guest #6: "+names.get(5)+ "\n"+ "Guest #7: "+names.get(6));
				}
			}
	}
	
	
	
}
