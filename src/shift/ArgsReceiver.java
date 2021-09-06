package shift;

import java.util.ArrayList;

public class ArgsReceiver {

    public static ArrayList<String> getInputFileNames (String[] args) {
        if((args[0].equals("-a") || args[0].equals("-d")) && args.length > 0) return cropBigArgumentNames(args);
        else return cropSmallArgumentNames(args);
    }

    private static ArrayList<String> cropSmallArgumentNames(String[] args) {
        ArrayList<String> outFiles = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            outFiles.add(args[i]);
        }
        return  outFiles;
    }

    private static ArrayList<String> cropBigArgumentNames(String[] args) {
        ArrayList<String> outFiles = new ArrayList<>();
        for (int i = 3; i < args.length; i++) {
            outFiles.add(args[i]);
        }
        return outFiles;
    }

    public static String getOutputFileName(String[] args) {
        if(args[0].equals("-a") || args[0].equals("-d")) return args[2];
        else return args[1];
    }
}
