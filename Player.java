package mockTextGameProject;

import java.util.ArrayList;

public class Player extends Character
{
	private ArrayList <Collectible> itemPouch = new ArrayList<Collectible>();
	private ArrayList <String> roomsVisited = new ArrayList<String>();
	
	public Player()
	{
		super.setName("Jay");
		super.setCurrentHealth(100);
		super.setMaxHealthPoints(100);
		super.setAttackValue(5);
	}
	
	public Player(String name)
	{
		super.setName(name);
		super.setCurrentHealth(100);
		super.setMaxHealthPoints(100);
		super.setAttackValue(5);
	}
	
	/*
	 * Method - addItemToBag
	 * Purpose - adds Collectible to the itemPouch ArrayList
	 * @Param Collectible aCollectibleItem
	 */
	public void addItemToBag(Collectible aCollectableItem)
	{
		itemPouch.add(aCollectableItem);
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
	 * @return the roomsVisited
	 */
	public ArrayList<String> getRoomsVisited()
	{
		return roomsVisited;
	}

	/**
	 * @param roomsVisited the roomsVisited to set
	 */
	public void setRoomsVisited(ArrayList<String> roomsVisited)
	{
		this.roomsVisited = roomsVisited;
	}
	
	/*
	 * Method - addItemsToPouch
	 * @param collectible
	 * Return - Void
	 * Recieves items and adds them to the player's inventory.
	 */

	public void addItemsToPouch(Collectible collectible)
	{
		this.itemPouch.add(collectible);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Player [itemPouch=" + itemPouch + ", roomsVisited=" + roomsVisited + ", getCurrentRoom()="
				+ getCurrentRoom() + ", getCurrentHealth()=" + getCurrentHealth() + ", getAttackValue()="
				+ getAttackValue() + ", getMaxHealthPoints()=" + getMaxHealthPoints() + ", getName()=" + getName() + ", isAlive()=" + isAlive() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
