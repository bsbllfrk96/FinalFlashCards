import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FlashCards extends JFrame {
	static int count = 0;
	static FlashCards panel1;
	FlashCards(String[] words, String[] definitions, int x, int t) {
		Font font1;
		JTextArea text;
		JButton[] button;
		JButton quit, edit;
		JPanel p1, p2;
		Color newBlue, newGreen;
		
		newBlue = new Color(128, 255, 255);
		newGreen = new Color(0, 255, 128);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(0, 3));

		button = new JButton[words.length];
		font1 = new Font("Serif", Font.PLAIN, 20);

		for (int n = 0; n < t; n++) {
			button[n] = new JButton(words[n]);
			button[n].setFont(font1);
			button[n].setEnabled(true);

			if (n == x) {
				button[n].addActionListener(new rightAnswerListener());
				
			}else {
				button[n].addActionListener(new wrongAnswerListener());
			}if (count % 2 == 0) {
				button[n].setBackground(Color.YELLOW);
			} else {
				button[n].setBackground(newBlue);
			}
			count++;
			}

		for (int i = 0; i < t; i++) {
			p1.add(button[i]);
		}

		edit = new JButton("Edit");
		edit.setFont(font1);
		edit.addActionListener(new editListener());
		if (count % 2 == 0) {
			edit.setBackground(Color.YELLOW);
			count++;
		}
		else {
			edit.setBackground(newBlue);
			count++;
		}
		p1.add(edit);
			

		quit = new JButton("Quit");
		quit.setFont(font1);
		quit.addActionListener(new quitClick());
		if (count % 2 == 0) {
			quit.setBackground(Color.YELLOW);
			count++;
		}
		else {
			quit.setBackground(newBlue);
			count++;
		}
		if (count % 2 == 0) {
			p1.setBackground(Color.YELLOW);
		} else {
			p1.setBackground(newBlue);
		}
		p1.add(quit);

		text = new JTextArea();
		text.setText("Please pick the word for : " + definitions[x]);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setSize(10, 200);
		text.setFont(font1);
		text.setBackground(newGreen);
		text.setAlignmentY(CENTER_ALIGNMENT);
		text.setEditable(false);

		p2 = new JPanel(new BorderLayout());
		p2.add(text, BorderLayout.NORTH);
		p2.add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class rightAnswerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			closeWindow();
			JOptionPane.showMessageDialog(null, "You are correct!");
			createCards(Flash.n, Flash.words, Flash.definitions);	
		}
	}
	
	class editListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String toBeReplaced, replacementWord, replacementDefinition;
					
			toBeReplaced = JOptionPane.showInputDialog("Which word would you like to replace?");
						
			for (int i = 0; i < Flash.n; i++) {
				if (Flash.words[i].equalsIgnoreCase(toBeReplaced)) {
					replacementWord = JOptionPane.showInputDialog("Enter the replacement word");
					replacementDefinition = JOptionPane.showInputDialog("Enter the replacement definition");
					Flash.words[i] = replacementWord;
					Flash.definitions[i] = replacementDefinition;
					closeWindow();
					createCards(Flash.n, Flash.words, Flash.definitions);
					break;
				} else if (i == Flash.n - 1) {
					JOptionPane.showMessageDialog(null, "Sorry, that is not one of your words.");
					break;
				}
			}
			
		}
	}
	
	class wrongAnswerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Sorry, that's not right. Try again.");
		}
	}
	
	class quitClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Good luck studying!");
			System.exit(0);
		}
	}
	
	public static FlashCards createCards(int n, String[] words, String[] definitions) {
		int x;
		FlashCards panel;
		
		x = (int) (Math.random() * n);
		panel = new FlashCards(words, definitions, x, n);
		panel.setSize(1000, 1000);
		panel.setLocationRelativeTo(null);
		panel.setTitle("Study Cards");
		panel.setVisible(true);
		panel.setBackground(Color.GREEN);
		panel1 = panel;
		return panel;		
	}
	
	public static void closeWindow() {
		panel1.dispose();
	}
	
	
}