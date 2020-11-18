package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan extends Utilities implements KeyListener{
	Stack<String> dictionarys = new Stack<String>();
	JLabel label = new JLabel();
	JLabel lives = new JLabel();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	String word;
	int livesNum=7;
	
	void run(){
		frame.add(panel);
		panel.add(label);
		panel.add(lives);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.addKeyListener(this);
		frame.addKeyListener(this);
		label.addKeyListener(this);
		lives.setText("Lives: "+livesNum);
		
		String numString= JOptionPane.showInputDialog(null, "Enter a number in between 0 and 266");
		int num=Integer.parseInt(numString);
		for (int i = 0; i < num; i++) {
			String random = readRandomLineFromFile("dictionary.txt");
					if(dictionarys.contains(random)) {
						random = readRandomLineFromFile("dictionary.txt");
					}
					else {
			dictionarys.push(random);
					}
		}
		
		getNextWord();
		

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
	
	void getNextWord() {
		if(!dictionarys.isEmpty()) {
		word = dictionarys.pop();
		System.out.println(word);
		String labelText="";
		for (int i = 0; i < word.length(); i++) {
			labelText+="_ ";
			
		}
		label.setText(labelText);
		}
		else {
			//
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		// TODO Auto-generated method stub
		String oldLabel=label.getText();
		System.out.println(oldLabel);
		String labelText="";
		
		for (int i = 0; i < word.length(); i++) {
			char letter=word.charAt(i);
			if (letter==e.getKeyChar()) {
				labelText+=letter+" ";
			}
			else {
				labelText+=oldLabel.substring(i*2, i*2+2);
			}
		}
		label.setText(labelText);
		if(!labelText.contains(""+e.getKeyChar())) {
			livesNum=livesNum-1;
			System.out.println("Lives down");
			lives.setText("Lives: "+livesNum);
			
			if(livesNum==0) {
				int restartNum = JOptionPane.showConfirmDialog( null, "You've lost... The word was "+word+ "! Restart?");
				boolean restart=false;
				if(restartNum==0) {
					System.out.println("restart");
					restart=true;
					if(restart==true) {
						run();
						
					}
				}
			}
		}
		if(!labelText.contains("_")) {
			System.out.println("s");
		getNextWord();
		livesNum=7;
		lives.setText("Lives: "+livesNum);
		}
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
