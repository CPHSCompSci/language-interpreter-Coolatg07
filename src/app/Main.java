package app;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Lexicon lex = new Lexicon();
    Scanner scan = new Scanner(System.in);

    String newWord = lex.translate("food");
    System.out.println(newWord);
    System.out.println(decodeMessage("Iningy spientte oentfingy theent bientts"));
    System.out.println("Enter a Coded Message");
    String Cmessage = scan.nextLine();
    System.out.println(decodeInput(Cmessage));
    System.out.println("Enter a English Message");
    String Emessage = scan.nextLine();
    System.out.println(encodeInput(Emessage));

  }

  /**
   * This method decodes a single word.
   * 
   * @param word The single word to be decoded.
   */
  public static String decode(String word)
  {
	  char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
	  if(word.endsWith("ingy"))
	  {
		  word = word.replace("ingy", "");
	  }
	  for(char v : vowels)
	  {
		  if(word.contains("ent") && word.indexOf("ent") == word.indexOf(v) + 1 && word.indexOf("ent") != 0)
		  {
			  word = word.replaceFirst("ent", "");
		  }
	  }
    return word;
  }

  /**
   * This method should not have code copy/pasted from the decode method.
   * 
   * @param message The sentence (multiple words) to be decoded.
   */
  public static String decodeMessage(String message)
  {
	 
	  String nmessage = "";
	  int sword = 0;
	  int i = 0;
	  for(i = 0; i < message.length()-1; i++)
	  {
		   
		  char letter = message.charAt(i);
		  if(letter == ' ')
		  {
			  String words1 = message.substring(sword, i);
			  nmessage += decode(words1);
			  sword = i;
			  
		  }
		  
		  
	  }
	  nmessage += decode(message.substring(sword, i+1));
	  return nmessage;
    
  }

  /**
   * This method uses the decode(String) and a Scanner to decode a word specified
   * by the user.
   */
  public static String decodeInput(String Input) {
    
	  Input = decodeMessage(Input);
	  
	  
	  return Input;
  }
  
  /**
   * This method uses the Lexicon translate(String) and a Scanner to encode a word specified
   * by the user.
   */
  public static String encodeInput(String Input) {
	  Lexicon lex2 = new Lexicon();
	  String nInput = "";
	  int sword = 0;
	  int i = 0;
	  for(i = 0; i < Input.length()-1; i++)
	  {
		   
		  char letter = Input.charAt(i);
		  if(letter == ' ')
		  {
			  String words2 = Input.substring(sword, i);
			  nInput += lex2.translate(words2);
			  sword = i;
			  
		  }
	  }
	  nInput += lex2.translate(Input.substring(sword, i+1));
    return nInput;
  }
}