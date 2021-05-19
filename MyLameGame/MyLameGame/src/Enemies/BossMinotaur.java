package Enemies;

public class BossMinotaur extends Enemies
{

	public BossMinotaur(String name, int maxHP) 
	{
		super(name, 150);
	}

	@Override
	public
	String attackType() 
	{
		return " the minotaur charged you full force, knocking you hard against the arena wall";
	}

	@Override
	public
	int attack()
	{
		return (int) ((Math.random() * 25) + 20);
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
		return .8;
	}

}
