package Engine;
import java.util.*;

import Locations.Arena;
import Locations.Store;
import Locations.Training;

public class GameEngine 
{
	static Scanner sc = new Scanner(System.in);
	public static Player player;
	
	static boolean atStore = false;
	static boolean atArena = false;
	static boolean atTraining = false;
	
	
	public static String[] enemies = {"Wolf","Goblin","Adaro","Wolf","Adaro","Goblin"};
	
	public static String[] bosses = {"Minotaur","Troll","Bunyip"};
	
	public static int readInt(String prompt, int userChoice)
	{
		int input;
		
		do
		{
			System.out.print(prompt);
			try
			{
				input = Integer.parseInt(sc.next());
			}catch(Exception e)
			 {
				input = -1;
				System.out.println("Please enter one of the choice.");
			 }
		}while(input < 1 || input > userChoice);
		return input;
	}//End of readInt()

	public static void clearConsole()
	{
		for(int i = 0; i < 100; i++)
		{
			System.out.println();
		}
	}//End of clearConsole()
	
	public static void printSeperator(int n)
	{
		for(int i = 0; i < n; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}//End of printSeperator
	
	public static void printTitle(String title)
	{
		printSeperator(40);
		System.out.println(title);
		printSeperator(40);
	}//End of printTitle
	
	public static void pressAnything()
	{
		String press = null;
		if(press == null)
		{
			sc.nextLine();
			printSeperator(40);
			System.out.println("\nPress \"Enter\" to continue...");
			press = sc.nextLine();
		}
	}//End of pressAnything()
	
	public static void startGame()
	{
		boolean setName = false;
		String name;
		clearConsole();
		printSeperator(40);
		printSeperator(30);
		System.out.println("The Lamer Game. \n\n(The game isn't balanced very well, but you can still try and break it. \nWhen you train you gain stats and with enough you could wreck the bosses.)");
		printSeperator(30);
		printSeperator(40);
		System.out.println("Press anything to continue...");
		sc.nextLine();
		do
		{
			clearConsole();
			printTitle("Enter your name");
			System.out.print("\n-> ");
			name = sc.next();
			clearConsole();
			printTitle("your name is " + name + ", is that correct?");
			System.out.println("(1) Yes! \n(2) No, let me enter it again.");
			int input = readInt("-> ", 2);
			
			if(input == 1)
			{
				setName = true;
			}
			
		}while(!setName);
		
		player = new Player(name, 100, 100, 50, 0);		
		Player.chooseWeapon();
		
	}//End of startGame()
	
	public static void travel()
	{
		clearConsole();
		printTitle("Where do you want to go?");
		System.out.println("(1) Store. (2) Arena. (3) Training.");
		int input = readInt("->", 3);
		
		if(input == 1)
		{	
			if(!atStore)
			{
				printTitle("Heading to the store!");
				pressAnything();
				atStore = true;
				atArena = false;
				atTraining = false;
				Store.store();
			}
			else if(atStore == true)
				{
				printSeperator(40);
				System.out.println("That's where you already are!");
				pressAnything();
				travel();
			}
		}
		else if(input == 2)
		{
			if(!atArena)
			{
				printTitle("Heading to battle!");
				atStore = false;
				atArena = true;
				atTraining = false;
				Arena.arena();
			}
			else if(atArena == true)
			{
				printSeperator(40);
				System.out.println("That's where you already are!");
				pressAnything();
				travel();
			}
		}
		if(input == 3)
		{	
			if(!atTraining)
			{
				printTitle("Going to go Train!");
				pressAnything();
				atStore = false;
				atArena = false;
				atTraining = true;
				Training.training();
			}
			else if(atTraining == true)
				{
				printSeperator(40);
				System.out.println("That's where you already are!");
				pressAnything();
				travel();
			}
		}
	}//End of travel()

	
	
}//End of GameEngine
