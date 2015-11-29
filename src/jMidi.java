import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.Write;

public class jMidi {
 
    public static void main(String[] args){
        Phrase phrase = new Phrase();
        int[] pitches = new int[128];
        for(int i=0; i < pitches.length; i++){
            // EBL1 = 40 CTL2 = 84 1==1/12 Chromatic Key
            pitches[i] = (50+((i+1)^i)^(i/2));
            if(pitches[i] > 90){
            pitches[i] = pitches[i] /(3);
            }
            else if(pitches[i] < 40) {
                pitches[i] = (pitches[i]+12)*2;
            }
            Note n = new Note(pitches[i], .125);
            phrase.addNote(n);
        }
        
        Play.midi(phrase);
        Write.midi(phrase, "midifile.mid");   

        }   
    }
