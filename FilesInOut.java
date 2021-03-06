import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;


/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) throws FileNotFoundException{
    	int argsCounter = 0;
    	boolean upperCaseChoice = false;
    	
    	
    	/*
    	 * For Scanner IDE input instead of console
    	Scanner console = new Scanner(System.in);
    	System.out.print("Input file: ");
    	String inputFileName = console.next();
    	System.out.print("Output file: ");
    	String outputFileName = console.next();
    	*/
    	
    	/*
    	 *  Hard code for testing    	 
    	String inputFileName = ("input.txt");
    	String outputFileName = ("output.txt"); 
    	 */
    	
    	if(args[argsCounter].equals("-u")) {
			argsCounter ++;
			upperCaseChoice = true;
		}
    	
    	String inputFileName = args[argsCounter];
    	argsCounter++;
    	String outputFileName = args[argsCounter];
    	argsCounter++;
    	
        
    	
    	File inputFile = new File(inputFileName);
    	Scanner in = new Scanner(inputFile);
    	PrintWriter out = new PrintWriter(outputFileName);
        
    	while (in.hasNextLine()) {
    		String line = in.nextLine();
    		int i = 0;
    		while(!Character.isDigit(line.charAt(i))) {
    			i++;
    		}
    		String personName = line.substring(0,i);
    		String dateOfBirth = line.substring(i);
    		personName = personName.trim();
    		
    		
    		if(upperCaseChoice) {
    			personName = personName.toUpperCase();
    		}
    		else {
    			personName = capitalizeWord(personName);
    		}
    		 
    		dateOfBirth = (dateOfBirth.substring(0,2) + "/" + dateOfBirth.substring(2,4) + "/" + dateOfBirth.substring(4));
    		
    		
    		out.printf(personName + " " + dateOfBirth + "\n");
    		System.out.print(personName + " " + dateOfBirth + "\n");
    	}
    	
        in.close();
        out.close();
    } // main
    
    public static String capitalizeWord(String str){  
        String words[]=str.split("\\s");  
        String capitalizeWord="";  
        for(String w:words){  
            String first=w.substring(0,1);  
            String afterfirst=w.substring(1);  
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
        }  
        return capitalizeWord.trim(); 
    }   
    

} // FilesInOut
