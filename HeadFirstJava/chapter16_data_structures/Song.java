
/*
 The new song file holds four
attributes instead of just two.
And we want ALL of them in our
list, so we need to make a Song
class with instance variables for all
four song attributes.
 */
class Song implements Comparable<Song>{
	//four instance variables for the four song attributes in the file.
	String title;
	String artist;
	String rating;
	String bpm;

public int compareTo(Song s){
	return title.compareTo(s.getTitle()); 
}

/*contructor function : happens before assign the object to the reference variable (initialize the object)*/
/*the variables are all set in the constructor when the new Song is created.*/
Song(String t, String a, String r, String b) {
title = t;
artist = a;
rating = r;
bpm = b;
}

//getter methods for the four attributes

public String getTitle() {
return title;
}
public String getArtist() {
return artist;
}
public String getRating() {
return rating;
}
public String getBpm() {
return bpm;
}

	/*We override toString(), because when you do a System.
out.println(aSongObject), we want to see the title.
When you do a System.out.println(aListOfSongs), it calls
the toString() method of EACH element in the list.*/

public String toString() {
return title;
}
}
