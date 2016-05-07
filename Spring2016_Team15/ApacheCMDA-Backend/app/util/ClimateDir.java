package util;

import java.io.File;

public class ClimateDir {
    private static String path = "climateServiceRepository";
    private File theDir = null;

    private static ClimateDir instance = new ClimateDir();

    private ClimateDir(){
        theDir = new File("climateServicePageRepository");
        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: climateServicePageRepository");
            boolean create = false;

            try {
                theDir.mkdir();
                create = true;
            } catch (Exception se) {
                // handle it
            }
            if (create) {
                System.out.println("DIR created");
            }
        } else {
            System.out.println("No");
        }
    }

    public static ClimateDir getInstance(){
        return instance;
    }

    public File getDir(){
        return this.theDir;
    }

}

