import java.util.*;
import java.io.*;

public class Jukebox1{
	ArrayList<Song> songList = new ArrayList<Song>();
	public static void main(String[] args){
		new Jukebox1().go();
}
	public void go(){
		getSongs();
		System.out.println(songList);
		//Call the static Collections sort() method, then print hte //list again. This time the print out is in alphabetical order.
		Collections.sort(songList);
		System.out.println(songList);
}
/*just read the file and call the addSong() method for each line.*/
	void getSongs(){
		try{
			File file = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=reader.readLine()) != null){
				addSong(line);
}
}catch(Exception ex){
	ex.printStackTrace();
}
}
	/*The addSong break the line(that has both the title and artist ) into two pieces(tokens) using the split() method*/
	void addSong(String lineToParse){
		String[] tokens = lineToParse.split("/");
		//only want the song title, so add only the first token to the SongList(the ArrayList)
		songList.add(tokens[0]);
}
}