import java.util.Scanner;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.Write;

public class jMidi {
 
    public static void main(String[] args){

        Phrase p = new Phrase();
        int[] pattern = new int[12];
        Scanner scan = new Scanner(System.in);
        int pitchin, i = 0;
        while(i< 11){
        pitchin = scan.nextInt();
        pattern[i] = pitchin;
        }   
    }
    public class melodyFunction{
        
        public void fnGen(){
        Phrase phrase = new Phrase();
        int[] pitches = new int[128];
        for(int i=0; i < pitches.length; i++){
            // EBL1 = 40 CTL2 = 84 1==1/12 Chromatic Key
            pitches[i] = (50+((i+1)^i)^(i/2));
            if(pitches[i] > 82){
                while(pitches[i] > 82){
                pitches[i] = pitches[i] - 12;
                }
            }
            else if(pitches[i] < 60) {     
                while(pitches[i] < 60){
                pitches[i] = pitches[i] + 12;
                }
            }
            Note n = new Note(pitches[i], .25);
            phrase.addNote(n);
        }
        // Play.midi(phrase);
        Write.midi(phrase, "midifile.mid");
        }
    }
}
