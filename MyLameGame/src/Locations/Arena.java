package Locations;
import java.util.Random;
import Enemies.BossBunyip;
import Enemies.BossMinotaur;
import Enemies.BossTroll;
import Enemies.Enemies;
import Engine.GameEngine;
import Engine.Player;

public class Arena
{
	public static void arena()
	{
		GameEngine.clearConsole();
		
		GameEngine.printTitle("Welcome to the Arena, looking to fight, or what?");
		System.out.println("(1) Fight. \n(2) Talk to gaurd. \n(3) What is the arean? \n(4) Leave.");
		int input = GameEngine.readInt("->", 4);
		
		if(input == 1)
		{
			generatingBoss();
		}
		else if(input == 2)
		{
			gaurdChat();
		}
		else if(input == 3)
		{
			GameEngine.clearConsole();
			GameEngine.printTitle("The arena is the ultimate test of your skills. \nIf you lose here there is no coming back.");
			GameEngine.pressAnything();
			arena();
		}
		else if(input == 4)
		{
			GameEngine.clearConsole();
			GameEngine.travel();
		}

	}//End of arena()
	
	
	public static void gaurdChat()
	{
		Random rand = new Random();
		int talking = rand.nextInt(3);
		
		if(talking == 1)
		{
			GameEngine.printSeperator(40);
			System.out.println("There are three monsters that are faught here. Make sure you ready.");
			GameEngine.pressAnything();
			arena();
		}
		else if(talking == 2)
		{
			GameEngine.printSeperator(40);
			System.out.println("They keep the games exiting by not letting anybody know what the gladiator will be fighting.");
			GameEngine.pressAnything();
			arena();
		}
		else
		{
			GameEngine.printSeperator(40);
			System.out.println("Lots of great warriors have died here, try not to be one of them.");
			GameEngine.pressAnything();
			arena();
		}
		
	}//End of gaurdChat()
	
	public static void generatingBoss()
	{
		int encounter = (int) (Math.random()*GameEngine.bosses.length);
		if(GameEngine.bosses[encounter].equals("Minotaur"))
		{
			bossFight(new BossMinotaur("Minotaur", encounter));
		}
		else if(GameEngine.bosses[encounter].equals("Troll"))
		{
			bossFight(new BossTroll("Troll", encounter));
		}
		else if(GameEngine.bosses[encounter].equals("Bunyip"))
		{
			bossFight(new BossBunyip("Bunyip", encounter));
		}
	}//End of generatingBoss()
	
	public static void bossFight(Enemies boss)
	{
		
		double playerChance = 0;
		double bossChance = 0;
		GameEngine.clearConsole();
		GameEngine.printTitle("You will be fighting a " + boss.name + ".\nGood luck");
		while(GameEngine.player.hp > 0 && boss.hp > 0)
		{

			//Chance of hitting boss
			playerChance = (GameEngine.player.accuracy() * (1 - boss.evasion()));
			//Chance of Enemy hitting
			bossChance = (boss.accuracy() * (1 - GameEngine.player.evasion()));
			
			//Displaying the Battle HUD
			GameEngine.printSeperator(80);
			System.out.println("Player -   HP: " + GameEngine.player.hp + "     Potions: " + Player.potions.size() + "       " + boss.name + " - HP: " + boss.hp);
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
					boss.hp -= GameEngine.player.attack();
					if(boss.hp <=0)
					{
						winBoss();
					}
				}
				else
				{
					System.out.println(playerChance);
					
					System.out.println("You swung but the " + boss.name + " was to fast to hit.");
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
				arena();
			}//End of players turn
			
			//Start of Enemy turn
			if(bossChance > Math.random())
			{
				System.out.println("The " + boss.name + boss.attackType() + " dealing " + boss.attack());
				GameEngine.player.hp -= boss.attack();
				if(GameEngine.player.hp <= 0)
				{
					loseBoss();
				}
			}
			else
			{
				System.out.println("The " + boss.name + "'s attack missed");
			}//End of enemies turn
		}
	}//End of bossFight()
	
	public static void winBoss()
	{
		GameEngine.clearConsole();
		GameEngine.printTitle("Way to go, you won a boss fight!");
		GameEngine.pressAnything();
		GameEngine.player.money += 100;
		GameEngine.player.exp += 100;
		GameEngine.player.levelUp();
		arena();
	}//End of winBoss()
	public static void loseBoss()
	{
		GameEngine.clearConsole();
		GameEngine.printTitle("GAME OVER.");
	}//End of loseBoss()
	
	
	
		
}
