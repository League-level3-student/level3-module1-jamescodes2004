package _06_Intro_To_Hash_Maps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.stream.events.Namespace;

public class _02_LogSearch implements MouseListener{
	HashMap<Integer, String> people = new HashMap<Integer, String>();
	ArrayList<Integer> keys = new ArrayList<Integer>();

	JFrame frame= new JFrame();
	JPanel panel = new JPanel();
	JButton entry = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	void run() {
		panel.addMouseListener(this);
		entry.addMouseListener(this);
		search.addMouseListener(this);
		view.addMouseListener(this);
		remove.addMouseListener(this);
frame.add(panel);
panel.add(entry);
panel.add(search);
panel.add(view);
panel.add(remove);

frame.setVisible(true);
frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
entry.setText("Entry");
search.setText("Search by ID");
view.setText("View List");
remove.setText("Remove");
frame.pack();
	}
  /* =
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==entry) {
		String ID = JOptionPane.showInputDialog(null, "Enter an ID number");
		int IDNum = Integer.parseInt(ID);
		String name = JOptionPane.showInputDialog(null, "Enter a name");
		people.put(IDNum, name);
		keys.add(IDNum);
		System.out.println("put");
		}
		if(e.getSource()==search) {
			String IDCheck = JOptionPane.showInputDialog(null, "What is this person's ID?");
			int IDCheckNum = Integer.parseInt(IDCheck);
			if(people.get(IDCheckNum)==null) {
				JOptionPane.showMessageDialog(null, "This entry does not exist");
				System.out.println(people.get(IDCheckNum));
			}

			if(people.get(IDCheckNum)!=null) {
				JOptionPane.showMessageDialog(null,people.get(IDCheckNum));
				System.out.println(people.get(IDCheckNum));
			}
			}
		if(e.getSource()==view) {
			String bigString = "";
			ArrayList<String> names = new ArrayList<String>();
			for (int i = 0; i < keys.size(); i++) {
				
				names.add("ID: "+ keys.get(i)+ " Name: "+ people.get(keys.get(i)));
				bigString=names.get(i)+  "\n" + bigString;
			}
			
			JOptionPane.showMessageDialog(null,bigString);
			}
		if(e.getSource()==remove) {
			String key = JOptionPane.showInputDialog(null, "What is the user's ID");
			int keyNum = Integer.parseInt(key);
			if(people.get(keyNum)==null) {
				JOptionPane.showMessageDialog(null, "This entry does not exist");
				System.out.println(people.get(keyNum));
			}

			if(people.get(keyNum)!=null) {
				JOptionPane.showMessageDialog(null,people.get(keyNum) + " has been successfully removed from the list.");
				people.remove(keyNum);
				System.out.println(people.get(keyNum));
				ArrayList<String> names = new ArrayList<String>();
				for (int i = 0; i < keys.size(); i++) {
					if(keys.get(i)==keyNum) {
						keys.remove(i);
					}
				}
				
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
