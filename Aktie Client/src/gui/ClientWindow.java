package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;

import logic.Player;
import logic.ServerConnector;
import logic.SettingsDataHandler;

public class ClientWindow extends JFrame {
	
	/**
	 * The main window for the client application.
	 * The window will contain a cardlayout, that contains the different screens.
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane, cards, gamePanel;
	private static CardLayout cl;
	public static Color green = new Color(183, 210, 120);
	public static Color hoverGreen = new Color(212, 250, 125);
	public static Color red = new Color(254, 99, 99);
	public static Color hoverRed = new Color(241, 145, 145);

	public ClientWindow() {
		super();
		SettingsDataHandler sdh = new SettingsDataHandler();	
		ServerConnector sc = new ServerConnector(this, sdh);
		this.setTitle("Aktiespil");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Lobby lobby = new Lobby();
		
		// Test highscore array. Will be replaced with server content.
		// TODO: Replace with server content
		ArrayList<String> highscores = new ArrayList<String>();
		highscores.add("Chris");
		highscores.add("Allan");
		highscores.add("Peter");
		highscores.add("Mads");
		highscores.add("Maria");
		
	
		ArrayList<String> settings = new ArrayList<String>();
		settings = sdh.getSettings();
		
		lobby.setHighScores(highscores);
		lobby.setServerStatus(1);
		lobby.setUsername(settings.get(2));
		
		// Players here created for test purposes
		ArrayList<Player> players = new ArrayList<Player>();
		Player play1 = new Player("Allan", "a@a.dk", "127.0.0.1", 23000);
		Player play2 = new Player("Mads", "a@a.dk", "127.0.0.1", 23000);
		Player play3 = new Player("Rune", "a@a.dk", "127.0.0.1", 23000);
		
		players.add(play1);
		players.add(play2);
		players.add(play3);
		
		lobby.setPlayerList(players);
		
		gamePanel = new StockPanel();

		cl = new CardLayout();
		cards = new JPanel(cl);
		cards.add(lobby, "Lobby");
		cards.add(gamePanel, "Game");
		
		contentPane.add(cards);
		
		// Show the default layout
		cl.show(cards, "Lobby");
		
		// Lock window size and set visible
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void changeLayout(String layout) {
		// TODO: Check if specified layout exists
		// TODO: Change layout or throw exception
		cl.show(cards, layout);
	}


}
