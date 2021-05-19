package Locations;


import java.util.Random;

import Engine.GameEngine;
import Engine.Player;

public class Store
{
	public static void store()
	{
		GameEngine.clearConsole();
		
		GameEngine.printTitle("Welcome to the shop! what are you wanting to do?");
		System.out.println("(1) Buy potions. \n(2) Talk to shop keeper. \n(3) Leave.");
		int input = GameEngine.readInt("->", 3);
		
		if(input == 1)
		{
			Shopping();
		}
		else if(input == 2)
		{
			MerchantChat();
		}
		else if(input == 3)
		{
			GameEngine.clearConsole();
			GameEngine.travel();
		}
	}//End of store();

	public static void MerchantChat()
	{
		Random rand = new Random();
		int talking = rand.nextInt(5);
		
		if(talking == 1)
		{
			GameEngine.printSeperator(40);
			System.out.println("Welcome to my shop. I ain't got much \nbut I got what you need to survive.");
			GameEngine.pressAnything();
			Store.store();
		}
		else if(talking == 2)
		{
			GameEngine.printSeperator(40);
			System.out.println("You're one of the gladiators? \nThey must be getting desperate for new recuites");
			GameEngine.pressAnything();
			Store.store();
		}
		else if(talking == 3)
		{
			GameEngine.printSeperator(40);
			System.out.println("There ain't much that goes on in this town, \nbesides all the gladiator games of course.");
			GameEngine.pressAnything();
			Store.store();
		}
		else if(talking == 4)
		{
			GameEngine.printSeperator(40);
			System.out.println("If you are just here to chat then leave, \nI got more customers to serve.");
			GameEngine.pressAnything();
			Store.store();
		}
		else
		{
			GameEngine.printSeperator(40);
			System.out.println("I just own the store, don't have much for info");
			GameEngine.pressAnything();
			Store.store();
		}

	}//End of MerchantChat()
	
	private static void Shopping()
	{
		int potionCost = 20;
		int amountToGive = 3 - Player.potions.size();
		int amountGiven = 0;
		
		GameEngine.clearConsole();
		GameEngine.printTitle("Well I can only really give you potions.");
		if(Player.potions.size() == 3)
		{
			System.out.println("You are already fullup on potions, come back when you need some.");
			GameEngine.pressAnything();
		}
		else
		{
			for(int i = 0; i < amountToGive; i++)
			{
				GameEngine.player.money -= potionCost;
				if(GameEngine.player.money < potionCost)
				{
					System.out.println("You don't have enough money for anymore");
					break;
				}
				else 
				{
					Player.potions.add("Potion");
					amountGiven++;
				}
			}
			System.out.println("\nThere, I gave you " + amountGiven + " potions, you got " + GameEngine.player.money + " money left over.");
			GameEngine.pressAnything();
		}
		store();
	}
}
