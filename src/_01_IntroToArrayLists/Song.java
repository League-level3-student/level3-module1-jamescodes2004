package _01_IntroToArrayLists;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class Song implements MouseListener {
	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;
	JFrame frame= new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	ArrayList<String> songs = new ArrayList<String>();
	/**
	 * Songs can be constructed from files on your computer or Internet addresses. *
	 * Examples: <code>
	* new Song("everywhere.mp3"); //from default package
	* new Song("/Users/joonspoon/music/Vampire Weekend - Modern
	Vampires of the City/03 Step.mp3"); * new
	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		frame.add(panel);
		panel.add(button);
		button.setText("random song");
		button.addMouseListener(this);
		frame.setVisible(true);
		songs.add("Kalimba.mp3");
		songs.add("demo.mp3");
		loadFile();

	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0) {
						mp3Player.play(duration);
					} else {
						mp3Player.play();
					}
				} catch (Exception e) {

				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		songAddress=songs.get(rand.nextInt(2));
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
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
