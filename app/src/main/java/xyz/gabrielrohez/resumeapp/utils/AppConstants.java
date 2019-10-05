package xyz.gabrielrohez.resumeapp.utils;

import xyz.gabrielrohez.resumeapp.R;

public class AppConstants {
    public static final String BASE_URL             = "https://raw.githubusercontent.com/SonGabo/ResumeApp/master/jsonfile/";
    public static final String TAG_SPLASH_DIALOG    = "TAG_SPLASH_DIALOG";
    public static final String TAG_ABOUT_FRAGMENT   = "TAG_ABOUT_FRAGMENT";


    // paralax
    //  https://stackoverflow.com/questions/26990195/imageview-parallax-as-you-scroll


    /**
     * Interest enum
     */
    public enum Interest {
        MUSIC(1, R.drawable.ic_music),
        SOCCER(2, R.drawable.ic_brightness),
        RUN(3, R.drawable.ic_run),
        PHOTOGRAPHY(4, R.drawable.ic_camera),
        GAMES(5, R.drawable.ic_videogame),
        TRAVEL(6, R.drawable.ic_airplanemode);

        private int id;
        private int image;

        Interest(int id, int image) {
            this.id = id;
            this.image = image;
        }

        public int getId() {
            return id;
        }

        public int getImage() {
            return image;
        }

        public static int getImageFromId(int i) {
            switch (i){
                case 1:
                    return MUSIC.getImage();
                case 2:
                    return SOCCER.getImage();
                case 3:
                    return RUN.getImage();
                case 4:
                    return PHOTOGRAPHY.getImage();
                case 5:
                    return GAMES.getImage();
                case 6:
                    return TRAVEL.getImage();
            }
            return i;
        }
    }
}
