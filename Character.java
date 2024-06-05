 package mockTextGameProject;

public abstract class Character 
{
	private String name;
	private int maxHealthPoints;
	private int attackValue;
	private int currentHealth;
	private int currentRoom; 
	
	/**
	 * @return the currentRoom
	 */
	public int getCurrentRoom()
	{
		return currentRoom;
	}
	/**
	 * @param currentRoom the currentRoom to set
	 */
	public void setCurrentRoom(int currentRoom)
	{
		this.currentRoom = currentRoom;
	}
	/**
	 * @return the currentHealth
	 */
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	/**
	 * @param currentHealth the currentHealth to set
	 */
	public void setCurrentHealth(int currentHealth)
	{
		this.currentHealth = currentHealth;
	}
	/**
	 * @return the attackValue
	 */
	public int getAttackValue()
	{
		return attackValue;
	}
	/**
	 * @param attackValue the attackValue to set
	 */
	public void setAttackValue(int attackValue)
	{
		this.attackValue = attackValue;
	}
	/**
	 * @return the maxHealthPoints
	 */
	public int getMaxHealthPoints()
	{
		return maxHealthPoints;
	}
	/**
	 * @param maxHealthPoints the maxHealthPoints to set
	 */
	public void setMaxHealthPoints(int maxHealthPoints)
	{
		this.maxHealthPoints = maxHealthPoints;
	}
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the healthPoints
	 */
	
	public boolean isAlive()
	{
		return this.currentHealth > 0;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	 {
		return "Character [name=" + name + ", maxHealthPoints=" + maxHealthPoints + ", attackValue=" + attackValue
				+ ", currentHealth=" + currentHealth + ", currentRoom=" + currentRoom + "]";
	}
	
	
	/*
	 * if(player.getCurrentRoom == monster.getCurrentRoom)
	 * {
	 * 		while(player.isAlive() && monster.isAlive())
	 * {
	 * 	//commence Attack
	 * 
	 * }
	 * 		
	 * }
	 */
	
}
