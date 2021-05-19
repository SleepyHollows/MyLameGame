package Locations;
import java.util.Random;

import Enemies.Enemies;
import Enemies.TrainingAdaro;
import Enemies.TrainingGoblin;
import Enemies.TrainingWolf;
import Engine.GameEngine;
import Engine.Player;

public class Training 
{
	static Random rand = new Random();
	public static void training()
	{
		GameEngine.clearConsole();
		
		GameEngine.printTitle("You looking to train before your big fights? \nGet ready to sweat!");
		System.out.println("(1) Train. \n(2) Talk to trainer. \n(3) What is training? \n(4) Leave.");
		int input = GameEngine.readInt("->", 4);
		
		if(input == 1)
		{
			GameEngine.clearConsole();
			GameEngine.printTitle("To keep you on your feet, we don't let you pick what you fight...");
			generateTrainingTarget();
		}
		else if(input == 2)
		{
			TrainerChat();
		}
		else if(input == 3)
		{
			GameEngine.clearConsole();
			GameEngine.printTitle("In training you can fight as many monsters as you want.\nIf you fail to win then you are just sent back to the training camp");
			GameEngine.pressAnything();
			training();
		}
		else if(input == 4)
		{
			GameEngine.clearConsole();
			GameEngine.travel();
		}
	}//End of training()
	
	public static void TrainerChat()
	{
		Random rand = new Random();
		int talking = rand.nextInt(5);
		
		if(talking == 1)
		{
			GameEngine.printSeperator(40);
			System.out.println("Here to train? \nI would suggest it before you take on those bigger guys in the areana.");
			GameEngine.pressAnything();
			training();
		}
		else if(talking == 2)
		{
			GameEngine.printSeperator(40);
			System.out.println("You new around here? I can tell by looking.");
			GameEngine.pressAnything();
			training();
		}
		else if(talking == 3)
		{
			GameEngine.printSeperator(40);
			System.out.println("");
			GameEngine.pressAnything();
			training();
		}
		else if(talking == 4)
		{
			GameEngine.printSeperator(40);
			System.out.println("I've trained the best of the best, hope you can keep up.");
			GameEngine.pressAnything();
			training();
		}
		else
		{
			GameEngine.printSeperator(40);
			System.out.println("The beasts we use to train here are caught wild, we don't use females or younglings. \nMales are usually territorial and put up a good fight.");
			GameEngine.pressAnything();
			training();
		}

	}//End of TrainerChat()
	
	public static void generateTrainingTarget()
	{
		int encounter = (int) (Math.random() * GameEngine.enemies.length);
		if(GameEngine.enemies[encounter].equals("Wolf"))
		{
			battle(new TrainingWolf("Wolf", encounter));
		}
		else if(GameEngine.enemies[encounter].equals("Goblin"))
		{
			battle(new TrainingGoblin("Goblin", encounter));
		}
		if(GameEngine.enemies[encounter].equals("Adaro"))
		{
			battle(new TrainingAdaro("Adaro", encounter));
		}
	}//End of train()
	
	public static void battle(Enemies enemy)
	{
		double playerChance = 0;
		double enemyChance = 0;
		GameEngine.clearConsole();
		GameEngine.printTitle("You will be fighting a " + enemy.name + ".\nGood luck");
		while(GameEngine.player.hp > 0 && enemy.hp > 0)
		{

			//Chance of hitting enemy
			playerChance = (GameEngine.player.accuracy() * (1 - enemy.evasion()));
			//Chance of Enemy hitting
			enemyChance = (enemy.accuracy() * (1 - GameEngine.player.evasion()));
			
			//Displaying the Battle HUD
			GameEngine.printSeperator(80);
			System.out.println("Player -   HP: " + GameEngine.player.hp + "     Potions: " + Player.potions.size() + "       " + enemy.name + " - HP: " + enemy.hp);
			GameEngine.printSeperator(80);
			
			//Start of player turn
			System.out.println("Choose an action:");
			GameEngine.printSeperator(20);
			System.out.println("(1) Attack. (2) Heal. (3) Run");
			int input = GameEngine.readInt("-> ", 3);
			

			if(input == 1)
			{
				if(playerChance > Math.random() )
				{
					System.out.println("Your attack hit hard dealing " + Player.weapon.damage + " damage.");
					enemy.hp -= GameEngine.player.attack();
					if(enemy.hp <=0)
					{
						winTraining();
					}
				}
				else
				{
					System.out.println("You swung but the " + enemy.name + " was to fast to hit.");
				}
			}
			else if(input == 2)
			{
				GameEngine.player.heal();
			}
			else if(input == 3)
			{
				GameEngine.clearConsole();
				GameEngine.printTitle("You ran away, maybe you should try again?");
				GameEngine.pressAnything();
				training();
			}
			
			//Start of Enemy turn
			if(enemyChance > Math.random())
			{
				System.out.println("The " + enemy.name + enemy.attackType() + " dealing " + enemy.attack());
				GameEngine.player.hp -= enemy.attack();
				if(GameEngine.player.hp <= 0)
				{
					loseTraining();
				}
			}
			else
			{
				System.out.println("The " + enemy.name + "'s attack missed");
			}
		}

	
	}//End of battle()
	
	public static void winTraining()
	{
		GameEngine.clearConsole();
		System.out.println(GameEngine.player.exp);
		GameEngine.printTitle("Way to go, you won your training session!");
		GameEngine.pressAnything();
		GameEngine.player.money += 40;
		GameEngine.player.exp += 25;
		GameEngine.player.levelUp();
		training();
	}
	public static void loseTraining()
	{
		GameEngine.clearConsole();
		GameEngine.printTitle("To bad, maybe you can try again and have better luck");
		GameEngine.pressAnything();
		GameEngine.player.hp = 100;
		training();
	}

}
