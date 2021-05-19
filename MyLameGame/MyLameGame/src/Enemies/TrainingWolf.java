package Enemies;

public class TrainingWolf extends Enemies
{

	public TrainingWolf(String name, int maxHP) 
	{
		super(name, 100);
		
	}
	int num = (int)Math.random()*3;
	public String attackType()
	{
	
		String sound;		
		if(num == 0)
		{
			sound = " lunged at your and took a good bite";
		}
		if(num == 2)
		{
			sound = " ran at you, slamming into your chest";
		}
		else
		{
			sound = " kicked dirt in your eyes before lunging at you";
		}
		return sound;
	}

	@Override
	public int attack() 
	{
		return (int) (Math.random() * 12) + 8;
	}

	@Override
	public double accuracy() 
	{
		return .7;
	}
	
	@Override
	public double evasion() 
	{
		return .7;
	}

}
