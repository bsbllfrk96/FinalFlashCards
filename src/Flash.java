import javax.swing.*;

public class Flash {

	public static void main(String[] args) {
		int numDef, n, t, x, y;
		String number;
		String[] words, definitions;
		final String Sentinel;
		FlashCards panel;
		
		number = null;
		Sentinel = "quit";
		numDef = n = 0;
		t = 1;
		
		number = JOptionPane.showInputDialog("How many words do you have?");
		numDef = Integer.parseInt(number);
		
		words = new String[numDef + 1];
		definitions = new String[numDef];
				
		words[n] = JOptionPane.showInputDialog("Please enter word " + t + " or type \"quit\" to finish.");
		
		while (!words[n].equals(Sentinel)) {
			definitions[n] = JOptionPane.showInputDialog("Please enter the definition for word " + t + ".");
			n++;
			t++;
			words[n] = JOptionPane.showInputDialog("Please enter word " + t + " or type \"quit\" to finish.");
		}
		
		
		x = (int) (Math.random() * definitions.length);
		
		panel = new FlashCards(words, definitions, x);
		panel.setSize(1000, 1000);
		panel.setLocationRelativeTo(null);
		panel.setTitle("Study Cards");
		panel.setVisible(true);
		
		
		
		
		
		
		
		
		
}
}