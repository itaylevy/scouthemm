package view;

import java.awt.event.ActionListener;

import javax.swing.*;

import model.user;
import model.player;
import model.scout;

public class LoginView extends JFrame{
	private JLabel myTitle;
	private JLabel userTitle;
	private JLabel passwordTitle;
	private JTextField userName;
	private JPasswordField password;
	private JButton loginButton;
	private JLabel successMessage;
	
	public LoginView(){
		JPanel myPanel = new JPanel();
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel.setLayout(null);
		myTitle = new JLabel("Scouthem");
		myTitle.setBounds(150, 2, 100, 100);
		myPanel.add(myTitle);
		userTitle = new JLabel("User:");
		userTitle.setBounds(65, 60, 100, 100);
		myPanel.add(userTitle);
		passwordTitle = new JLabel("Password:");
		passwordTitle.setBounds(35, 110, 100, 100);
		myPanel.add(passwordTitle);
		userName= new JTextField();
		password= new JPasswordField();
		userName.setBounds(100, 100, 200, 25);
		password.setBounds(100, 150, 200, 25);
		myPanel.add(userName);
		myPanel.add(password);
		loginButton = new JButton("Login");
		loginButton.setBounds(100, 200, 80, 20);
		myPanel.add(loginButton);
		successMessage = new JLabel("");
		successMessage.setBounds(180, 200, 120, 100);
		myPanel.add(successMessage);
		this.add(myPanel);
		this.setVisible(true);
		
	}

	public String getUserName(){return userName.getText();}
	public String getPassword(){return password.getText();}
	public void setLoginMessage(user user) {
		if (user instanceof player) {
			this.setVisible(false);
			PlayerScreen playerScreen = new PlayerScreen((player) user);
			playerScreen.setVisible(true);
		}
		else if (user instanceof scout) {
			this.setVisible(false);
			ScoutScreen scoutScreen = new ScoutScreen();
			scoutScreen.setVisible(true);
		}
		else {
			successMessage.setText("User doesn't exist");
		}
	}
	public void addLoginListner(ActionListener loginButtonListner) {
		loginButton.addActionListener(loginButtonListner);

	}
}
