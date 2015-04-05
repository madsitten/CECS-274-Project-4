/**
 * Song object for songs in songList
 * 
 * @author Julian Poyourow
 *
 */
public class Song {
	/**
	 * Counter for number of songs
	 */
	private static int songCount = 0;
	/**
	 * String for song title
	 */
	private String title;
	/**
	 * String for song artist
	 */
	private String artist;
	/**
	 * String for song album
	 */
	private String album;
	/**
	 * String for song length (time)
	 */
	private String length;
	
	/**
	 * Creates a song
	 * 
	 * @param title Song title
	 * @param artist Artist name
	 * @param album Album name
	 * @param length Song length (time)
	 */
	public Song(String title, String artist, String album, String length){
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.length = length;
		songCount++;
	}
	/**
	 * Provides the song title
	 * @return Song title
	 */
	public String getTitle(){
		return title;
	}
	/**
	 * Provides the song artist
	 * @return Song artist
	 */
	public String getArtist(){
		return artist;
	}
	/**
	 * Provides the song album
	 * @return Song album
	 */
	public String getAlbum(){
		return album;
	}
	/**
	 * Returns song information as a string
	 */
	public String toString(){
		return title + "," + artist + "," + album + "," + length;
	}
	/**
	 * Returns song count
	 */
	public int songCount(){
		return songCount;
	}
}
