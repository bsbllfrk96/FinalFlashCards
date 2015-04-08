import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FlashCards extends JFrame {
	
	public FlashCards(String[] words, String[] definitions, int x) {
		Font font1;
		JTextArea text;
		JButton[] button;
		JButton quit;
		JPanel p1, p2;
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(0 , 3));
		
		button = new JButton[words.length];
		font1 = new Font("Serif", Font.PLAIN, 20);
			
		for (int n = 0; n < definitions.length; n++) {
			button[n] = new JButton(words[n]);
			button[n].setFont(font1);
			
			if (n == x) {
				button[n].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Flash.closeWindow();
						JOptionPane.showMessageDialog(null, "You are correct!");
						Flash.createCards();
					}
				});
				
			}
			
			else {
				button[n].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Sorry, that's not right.");
					}
				});
			}
		}
		
		for (int i = 0; i < definitions.length; i++) {
			p1.add(button[i]);
		}		
		
		quit = new JButton("Quit");
		quit.setFont(font1);
		
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Good luck studying!");
				System.exit(0);
			}
		});
		
		p1.add(quit);
		
		text = new JTextArea();
		text.setText("Please pick the word for : " + definitions[x]);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setSize(10, 200);
		text.setFont(font1);
		text.setAlignmentY(CENTER_ALIGNMENT);
		text.setEditable(false);
	
		p2 = new JPanel(new BorderLayout());
		p2.add(text, BorderLayout.NORTH);
		p2.add(p1, BorderLayout.CENTER);
		add(p2,BorderLayout.CENTER);
	}
	
	
	
		
}