import java.util.ArrayList;
import java.util.Scanner;

/**
 * GUI for user input and recognition for a song organizer that will display, sort, add, delete songs from a list.
 * 
 * @author Julian Poyourow
 *
 */

public class GUI {
	public static void main(String[] args){
		//Get each grade array from file
		LinkedList songList = Operations.loadSongs();
		
		//Main menu loop marker for application quit
		mainloop:
		while(true){
			
			//Options for functions program is capable of with numbered index
			String userMenu = "1. Search by title\n"
					+ "2. Search by artist\n"
					+ "3. Search by album\n"
					+ "4. Search by index\n"
					+ "5. Add a song\n"
					+ "6. Modify a song\n"
					+ "7. Delete a song by index\n"
					+ "8. Delete a song by title\n"
					+ "9. Display number of songs\n"
					+ "10. Display by song title\n"
					+ "11. Display by artist\n"
					+ "12. Quit";
			System.out.println(userMenu);
			
			Scanner userInput = new Scanner(System.in);
			
			//Collect and validate user response for menu choices
			Boolean validInput = true;
			int userResponse = 0;
			if(!userInput.hasNextInt()){
				System.out.println("Incorrect input.");
				validInput = false;
			}
			if(validInput == true) { 
				userResponse = userInput.nextInt();
			}
			
			//Ensure user response is within required range
			if ((userResponse < 1 || userResponse > 12) && validInput == true) {
				System.out.println("Incorrect input.");
				validInput = false;
			}
			
			//Switch for user choice based on menu number
			if(validInput == true){
				switch(userResponse) {
					case 1: 
						Operations.searchTitle(songList);
						break;
					case 2:
						Operations.searchArtist(songList);
						break;
					case 3:
						Operations.searchAlbum(songList);
						break;
					case 4:
						Operations.searchIndex(songList);
						break;
					case 5:
						Operations.addSong(songList);
						break;
					case 6:
						Operations.modifySong(songList);
						break;
					case 7:
						Operations.deleteIndex(songList);
						break;
					case 8:
						Operations.deleteTitle(songList);
						break;
					case 9:
						Operations.dispTotal(songList);
						break;
					case 10:
						Operations.dispTitle(songList);
						break;
					case 11:
						Operations.dispArtist(songList);
						break;
					case 12:	
						Operations.dispTitle(songList);
						Operations.saveSongs(songList);
						System.out.println("Goodbye!");
						break mainloop;
				}
			}
		}
	}
}
