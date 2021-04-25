// Omar R. Gebril || Project 1: Cryptogram
// CSC 335 || Professor Jonathan Robert Misurda

// This program utilizes two hashmap instances of the HashMap class provided by java
// one for the PC to store quotation encryptions,
// and the other for the User's interpretation.

// The User has to enter guesses in Upper Case letters because the program
// does not accept lower case letters.

// The user can map 2 keys to a same letter value,
// as this is a consequence of being wrong, 
// the user would have to manually map the 2 keys to separate values
// once the incorrectness is realized.

// The File Reader chooses a random line from the file quotes.txt in src
// and then encrypts that randomly chosen line.

// the startGame method then keeps comparing both HashMaps for equivalence 
// as the user is punching in his answers.

// Once the user gets the right code,
// the word and its encryption are printed as well as 'You got it!' message.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Cryptograms {
	
	// This is the method to start the game,
	// it is called at the very end of the main method.
	static void startGame(ArrayList gameArray2, HashMap PCmap2) {
		// start game
		HashMap<String, String> Usermap = new HashMap<>();
		boolean gameFlag = true;
		String letterToReplace = "";
		String replacement = "";
		int entries = 0;
		while (gameFlag == true) {

			Scanner usersc = new Scanner(System.in);

			// pt1 print
			if (entries == 0) {
				for (int u = 0; u < gameArray2.size(); u++) {
					System.out.print(gameArray2.get(u));
				}
				System.out.println();
				System.out.print("Enter the letter to replace: ");
				letterToReplace = usersc.nextLine();

				System.out.print("Enter its replacement: ");
				replacement = usersc.nextLine();
				entries++;
				
				//map user entry to user hashmap 
				if(letterToReplace.length()==1 && 
						replacement.length()==1 && 
						Character.isUpperCase(letterToReplace.charAt(0)) && 
						Character.isUpperCase(replacement.charAt(0))) {
					Usermap.put(letterToReplace, replacement);
				}
				
			} else {
				if (PCmap2.equals(Usermap)) {
					
					gameFlag = false;
					//print last user hash and gameArray
					System.out.println();
					String let = "";
					for (int h = 0; h < gameArray2.size();h++) {
						boolean spaceFlag = true;
						for (HashMap.Entry entry : Usermap.entrySet()) {
							if (gameArray2.get(h).equals(entry.getKey())) {
								let = entry.getValue().toString();
								spaceFlag = false;
								break;
							}
						}
						if(spaceFlag==false) {
							System.out.print(let);
						}
						else {
							if (Character.isLetter(gameArray2.get(h).toString().charAt(0))) {
								System.out.print(" ");
							}
							else {
								System.out.print(gameArray2.get(h));
							}
						}
					}
					System.out.println();
					
					
					for (int u = 0; u < gameArray2.size(); u++) {
						System.out.print(gameArray2.get(u));
					}
					System.out.println();
					
					break;
				}
				System.out.println();
				
				//print user hash
				
				String let = "";
				for (int h = 0; h < gameArray2.size();h++) {
					boolean spaceFlag = true;
					for (HashMap.Entry entry : Usermap.entrySet()) {
						if (gameArray2.get(h).equals(entry.getKey())) {
							let = entry.getValue().toString();
							spaceFlag = false;
							break;
						}
					}
					if(spaceFlag==false) {
						System.out.print(let);
					}
					else {
						if (Character.isLetter(gameArray2.get(h).toString().charAt(0))) {
							System.out.print(" ");
						}
						else {
							System.out.print(gameArray2.get(h));
						}
					}
				}
				System.out.println();
				
				
				for (int u = 0; u < gameArray2.size(); u++) {
					System.out.print(gameArray2.get(u));
				}
				System.out.println();
				System.out.print("Enter the letter to replace: ");
				letterToReplace = usersc.nextLine();

				System.out.print("Enter its replacement: ");
				replacement = usersc.nextLine();
				entries++;

				if(letterToReplace.length()==1 && 
						replacement.length()==1 && 
						Character.isUpperCase(letterToReplace.charAt(0)) && 
						Character.isUpperCase(replacement.charAt(0))) {
					Usermap.put(letterToReplace, replacement);
				}
				
				//map user entry to user hashmap 
				
				//compare hashmaps
				
				// if statement gameflagfalse

			}
		}
		
		System.out.println();
		System.out.println("You got it!");
	}
	
	
	
	
	

	public static void main(String[] args) throws FileNotFoundException {

		// read file
		File file = new File("src/quotes.txt");

		Random rand = new Random();
		int n = rand.nextInt((5 - 1) + 1) + 1;

		Scanner sc = new Scanner(file);

		int i = 1;
		String line = "";
		String toEncrypt2 = ""; 
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			if (i == n) {
				toEncrypt2 = line;
			}
			i++;
		}
		// end reading file and getting specific line
		String toEncrypt = "";
		toEncrypt = toEncrypt2.toUpperCase();

		// Alphabet Array for use in encryption and comparison
		// with user's entries
		ArrayList<String> Alphabet = new ArrayList<String>();
		Alphabet.add("A");
		Alphabet.add("B");
		Alphabet.add("C");
		Alphabet.add("D");
		Alphabet.add("E");
		Alphabet.add("F");
		Alphabet.add("G");
		Alphabet.add("H");
		Alphabet.add("I");
		Alphabet.add("J");
		Alphabet.add("K");
		Alphabet.add("L");
		Alphabet.add("M");
		Alphabet.add("N");
		Alphabet.add("O");
		Alphabet.add("P");
		Alphabet.add("Q");
		Alphabet.add("R");
		Alphabet.add("S");
		Alphabet.add("T");
		Alphabet.add("U");
		Alphabet.add("V");
		Alphabet.add("W");
		Alphabet.add("X");
		Alphabet.add("Y");
		Alphabet.add("Z");


		Collections.shuffle(Alphabet);

		// Create PC HashMap that stores quotation encryption

		HashMap<String, String> PCmap = new HashMap<>();

		for (int j = 0; j < toEncrypt.length(); j++) {
			if (Character.isLetter(toEncrypt.charAt(j))) {
				for (int k = 0; k < Alphabet.size(); k++) {
					if (!PCmap.containsKey(Alphabet.get(k))
							&& !PCmap.containsValue(String.valueOf(toEncrypt.charAt(j)))) {
						PCmap.put(Alphabet.get(k), String.valueOf(toEncrypt.charAt(j)));
						break;
					}

				}
			}

		}
		
		// print encoded quotation

		// put in arrayList for later use
		ArrayList<String> encryptedList = new ArrayList<String>(toEncrypt.length());

		for (int l = 0; l < toEncrypt.length(); l++) {
			String key = "";
			boolean flag = false;
			for (HashMap.Entry entry : PCmap.entrySet()) {
				if (String.valueOf(toEncrypt.charAt(l)).equals(entry.getValue())) {
					key = entry.getKey().toString();
					flag = true;
					break;
				}
			}

			if (flag == true) {
				encryptedList.add(key);
				flag = false;
			} else {
				encryptedList.add(String.valueOf(toEncrypt.charAt(l)));

			}
		}

		ArrayList<String> gameArray = encryptedList;
		
		// startGame
		
		startGame(gameArray, PCmap);

	}
}
