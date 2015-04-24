import javax.swing.*;

public class Flash {
	static FlashCards panel, panel1;
	static String[] words, definitions;
	public static int t, n;
	public static void main(String[] args) {
		int numDef;
		String number;
		final String Sentinel;
		
		
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
			if (n == numDef) break;
			words[n] = JOptionPane.showInputDialog("Please enter word " + t + " or type \"quit\" to finish.");
		}
		
		FlashCards.createCards(n, words, definitions);
		
	}
}
		
		
		
		
		
		
		

