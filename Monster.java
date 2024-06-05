package mockTextGameProject;

import java.util.ArrayList;

public class Monster extends Character
{
	private String description;
	private int id;
	private ArrayList<Collectible> itemPouch = new ArrayList<Collectible>();
	private String catagory;
	
	public Monster()
	{
	super.setName(" Godzilla");
	super.setCurrentHealth(100);
	super.setMaxHealthPoints(100);
	super.setCurrentRoom(0);
	super.setAttackValue(5);
	this.catagory = "Living"; 
	this.description = " A ferocious reptile monster."; 
	this.id = 0;
	}
	
	public Monster(String name, int healthPoints, String description, int id)
	{
		super.setCurrentHealth(healthPoints);
		super.setMaxHealthPoints(healthPoints);
		super.setName(name);
		this.description = description;
		this.id = id;
	}
	
	public int attack()
	{
		return getAttackValue();
	}
	
	public void recieveAttack(int attackValue)
	{
		super.setCurrentHealth(super.getCurrentHealth() - attackValue);
	}
	
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the itemPouch
	 */
	public ArrayList<Collectible> getItemPouch()
	{
		return itemPouch;
	}

	/**
	 * @param itemPouch the itemPouch to set
	 */
	public void setItemPouch(ArrayList<Collectible> itemPouch)
	{
		this.itemPouch = itemPouch;
	}
	
	/**
	 * @return the catagory
	 */
	public String getCatagory()
	{
		return catagory;
	}

	/**
	 * @param catagory the catagory to set
	 */
	public void setCatagory(String catagory)
	 {
		this.catagory = catagory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Monster [description=" + description + ", id=" + id + ", getCurrentRoom()=" + getCurrentRoom()
				+ ", getCurrentHealth()=" + getCurrentHealth() + ", getAttackValue()=" + getAttackValue()
				+ ", getMaxHealthPoints()=" + getMaxHealthPoints() + ", getName()=" + getName() + ", isAlive()=" + isAlive();
	}
	
	//Method talk, attack
	
}
