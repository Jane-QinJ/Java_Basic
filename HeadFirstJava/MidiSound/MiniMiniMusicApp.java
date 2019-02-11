import javax.sound.midi.*;
public class MiniMiniMusicApp{
    public static void main(String[] args){
	MiniMiniMusicApp mini = new MiniMiniMusicApp();
	mini.play();
}//close main

public void play(){
    try{
        Sequencer player = MidiSystem.getSequencer();
        player.open();  //get a Sequencer and open it

        Sequence seq = new Sequence(Sequence.PPQ, 4);

        Track track = seq.createTrack(); //ask the sequence for a Track. The Track lives in the Sequence, and the MIDI data lives in the Track.
        //Make a  Message
        ShortMessage a = new ShortMessage();
       ShortMessage first = new ShortMessage();
        //Put the  Instruction  in the Message
        a.setMessage(144, 1, 20, 100);

//Make a new  MidiEvent  using the Message
        MidiEvent noteOn = new MidiEvent(a, 1);
  
//Add the MidiEvent to the  Track
        track.add(noteOn);


        ShortMessage b = new ShortMessage();
        b.setMessage(128,1,44,100);
        MidiEvent noteOff = new MidiEvent(b, 16);
        track.add(noteOff);

         player.setSequence(seq); //Give the Sequence to the Sequencer (like putting the CD in the CD player)
         player.start(); //Start() the Sequencer (like pushing PLAY)
}catch(Exception ex){
        ex.printStackTrace();
}
}// close play
} // close class