package Enemies;

public class TrainingGoblin extends Enemies
{

	public TrainingGoblin(String name, int maxHP) 
	{
		super(name, 100);	
	}
	int num = (int)Math.random()*3;
	public String attackType()
	{

		System.out.println(num);
		String sound;		
		if(num == 0)
		{
			sound = " swung his club, hitting you hard in the leg";
		}
		if(num == 1)
		{
			sound = " spat in your face before throwing a heavy rock into your head";
		}
		else
		{
			sound = " clawed you across your chest";
		}
		return sound;
	}
	
	@Override
	public int attack() 
	{
		return (int) (Math.random() * 15) + 9;
	}

	@Override
	public double accuracy() 
	{
		return .6;
	}
	
	@Override
	public double evasion() 
	{
		return .6;
	}

}
