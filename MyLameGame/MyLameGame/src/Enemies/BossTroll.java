package Enemies;

public class BossTroll extends Enemies
{

	public BossTroll(String name, int maxHP) 
	{
		super(name, 150);
	}

	@Override
	public
	String attackType() 
	{
		return " the troll swung and hit you with it's masive club";
	}

	@Override
	public
	int attack() 
	{
		return (int) ((Math.random() * 30) + 25);
	}

	@Override
	public
	double accuracy() 
	{
		return .6;
	}

	@Override
	public
	double evasion() 
	{
		return .4;
	}

}
