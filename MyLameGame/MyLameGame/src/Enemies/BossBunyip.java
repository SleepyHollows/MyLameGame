package Enemies;

public class BossBunyip extends Enemies
{

	public BossBunyip(String name, int maxHP) 
	{
		super(name, 150);
	}

	@Override
	public
	String attackType() 
	{
		return " the bunyip used it masive, powerful jaws to clamp down on you";
	}

	@Override
	public
	int attack() 
	{
		return (int) ((Math.random() * 20) + 10);
	}

	@Override
	public
	double accuracy() 
	{
		return .9;
	}

	@Override
	public
	double evasion() 
	{
		return .9;
	}

}
