package project1;
import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) {									//bare-bones main method, calls menu which starts program
	menu();
	}
	
	
	
	
	//----------------------------------------------------------------------	//gets current x and y position of the maze marker and sends it to another class called getPOS which stores the information	
		
	public static void getPOS1(int a,int b,char[][] c ) {					
		int xPos = 0;
		int yPos = 0;
		int rows = a;
		int columns = b;
		char[][] mazeLayout = c;
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < columns;i++) {
				if (mazeLayout[j][i] == 'x' || mazeLayout[j][i] == 'X') {
					xPos = i;
					yPos = j;
				}
		
	}
	}
		getPOS.xPos = xPos;
		getPOS.yPos = yPos;
		
	}
	
	//-----------------------------------------------------------------------		//checks if x position is at the end of the array, the bottom or all the way to the right. If it is there it congratulates the user and exits the program
	
	public static void endCheck(int a){
		if (getPOS.xPos+1 == getColumns(mazeSelector(a)) || getPOS.yPos+1 == getRows(mazeSelector(a))) {
			System.out.println();
			System.out.println("Congratulations! you finished the maze!");
			System.exit(0);
		}
		
	}	
	
	
	//--------------------------------------------------------------					//reads in the given file that you choose 
	
	public static char[][] FileReader(File a,int b,int c) {
		File maze = a;
		int rows = b;
		int columns = c;
		char[][] mazeLayout = new char[rows][columns];
	
		try(BufferedReader reader1 = new BufferedReader(new FileReader(maze))){								
		String lineReader1;
		int j = 0;
		while ((lineReader1 = reader1.readLine()) != null) {
		j++;
		char[] array = lineReader1.toCharArray();
		for (int i = 0; i < columns;i++) {
			mazeLayout[j-1][i]= array[i];
		}
		}			
			
			
			
		}catch (Exception e) {
		e.printStackTrace();
		}
		return mazeLayout;
	}

	//-------------------------------------------------------------------	
	
	public static int getColumns(File a) {
		int columns = 0;
		File maze = a;
		try(BufferedReader reader = new BufferedReader(new FileReader(maze))){								//Finds what to set arrays rows/columns to by reading how many are in file
			String lineReader;
			lineReader = reader.readLine();
			columns = lineReader.length();
				
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return columns;
	}
	
	//---------------------------------------------------------------------	
	
	public static int getRows(File a) {
		int rows = 0;
		File maze = a;
		try(BufferedReader reader = new BufferedReader(new FileReader(maze))){								//Finds what to set arrays rows/columns to by reading how many are in file
			String lineReader;
			while ((lineReader = reader.readLine()) != null) {
				rows++;								
			}
					
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
		
	}
	
	//-----------------------------------------------------------------------					//Selects which file, "level of maze" to load into the program
	
	public static File mazeSelector(int a) {
		File maze = null;
		switch(a) {
		case 1:
			maze = new File("Easy.txt");
			break;
		case 2:
			maze = new File("Medium.txt");
			break;
		case 3:
			maze = new File("Hard.txt");
			break;
		default:
			System.out.println("Whoops, that is not one of the options\n");
		
	}
		return maze;
	}
		
	//------------------------------------------------------------------------				//prints the current given array
		
	public static void prntCurrArray(char[][] a,int b,int c) {
		int rows = b;
		int columns = c;
		char[][] mazeLayout = a;
		for (int j = 0; j < rows; j++) {
		System.out.println();
		for (int i = 0; i < columns;i++) {
			System.out.print(mazeLayout[j][i]);
			
			
		}
	}
			
}
		
	//------------------------------------------------------------------------------				//The bread and butter of the application, allows movement of 'x' along plane, and calls method to print current array and to determine if at end
				
		public static void movement(char[][] a,int selection){
			getPOS1(getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)),a);
			char[][] mazeLayout = a;
			Scanner input2 = new Scanner(System.in);
			System.out.println("           Use 'w', 'a', 's', 'd' keys to move up, down, left, right");
			String nextInput = input2.next();
			switch(nextInput) {
			case "w":
				if (mazeLayout[getPOS.yPos-1][getPOS.xPos] != ' ') {
					System.out.println("Sorry, but that is an illegal move!");
									
				}else {
					mazeLayout[getPOS.yPos-1][getPOS.xPos] = mazeLayout[getPOS.yPos][getPOS.xPos];
					mazeLayout[getPOS.yPos][getPOS.xPos] = ' ';
					}
				prntCurrArray(mazeLayout,getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)));
				getPOS1(getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)),mazeLayout);
				endCheck(selection);
				movement(mazeLayout,selection);
			case "a":
				if (mazeLayout[getPOS.yPos][getPOS.xPos-1] != ' ') {
					System.out.println("Sorry, but that is an illegal move!");
									
				}else {
					mazeLayout[getPOS.yPos][getPOS.xPos-1] = mazeLayout[getPOS.yPos][getPOS.xPos];
					mazeLayout[getPOS.yPos][getPOS.xPos] = ' ';
					}
				prntCurrArray(mazeLayout,getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)));
				getPOS1(getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)),mazeLayout);
				endCheck(selection);
				movement(mazeLayout,selection);
			case "s":
				if (mazeLayout[getPOS.yPos+1][getPOS.xPos] != ' ') {
					System.out.println("Sorry, but that is an illegal move!");
									
				}else {
					mazeLayout[getPOS.yPos+1][getPOS.xPos] = mazeLayout[getPOS.yPos][getPOS.xPos];
					mazeLayout[getPOS.yPos][getPOS.xPos] = ' ';
					}
				prntCurrArray(mazeLayout,getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)));
				getPOS1(getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)),mazeLayout);
				endCheck(selection);
				movement(mazeLayout,selection);
			case "d":
				if (mazeLayout[getPOS.yPos][getPOS.xPos+1] != ' ') {
					System.out.println("Sorry, but that is an illegal move!");
									
				}else {
					mazeLayout[getPOS.yPos][getPOS.xPos+1] = mazeLayout[getPOS.yPos][getPOS.xPos];
					mazeLayout[getPOS.yPos][getPOS.xPos] = ' ';
					}
				prntCurrArray(mazeLayout,getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)));
				getPOS1(getRows(mazeSelector(selection)),getColumns(mazeSelector(selection)),mazeLayout);
				endCheck(selection);
				movement(mazeLayout,selection);

			default:
				System.out.println("Whoops must have misclicked!");
				movement(mazeLayout,selection);
			}
			
			
		}
		
		
	//---------------------------------------------------------------------------------						//menu that allows user input to determine what choice to make
		
	public static void menu() {
	Scanner input = new Scanner(System.in);
	System.out.println("1:Exit\n2:Print Mazes\n3:Solve Mazes");
		int menuOptions = input.nextInt();
		switch(menuOptions) {
		case 1:
			System.out.println("Thanks for playing!");
			System.exit(1);
		case 2:
			Scanner input3 = new Scanner(System.in);
			System.out.println("Please select which maze you would like to see:\n1:Easy\n2:Medium\n3:Hard");
			int z = input3.nextInt();
			prntCurrArray(FileReader(mazeSelector(z),getRows(mazeSelector(z)),getColumns(mazeSelector(z))),getRows(mazeSelector(z)),getColumns(mazeSelector(z)));
			break;
		case 3:
			MazeRunner();
			break;
		default:
			menu();
		}
				
	}
		
	  //-----------------------------------------------------------------------------------					//Maze runner program start, it is what interacts with the rest of the methods to run program
		
		
		
		public static void MazeRunner() {
		Scanner input3 = new Scanner(System.in);
		System.out.println("Hello, Welcome to MazeRunner 2024");
		System.out.println("Please select which maze you would like to see:\n1:Easy\n2:Medium\n3:Hard");
		int z = input3.nextInt();
		char[][] Start = FileReader(mazeSelector(z),getRows(mazeSelector(z)),getColumns(mazeSelector(z)));
		 prntCurrArray(FileReader(mazeSelector(z),getRows(mazeSelector(z)),getColumns(mazeSelector(z))),getRows(mazeSelector(z)),getColumns(mazeSelector(z)));
	
		movement(Start,z);
		}
				
}