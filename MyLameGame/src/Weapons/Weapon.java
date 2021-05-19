package Weapons;

public abstract class Weapon 
{
	public int damage;
	public double accuracy;
	
	public Weapon(int damage, double accuracy)
	{
		this.damage = damage;
		this.accuracy = accuracy;
	}
	
	abstract int attack();
	
}
