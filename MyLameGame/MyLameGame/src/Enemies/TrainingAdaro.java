package Enemies;

public class TrainingAdaro extends Enemies
{
	public TrainingAdaro(String name, int maxHP) 
	{
		super(name, 100);
		
	}
	int num = (int)Math.random()*3;
	public String attackType()
	{
		String sound;		
		if(num == 0)
		{
			sound = " jabbed with it's spear";
		}
		if(num == 2)
		{
			sound = " threw acid spit at your face";
		}
		else
		{
			sound = " rushed and slammed you hard onto the ground";
		}
		return sound;
	}
	
	@Override
	public int attack() 
	{
		return (int) (Math.random() * 18) + 11;
	}

	@Override
	public double accuracy() 
	{
		return .5;
	}
	
	@Override
	public double evasion() 
	{
		return .6;
	}
}
