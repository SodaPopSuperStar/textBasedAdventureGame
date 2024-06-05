package mockTextGameProject;

import java.util.ArrayList;
import java.util.HashMap;

public class Room 
{
	private int roomNum = 0; private String roomName = ""; private String roomDesc = ""; private int counter = 0;
	private ArrayList<String> listOfDoorways = new ArrayList<String>(); //west 2 . . . ect
	private ArrayList<Integer> linkedRoomsNum = new ArrayList<Integer>(); // 1 , 2 , 3 ect
	private ArrayList<String> linkedRoomsCorrespondingDirections = new ArrayList<String>(); 
	private HashMap< String,Integer> mapRoomConnections = new HashMap<>(); 
	private ArrayList<Collectible> heldItemList = new ArrayList<Collectible>();
	private ArrayList<Monster> heldMosterList = new ArrayList<Monster>();
	
	public Room(int roomNumber, String roomName, String roomDesc,ArrayList<String> listOfDoorways)
	{
		this.roomNum = roomNumber;
		this.roomName = roomName;
		this.roomDesc = roomDesc;
		this.listOfDoorways.addAll(listOfDoorways);
		setuplinkedRoomsNum();
	}

	/**
	 * @return the roomNum
	 */
	public int getRoomNum()
	{
		return roomNum;
	}

	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(int roomNum)
	{
		this.roomNum = roomNum;
	}

	/**
	 * @return the roomName
	 */
	public String getroomName()
	{
		return roomName;
	}

	/**
	 * @param roomName the roomName to set
	 */
	public void setroomName(String roomName)
	{
		this.roomName = roomName;
	}

	/**
	 * @return the roomDesc
	 */
	public String getroomDesc()
	{
		return roomDesc;
	}

	/**
	 * @param roomDesc the roomDesc to set
	 */
	public void setroomDesc(String roomDesc)
	{
		this.roomDesc = roomDesc;
	}
	
	/*
	 * Method : hasAccessTo - Prints a list of room numbers this current room has access too. 
	 * @Param : empty
	 * Return : Void
	 */
	
	public void setuplinkedRoomsNum()
	{
		for(int i = 0; i < listOfDoorways.size();i++)
		{ 
			Integer doorNum = Integer.parseInt(listOfDoorways.get(i).substring(listOfDoorways.get(i).length()-1, listOfDoorways.get(i).length()));
			String doorName = listOfDoorways.get(i).substring(0,listOfDoorways.get(i).length()-2);
			mapRoomConnections.put( doorName, doorNum);
			
			linkedRoomsNum.add(Integer.parseInt(listOfDoorways.get(i).substring(listOfDoorways.get(i).length()-1, listOfDoorways.get(i).length())));
			linkedRoomsCorrespondingDirections.add(listOfDoorways.get(i).substring(0,listOfDoorways.get(i).length()-2));
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Room [roomNum=" + roomNum + ", roomName=" + roomName + ", roomDesc=" + roomDesc + ", counter=" + counter + ", roomNumberAndName=" + mapRoomConnections.toString() + "]";
	}

	/**
	 * @return the roomNumberAndName
	 */
	public HashMap<String , Integer> getRoomNumberAndName()
	{
		return mapRoomConnections;
	}

	/**
	 * @param roomNumberAndName the roomNumberAndName to set
	 */
	public void setRoomNumberAndName(HashMap<String , Integer> mapRoomConnections)
	{
		this.mapRoomConnections = mapRoomConnections;
	}

	/**
	 * @return the mapRoomConnections
	 */
	public HashMap<String, Integer> getMapRoomConnections()
	{
		return mapRoomConnections;
	}

	/**
	 * @param mapRoomConnections the mapRoomConnections to set
	 */
	public void setMapRoomConnections(HashMap<String, Integer> mapRoomConnections)
	{
		this.mapRoomConnections = mapRoomConnections;
	}

	/*
	 * 
	 */
	
	public void addItemIntoRoom(Collectible collectible)
	{
		heldItemList.add(collectible);
	}

	/**
	 * @return the heldItemList
	 */
	public ArrayList<Collectible> getHeldItemList()
	{
		return heldItemList;
	}

	/**
	 * @param heldItemList the heldItemList to set
	 */
	public void setHeldItemList(ArrayList<Collectible> heldItemList)
	{
		this.heldItemList = heldItemList;
	}

	/**
	 * @return the heldMosterList
	 */
	public ArrayList<Monster> getHeldMosterList()
	{
		return heldMosterList;
	}

	/**
	 * @param heldMosterList the heldMosterList to set
	 */
	
	public void setHeldMosterList(ArrayList<Monster> heldMosterList)
	{
		this.heldMosterList = heldMosterList;
	}
	
	/*
	 * 
	 */
	
	public void addMonstersToRoom(Monster monster)
	{
		this.heldMosterList.add(monster);
	}
	
	/*
	 * 
	 */
	
	public void removeMonsterFromRoom(int index)
	{
		this.heldMosterList.remove(index);
	}
	
}
