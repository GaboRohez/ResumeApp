package xyz.gabrielrohez.resumeapp.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import xyz.gabrielrohez.resumeapp.R;

public class AppUtils {

    public static boolean internetIsConnected() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec(command).waitFor() == 0);
        } catch (Exception e) {
            return false;
        }
    }

    public  enum Colors{

        PINK(R.color.lighPink, R.color.darkPink),
        BLUE(R.color.lightBlue, R.color.darkBlue),
        GREEN(R.color.lightGreen, R.color.darkGreen),
        ORANGE(R.color.lightOrange, R.color.darkOrange);

        Colors(int lightColor, int darkColor) {
            this.lightColor = lightColor;
            this.darkColor = darkColor;
        }

        private int lightColor;
        private int darkColor;

        public int getLightColor() {
            return lightColor;
        }

        public int getDarkColor() {
            return darkColor;
        }

        private static final List<Colors> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static Colors randomColor()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }
}
