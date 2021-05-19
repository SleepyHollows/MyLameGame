package Weapons;

public class superWeapon extends Weapon
{
	public superWeapon(int damage, double accuracy) 
	{
		super(damage, accuracy);
	}

	@Override
	int attack() 
	{
			return 100;
	}
}
