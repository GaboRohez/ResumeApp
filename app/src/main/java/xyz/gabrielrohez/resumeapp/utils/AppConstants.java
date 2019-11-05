package xyz.gabrielrohez.resumeapp.utils;

import xyz.gabrielrohez.resumeapp.R;

public class AppConstants {
    public static final String BASE_URL                 = "https://raw.githubusercontent.com/SonGabo/ResumeApp/master/jsonfile/";
    public static final String PATH_APP                 = "/storage/emulated/0/ResumeApp/";
    public static final String URL_PLAY_STORE           = "https://play.google.com/store/apps/dev?id=5223529151025295341";
    public static final String TAG_APPS_FRAGMENT        = "TAG_APPS_FRAGMENT";
    public static final String TAG_SPLASH_DIALOG        = "TAG_SPLASH_DIALOG";
    public static final String TAG_ABOUT_FRAGMENT       = "TAG_ABOUT_FRAGMENT";
    public static final String TAG_APPS_EXPERIENCE      = "TAG_APPS_EXPERIENCE";
    public static final String TAG_DOCUMENT_FRAGMENT    = "TAG_DOCUMENT_FRAGMENT";
    public static final String TAG_EDUCATION_FRAGMENT   = "TAG_EDUCATION_FRAGMENT";


    //  permission
    public static final int MY_PERMISSIONS_EXTERNAL_STORANGE_SHARED     = 200;
    public static final int MY_PERMISSIONS_EXTERNAL_STORANGE_DOWNLOAD   = 100;


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

    /**
     * Apps enum
     */
    public enum APPS {
        ECOBICI(1, R.drawable.ecobici),
        CV(2, R.drawable.cv),
        SHOWCITY(3, R.drawable.show_me_city),
        BINARIO(4, R.drawable.primario),
        CHALUPAS(5, R.drawable.chalupas),
        NETWORKED(6, R.drawable.networked),
        CESAR(7, R.drawable.cesar_pro),
        PRIMOS(8, R.drawable.numeros_primos),
        TMDB(9, R.drawable.tmdb),
        CAR(10, R.drawable.wheres_car),
        POLIBIO(11, R.drawable.polibio);

        private int id;
        private int image;

        APPS(int id, int image) {
            this.id = id;
            this.image = image;
        }

        public int getImage() {
            return image;
        }

        public int getId() {
            return id;
        }

        public static int getImage(int id){
            switch (id){
                case 1:
                    return ECOBICI.getImage();
                case 2:
                    return CV.getImage();
                case 3:
                    return SHOWCITY.getImage();
                case 4:
                    return BINARIO.getImage();
                case 5:
                    return CHALUPAS.getImage();
                case 6:
                    return NETWORKED.getImage();
                case 7:
                    return CESAR.getImage();
                case 8:
                    return PRIMOS.getImage();
                case 9:
                    return TMDB.getImage();
                case 10:
                    return CAR.getImage();
                case 11:
                    return POLIBIO.getImage();
            }
            return 0;
        }
    }
    /**
     * PDF files
     */
    public enum PDF_FILE {
        ANDROID("1", R.drawable.certificado_android, "certificado_android.pdf", "certificado_android.png"),
        JAVA("2", R.drawable.certificado_java,"certificado_java.pdf", "certificado_java.png"),
        DATABASE("3", R.drawable.certificado_bd,"certificado_bd.pdf", "certificado_bd.png"),
        SCHOOL("4", R.drawable.certificado_escolar,"certificado_escolar.pdf", "certificado_escolar.png");

        private String id;
        private int imageResource;
        private String nameInAssets;
        private String nameInDrawable;

        PDF_FILE(String id, int imageResource, String nameInAssets, String nameInDrawable) {
            this.id = id;
            this.imageResource = imageResource;
            this.nameInAssets = nameInAssets;
            this.nameInDrawable = nameInDrawable;
        }

        public String getId() {
            return id;
        }

        public String getNameInAssets() {
            return nameInAssets;
        }

        public String getNameInDrawable() {
            return nameInDrawable;
        }

        public int getImageResource() {
            return imageResource;
        }

        public static String getNameDrawable(String id) {
            switch (id){
                case "1":
                    return ANDROID.getNameInDrawable();
                case "2":
                    return JAVA.getNameInDrawable();
                case "3":
                    return DATABASE.getNameInDrawable();
                case "4":
                    return SCHOOL.getNameInDrawable();
            }
            return id;
        }

        public static String getNameFromId(String id) {
            switch (id){
                case "1":
                    return ANDROID.getNameInAssets();
                case "2":
                    return JAVA.getNameInAssets();
                case "3":
                    return DATABASE.getNameInAssets();
                case "4":
                    return SCHOOL.getNameInAssets();
            }
            return id;
        }

        public static int getImageFromId(String id) {
            switch (id){
                case "1":
                    return ANDROID.getImageResource();
                case "2":
                    return JAVA.getImageResource();
                case "3":
                    return DATABASE.getImageResource();
                case "4":
                    return SCHOOL.getImageResource();
            }
            return 0;
        }

    }
}
