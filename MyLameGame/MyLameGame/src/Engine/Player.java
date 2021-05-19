package Engine;
import java.util.ArrayList;

import Weapons.Bow;
import Weapons.GreatSword;
import Weapons.Sword;
import Weapons.Weapon;
import Weapons.superWeapon;

public class Player
{
	
	public static Weapon weapon;
	public static ArrayList<String> potions = new ArrayList<String>();
	
	public int hp;
	int maxHP;
	public int money;
	public int exp;
	String name;
	
	double evasion = .6;
	
	public Player(String name, int hp, int maxHP, int money, int exp) 
	{
		this.name = name;
		this.hp = maxHP;
		this.maxHP = maxHP;
		this.money = money;
		this.exp = exp;
	}
	
	public static void chooseWeapon()
	{	
		String[] weapons = {"Sword", "Bow", "Great Sword", "superWeapon"};
		
		GameEngine.clearConsole();
		GameEngine.printSeperator(40);
		System.out.println("Choose a weapon.");
		System.out.println("(1) " + weapons[0]);
		System.out.println("(2) " + weapons[1]);
		System.out.println("(3) " + weapons[2]);
		int input = GameEngine.readInt("-> ", weapons.length);
		GameEngine.clearConsole();
		
		if(input == 1)
		{
			GameEngine.printTitle("You chose the " + weapons[0]);
			weapon = new Sword(15, 1.4);
		}
		else if(input == 2)
		{
			GameEngine.printTitle("Your chose the " + weapons[1]);
			weapon = new Bow(8, 1.8);
		}
		else if(input == 3)
		{
			GameEngine.printTitle("Your chose the " + weapons[2]);
			weapon = new GreatSword(20, 1.00);
		}
		else if(input == 4)
		{
			weapon = new superWeapon(100, 100);
		}
		
		potions.add("Potion");
		potions.add("Potion");
		potions.add("Potion");
		
		GameEngine.pressAnything();
		GameEngine.travel();
		
	}//End of chooseWeapon()
	
	//Player Stats
	public int attack() 
	{
		int damage = weapon.damage;
		return damage;
	}

	public double accuracy() 
	{
		return weapon.accuracy;
	}
	

	public double evasion() 
	{
		return evasion;
	}
	
	public int heal()
	{
		if(potions.size() > 0)
		{
			int heal = 60;
			System.out.println("Your chugged a potion healing " + heal);
			potions.remove(0);
			hp += heal;
			return heal;
		}
		else
		{
			System.out.println("You are out of potions.");
			return 0;
		}
	}
	public void levelUp()
	{
		if(exp > 100)
		{
			System.out.println("You leveled up!!!");
			GameEngine.pressAnything();
			exp = 0;
			//GameEngine.player.maxHP += 10;
			weapon.damage += 2;
			weapon.accuracy += .1;
			evasion += .1;
		}
	}

}
