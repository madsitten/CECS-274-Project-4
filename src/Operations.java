import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Operations for the song organizer, utilized by the GUI.
 * Includes file loading and saving, as well as searches, adding, deleting and displaying.
 * 
 * @author Julian Poyourow
 *
 */

public class Operations {
	/**
	 * Search for a song by title, and if found display all info about particular song
	 * @param songList LinkedList of songs to search through
	 */
	public static void searchTitle(LinkedList songList){
		System.out.println("Enter a song title:");
		String query = getUserString();
		int i = 0;
		while(i < songList.size()){
			if(songList.get(i).getValue().getTitle().equalsIgnoreCase(query)){
				System.out.println(songList.get(i).getValue());
			}
			i++;
		}
	}
	/**
	 * Search for songs by artist, and if found display all info about songs
	 * @param songList LinkedList of songs to search through
	 */
	public static void searchArtist(LinkedList songList){
		System.out.println("Enter an artist:");
		String query = getUserString();
		int i = 0;
		while(i < songList.size()){
			if(songList.get(i).getValue().getArtist().equalsIgnoreCase(query)){
				System.out.println(songList.get(i).getValue());
			}
			i++;
		}
	}
	/**
	 * Search for songs by album, and if found display all info about songs
	 * @param songList LinkedList of songs to search through
	 */
	public static void searchAlbum(LinkedList songList){
		System.out.println("Enter an album:");
		String query = getUserString();
		int i = 0;
		while(i < songList.size()){
			if(songList.get(i).getValue().getAlbum().equalsIgnoreCase(query)){
				System.out.println(songList.get(i).getValue());
			}
			i++;
		}
	}
	/**
	 * Search for a song by index, and if found display all info about song
	 * @param songList LinkedList of songs to search through
	 */
	public static void searchIndex(LinkedList songList){
		System.out.println("Enter an index:");
		int query = getUserInt();
		if(query >= 0 && query < songList.size()){
			System.out.println(songList.get(query).getValue());
		} else {
			System.out.println("Index out of bounds");
		}
	}
	/**
	 * Add a song to the songList
	 * @param songList LinkedList of songs to add to
	 */
	public static void addSong(LinkedList songList){
		System.out.println("Enter the Title:");
		String title = getUserString();
		System.out.println("Enter the Artist:");
		String artist = getUserString();
		System.out.println("Enter the Album:");
		String album = getUserString();
		System.out.println("Enter the Length (m:ss):");
		String length = getUserString();
		
		Song newSong = new Song(title, artist, album, length);
		songList.add(newSong);
		System.out.println("Your song has been added!");
	}
	/**
	 * Modify a song in the songList
	 * @param songList LinkedList of songs to modify in
	 */
	public static void modifySong(LinkedList songList){
		int i = 0;
		while(i < songList.size()){
			System.out.print(i + 1);
			System.out.println(" " + songList.get(i).getValue());
			i++;
		}
		System.out.println("Enter an index number to modify or -1 to cancel:");
		int indexNumber = getUserInt();
		if(indexNumber == -1){
			System.out.println("Cancelled");
		} else if (indexNumber < -1 || indexNumber == 0 || indexNumber - 1 >= songList.size()){
			System.out.println("Out of range");
		} else {
			System.out.println("Enter number to modify 1. Title 2. Artist 3. Album 4. Length");
			Song modSong = songList.get(indexNumber - 1).getValue();
			switch(getUserInt()){
				case 1:
					System.out.println("Enter a new title");
					modSong.setTitle(getUserString());
					break;
				case 2:
					System.out.println("Enter a new artist");
					modSong.setArtist(getUserString());
					break;
				case 3:
					System.out.println("Enter a new album");
					modSong.setAlbum(getUserString());
					break;
				case 4:
					System.out.println("Enter a new length (m:ss)");
					modSong.setLength(getUserString());
					break;
			}
			System.out.println("Your song has been modified!");
		}
	}
	/**
	 * Deletes a song based on an index value provided by a user from a given list of songs
	 * @param songList LinkedList of songs to delete from
	 */
	public static void deleteIndex(LinkedList songList){
		int i = 0;
		while(i < songList.size()){
			System.out.print(i + 1);
			System.out.println(" " + songList.get(i).getValue());
			i++;
		}
		System.out.println("Enter an index number to delete or -1 to cancel:");
		int indexNumber = getUserInt();
		if(indexNumber == -1){
			System.out.println("Cancelled");
		} else if (indexNumber < -1 || indexNumber == 0 || indexNumber - 1 >= songList.size()){
			System.out.println("Out of range");
		} else {
			songList.remove(i - 1);
		}
	}
	/**
	 * Deletes a song based on the title provided by a user
	 * @param songList LinkedList of songs to delete from
	 */
	public static void deleteTitle(LinkedList songList){
		System.out.println("Enter a song title:");
		String query = getUserString();
		int i = 0;
		while(i < songList.size()){
			if(songList.get(i).getValue().getTitle().equalsIgnoreCase(query)){
				break;
			}
			i++;
		}
		int indexNumber = i;
		if(indexNumber == -1){
			System.out.println("Cancelled");
		} else if (indexNumber < -1 || indexNumber >= songList.size()){
			System.out.println("Out of range");
		} else {
			songList.remove(indexNumber);
		}
	}
	/**
	 * Displays the total number of songs in the organizer
	 * @param songList LinkedList of songs
	 */
	public static void dispTotal(LinkedList songList){
		System.out.println(songList.size() + " Songs");
	}
	/**
	 * Displays songs sorted by song title
	 * @param songListUntouchable LinkedList of songs to sort (list is untouchable)
	 */
	public static void dispTitle(LinkedList songListUntouchable){
		LinkedList songList = songListUntouchable.clone();
		//Sort the ArrayList
		int i = 0;
		while(i < songList.size()){
			int j = 0;
			while(j < songList.size()){
				if(songList.get(i).getValue().getTitle().compareToIgnoreCase(songList.get(j).getValue().getTitle()) < 0){
					Song tempi = songList.get(i).getValue();
					Song tempj = songList.get(j).getValue();
					songList.remove(i);
					songList.add(tempj, i);
					songList.remove(j);
					songList.add(tempi, j);
				}
				j++;
			}
			i++;
		}
		
		//Print out the results
		i = 0;
		while(i < songList.size()){
			System.out.println(songList.get(i).getValue());
			i++;
		}
	}
	/**
	 * Displays songs sorted by song album
	 * @param songListUntouchable LinkedList of songs to sort (list is untouchable)
	 */
	public static void dispAlbum(LinkedList songListUntouchable){
		LinkedList songList = songListUntouchable.clone();
		//Sort the ArrayList
		int i = 0;
		while(i < songList.size()){
			int j = 0;
			while(j < songList.size()){
				if(songList.get(i).getValue().getAlbum().compareToIgnoreCase(songList.get(j).getValue().getAlbum()) < 0){
					Song tempi = songList.get(i).getValue();
					Song tempj = songList.get(j).getValue();
					songList.remove(i);
					songList.add(tempj, i);
					songList.remove(j);
					songList.add(tempi, j);
				}
				j++;
			}
			i++;
		}
		
		//Print out the results
		i = 0;
		while(i < songList.size()){
			System.out.println(songList.get(i).getValue());
			i++;
		}
	}
	/**
	 * Displays songs sorted by artist, and secondarily by songs
	 * @param songList LinkedList of songs to sort
	 */
	public static void dispArtist(LinkedList songList){
		System.out.println(songList);
	}
	/**
	 * Get user input in the form of a string
	 * @return String entered by user
	 */
	public static String getUserString(){
		Scanner userInput = new Scanner(System.in);
		return userInput.nextLine();
	}
	/**
	 * Get user input in the form of an int
	 * @return Int entered by user
	 */
	public static int getUserInt(){
		Scanner userInput = new Scanner(System.in);
		
		//Collect and validate user response for menu choices
		Boolean validInput = true;
		if(!userInput.hasNextInt()){
			System.out.println("Incorrect input.");
			validInput = false;
		}
		if(validInput == true) { 
			 return userInput.nextInt();
		} else {
			return -1;
		}
	}
	
	// FILE OPERATIONS
	
	/**
	 * Load songs from file into a LinkedList
	 * @return LinkedList of assorted songs
	 */
	public static LinkedList loadSongs(){
		LinkedList songList = new LinkedList();
		
		//Read the file
		try{
			Scanner read = new Scanner(new File("Songs.txt"));
			do{
				String line = read.nextLine();
				Scanner s = new Scanner(line).useDelimiter(",");
				Song mySong = new Song(s.next(), s.next(), s.next(), s.next());
				songList.add(mySong);
			}while(read.hasNext());
			read.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		return songList;
	}
	/**
	 * Save songs to file from an LinkedList
	 * @param songList LinkedList of assorted songs
	 */
	public static void saveSongs(LinkedList songList){
		//Write to file
		try{
			PrintWriter writer = new PrintWriter("Songs.txt");
			for(int i=0; i<songList.size(); i++){
				writer.println(songList.get(i).getValue());
			}
			writer.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
	}
}
