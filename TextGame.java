/*
 * Author : Jordan Harrison
 * Date 11/11/2019
 * Software Development 1
 */

package mockTextGameProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextGame 
{
	private Scanner input = new Scanner(System.in);
	private String currentStringInFile = "";
	private Scanner sc = new Scanner(System.in);
	private ArrayList <Room> listOfRooms = new ArrayList<Room>();
	private ArrayList<Collectible> listOfCollectibles = new ArrayList<Collectible>();
	private boolean inGame = false;
	private String  answer = ""; private String pickupCommand; private String dropCommand; private String consumeCommand;
	Player ourPlayer;
	
	public static void main(String[] args)
	{ 
		TextGame tester = new TextGame();
		//tester.writeFile(fileName);
		tester.playGame();
	}
	
	/*
	 * Method - createRoomObject
	 * @param - File file 
	 * Return - This method reads a file formated for the game. It take the information and separates it into the key information needed for a Room class. It then creates a new room for every applicable subdivision in the given text file.
	 */
	
	public void readRoomObjectsFromFile(File file)
	{
		int counter = 0;
		Integer roomNum = 0;
		String roomName = "";
		String roomDesc = ""; 
		ArrayList <String> roomDirections = new ArrayList<String>();
		try 
		{
			input = new Scanner(file);
			while(input.hasNextLine())
			{ 
				currentStringInFile = input.nextLine();
				switch(counter)
				{
				case 0:roomNum = Integer.parseInt(currentStringInFile);
				break;
				case 1: roomName = currentStringInFile;
				break;
				case 2: roomDesc = currentStringInFile;
				break;
				}
				if(counter >= 4)
				{
					// two underscores in a line signifies the end of a room inside the text file
				 	if(currentStringInFile.contains("__"))
				 	{
				 		Room newRoom = new Room(roomNum, roomName, roomDesc, roomDirections); //creates new room 
				 		listOfRooms.add(newRoom);  //adds new room to the list
				 		roomNum = 0; roomName = "";roomDesc = "";roomDirections.clear(); //reset all of the room values
				 		counter = -1;
				 	}
				 	else
				 	{
				 		roomDirections.add(currentStringInFile);
				 	}
				}
				counter++;
			}
		}
		catch (FileNotFoundException fne)
		{
			fne.printStackTrace();
		}
	}
	 
	/*
	 * Method - writeFile
	 * @Param - File file
	 * Return - Void
	 */
	
	public void writeFile(String fileName)
	{
		try
		{
			FileWriter fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);
			System.out.println("What would like to write the file? ");
			String writtenToFile = input.nextLine();
			pw.write(writtenToFile);
			pw.close();
		} 
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}		
	}
	
	/*
	 *  creates a new player named The joker and returns it
	 */
	
	public Player createNewPlayer()
	{
		Player newPlayer = new Player(" The Joker");
		return newPlayer;
	}
	
	/*
	 * Method - playGame
	 * @Param - void
	 * Return - void
	 * This method starts the game 
 	 */
	
	public void playGame() 
	{
		int counter = 0;
		this.inGame = true;
		this.ourPlayer = createNewPlayer();
		//File file = new File("C:\\Users\\callm\\Oxygen Workspace\\SoftwareDevelopment1\\src\\Room.txt");//src : textfile.txt
		File file = new File("Room.txt");
		readRoomObjectsFromFile(file);
		//setupItems(new File("C:\\Users\\callm\\Oxygen Workspace\\SoftwareDevelopment1\\src\\Items.txt")); //sorry Dr.b I dont understand how to get my file to read from the SRC. 
		setupItems(new File("Items.txt"));
		System.out.println("\t    Welcome into the Game : Vacuum Game");
		System.out.println("\t -------------------------------------------");
		//commenceFight(ourPlayer,new Monster());
		//Testing Currently
		for(int i = 0; i < listOfRooms.size(); i++)
		{
			System.out.println( "\t : " + listOfRooms.get(i).getroomName() + " has connections to " +  listOfRooms.get(i).getRoomNumberAndName().toString());
		}
		listOfRooms.get(2).addItemIntoRoom(new Collectible());
		listOfRooms.get(4).addMonstersToRoom(new Monster());
		System.out.println();
		
		while(inGame)
		{
		System.out.println("\t Visited List : " + ourPlayer.getRoomsVisited().toString());
		System.out.println("\t You are in : " + listOfRooms.get(ourPlayer.getCurrentRoom()).getroomName()); //
		if(listOfRooms.get(ourPlayer.getCurrentRoom()).getHeldItemList().isEmpty())
		{
			
		}
		else 
		{
		System.out.println("\t Room Items : " + listOfRooms.get(ourPlayer.getCurrentRoom()).getHeldItemList());
		}
		System.out.println("\t --------------------------------------------------");
		System.out.println("\t " + listOfRooms.get(ourPlayer.getCurrentRoom()).getroomDesc());
		System.out.println("\t Where would you like to go? If an item is present in the room, you may pick it up using the pickup command");
		answer = sc.nextLine();	
		
		//make method to determine what is contained in answer so that we can deduce what method the command should be sent to
		
		try
		{
			goToRoom(answer);
		} 
		catch (InvalidInputException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 
	}
	
	// go to Outside building 
	//loops through listOfRoomNames
	//if is inside the list and current room has connection to the room ---> go to room
	
	/*
	 * 
	 */
	
	public void goToRoom(String direction) throws InvalidInputException
	{
		// if the room's hashmap contains direction
		int currentRoomNum = ourPlayer.getCurrentRoom();
		ArrayList <String> hashDirections = new ArrayList <String>();
		for(int i = 0; i < listOfRooms.get(currentRoomNum).getMapRoomConnections().size(); i++)
		{
		//	hashDirections.add(listOfRooms.get(currentRoomNum).getMapRoomConnections().get(i)) ;
			System.out.println(listOfRooms.get(currentRoomNum).getMapRoomConnections().get(i));
		}
		// add rooms visited
		if(!ourPlayer.getRoomsVisited().contains(listOfRooms.get(currentRoomNum).getroomName()))
		ourPlayer.getRoomsVisited().add(listOfRooms.get(currentRoomNum).getroomName());
		
		if(listOfRooms.get(currentRoomNum).getMapRoomConnections().containsKey(direction))
		{
			//System.out.println(listOfRooms.get(currentRoomNum).getMapRoomConnections().toString());
			//update and take the player to the requested room
			this.ourPlayer.setCurrentRoom(listOfRooms.get(currentRoomNum).getMapRoomConnections().get(direction)-1); // Give direction -> Return the mapping S
		}
		
		else
		{
			throw new InvalidInputException("This room doesnt have access to that direction");
		}	
	}
	
	/*
	 * 
	 */
	
	public void setupItemCommands(File file)
	{
		// read from file to field variables commands. 
	}
	
	/*
	 * Method - setupItems
	 * @Param - File file
	 * Return - void
	 */
	
	public void setupItems(File file)
	{
			int counter = 0; int itemNum = 0; String itemName = ""; String itemDesc = "";
			boolean isEdible = false; String itemPurpose = ""; int itemStat = 0; this.currentStringInFile = "";
		try
		{
			input = new Scanner(file);

			if(input.hasNextLine());
			while(input.hasNextLine())
			{
			currentStringInFile = input.nextLine();
			switch(counter)
			{
			case 0 : itemNum = Integer.parseInt(currentStringInFile);
			break;
			case 1 : itemName = currentStringInFile;
			break;
			case 2 : itemDesc = currentStringInFile;
			break;
			case 3 : isEdible = Boolean.parseBoolean(currentStringInFile); 
			break;
			case 4 : 
			if(isEdible)
			{
				itemPurpose = "Consume";
			}
			else
			{
				itemPurpose = "Equipment";
			}
			itemStat = Integer.parseInt(currentStringInFile);
			break;
			case 5 : Collectible newCollectible = new Collectible(itemNum, itemName, itemDesc, itemPurpose, isEdible,itemStat);
			listOfCollectibles.add(newCollectible);
			itemNum = 0; itemName = ""; itemDesc = ""; itemPurpose = ""; isEdible = false; itemStat = 0;
			counter = -1;
			}
			counter++;
			}
			//testing
			//System.out.println("\t" + listOfCollectibles);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 *  
	 */
	
	public void pickupItem(String command)
	{
		if(command.toLowerCase().contains(pickupCommand.toLowerCase()))
		{
			if(true)
			{
				
			}
		}
	}
	
	public Player commenceFight(Player player, Monster monster)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\t -------------------------------------------");
		System.out.println("\t Battle Sequence has commenced between" + player.getName() + " and " + monster.getName());
		while(player.isAlive() && monster.isAlive())
		{
			player.setAttackValue(50);
			System.out.println("\t" + player.getName() + " HP : " + player.getCurrentHealth() + "/" + player.getMaxHealthPoints());
			System.out.println("\t" + monster.getName() + " HP : " + monster.getCurrentHealth() + "/" + monster.getMaxHealthPoints());
			if(!player.isAlive())
			{
				System.out.println("\t You have died.\n\t You truly are foolish.");
				this.inGame = false;
			}
			System.out.println("\t What will you do? Attack, Converse or Run?");
			String command = input.nextLine();
		    if(command.toLowerCase().equals("run"))
			{
				//Return the player to the last index of the list of roomsVisited
				//Reset the display
				return player;
			}
			else if(command.toLowerCase().equals("attack"))
			{
				System.out.println("\t" + player.getName() + " attacks " + monster.getName());
				System.out.println("\t" + monster.getName() + " has lost " + player.getAttackValue() + " points of damage.");
				monster.setCurrentHealth(monster.getCurrentHealth() - player.getAttackValue());
				//calculate damage
				System.out.println("\t" + monster.getName() + " has attacked you and you have lost " + monster.getAttackValue() + " health points.");
				player.setCurrentHealth(player.getCurrentHealth() - monster.getAttackValue());
			}
			else if(command.toLowerCase().equals("converse"))
			{
				System.out.println("\t Don't be a Panzy");
			}
			System.out.println("\t -------------------------------------------");
		}
		return player;
	}
	
	/*
	 * Adds items from a monsters inventory to a players inventory
	 */
	
	public void givePlayerSpoils(Player player, Monster monster)
	{
		while(!monster.getItemPouch().isEmpty())
		{
			player.addItemsToPouch(monster.getItemPouch().get(0));
			player.addItemsToPouch(monster.getItemPouch().remove(0));
		}
	}
}
