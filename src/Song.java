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
	 * Compares this song against a given song for order
	 * @param s Song to compare to
	 * @return Negative if this string is smaller, 0 if equal, positive if this string is greater
	 */
	public int compareTo(Song s){
		if(artist.compareToIgnoreCase(s.getArtist()) == 0){
			return title.compareToIgnoreCase(s.getTitle());
		}
		return artist.compareToIgnoreCase(s.getArtist());
	}
	/**
	 * Transforms the song into a string
	 * @return Song information as a string
	 */
	public String toString(){
		return title + "," + artist + "," + album + "," + length;
	}
	/**
	 * Gets the count of songs
	 * @return Song count
	 */
	public int songCount(){
		return songCount;
	}
}
