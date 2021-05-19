package Enemies;

public abstract class Enemies 
{
	public String name;
	public int hp;
	public int maxHP;
	
	public Enemies(String name, int maxHP)
	{
		this.name = name;
		this.hp = maxHP;
		this.maxHP = maxHP;
	}
	
	public abstract String attackType();
	public abstract int attack();
	public abstract double accuracy();
	public abstract double evasion();
}
