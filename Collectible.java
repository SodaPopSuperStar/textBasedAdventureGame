package mockTextGameProject;

public class Collectible
{
	private String name;
	private String physicalDescription;	
	private String itemPurpose;
	private boolean isEdible;
	private int attackYield;
	
	public Collectible()
	{
		this.name = "Sword";
		this.physicalDescription = "A sharp steel blade.";
		this.itemPurpose = "This item gives +5 Attack power";
		this.isEdible = false;
		this.attackYield = 5;
		
	}
	public Collectible(int itemId, String name, String physicalDescription, String itemPurpose, boolean isEdible, int itemStat)
	{
		this.name = name;
		this.physicalDescription = physicalDescription;
		this.itemPurpose = itemPurpose;
		this.isEdible = isEdible;
		if(isEdible)
		{
			
		}
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
	 * @return the physicalDescription
	 */
	public String getphysicalDescription()
	{
		return physicalDescription;
	}

	/**
	 * @param physicalDescription the physicalDescription to set
	 */
	public void setphysicalDescription(String physicalDescription)
	{
		this.physicalDescription = physicalDescription;
	}

	/**
	 * @return the itemPurpose
	 */
	public String getitemPurpose()
	{
		return itemPurpose;
	}

	/**
	 * @param itemPurpose the itemPurpose to set
	 */
	public void setitemPurpose(String itemPurpose)
	{
		this.itemPurpose = itemPurpose;
	}

	/**
	 * @return the isEdible
	 */
	public boolean isEdible()
	{
		return isEdible;
	}

	/**
	 * @param isEdible the isEdible to set
	 */
	public void setEdible(boolean isEdible)
	{
		this.isEdible = isEdible;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Collectible [name=" + name + ", physicalDescription=" + physicalDescription + ", itemPurpose=" + itemPurpose + ", isEdible=" + isEdible + ", attackYield=" + attackYield + "]";
	}

	

	
	
}
