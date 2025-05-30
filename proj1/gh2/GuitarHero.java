package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    private GuitarString[] guitarStrings;
    public GuitarHero() {
        guitarStrings = new GuitarString[KEYBOARD.length()];
        for (int i = 0; i < KEYBOARD.length(); i++) {
            double frequency = CONCERT_A * Math.pow(2, (i - 24) / 12.0);
            guitarStrings[i] = new GuitarString(frequency);
        }
    };


    public static void main(String[] args) {
        GuitarHero gh = new GuitarHero();


        while (true) {

            /* check if the user has typed a key; if so, process it */
            int keyIndex = 0;
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                keyIndex = gh.KEYBOARD.indexOf(key);
                if (keyIndex != -1) {
                    gh.guitarStrings[keyIndex].pluck();
                }
            }
            if (keyIndex == -1) {
                keyIndex = 0;
            }
            double sample = gh.guitarStrings[keyIndex].sample() + gh.guitarStrings[24].sample();
            StdAudio.play(sample);
            gh.guitarStrings[keyIndex].tic();
            gh.guitarStrings[24].tic();

        }
    }
}

