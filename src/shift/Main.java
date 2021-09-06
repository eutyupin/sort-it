package shift;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    private static boolean asc = false;
    private static boolean desc = false;
    private static boolean intValues = false;
    private static boolean stringValues = false;
    private  static ArrayList<String> inputFileNames;
    private static String outputFileName;
    private static ArrayList<ArrayList<String>> stringFiles = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> intFiles = new ArrayList<>();
    private static ArrayList<String> outStringList = new ArrayList<>();
    private static ArrayList<Integer> outIntList = new ArrayList<>();

    public static void main(String[] args) {
        checkForArgsCorrect(args);
        checkFirstArgument(args);
        fillDataLists(args);


    }

    private static void sortReceiveIntdData(ArrayList<ArrayList<Integer>> source) {
        outIntList.clear();
        Sorter sorter = new Sorter();
        outIntList.addAll(sorter.sortIntegerData(source));
    }

    private static void sortReceiveStringData(ArrayList<ArrayList<String>> source) {
        outStringList.clear();
        Sorter sorter = new Sorter();
        outStringList.addAll(sorter.sortStringData(source));
    }

    private static void fillDataLists(String[] args) {
        try {
            inputFileNames = ArgsReceiver.getInputFileNames(args);
            outputFileName = ArgsReceiver.getOutputFileName(args);
             } catch (ArrayIndexOutOfBoundsException e) {
            printNotification();
            }

        try {
            for (String fileName : inputFileNames) {
                File inputFile = new File(fileName);
                if (inputFile.exists()) {
                        if (stringValues) {
                            ArrayList<String> tmpList = new ArrayList<>();
                            String tmpLine;
                            BufferedReader readData = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
                            while ((tmpLine = readData.readLine()) != null) {
                                tmpList.add(tmpLine);
                            }
                            stringFiles.add(tmpList);
                            readData.close();
                        }
                        if (intValues) {
                            ArrayList<Integer> tmpList = new ArrayList<>();
                            String tmpLine;
                            BufferedReader readData = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
                            while ((tmpLine = readData.readLine()) != null) {
                                tmpList.add(Integer.parseInt(tmpLine));
                            }
                            intFiles.add(tmpList);
                            readData.close();
                        }
                    }
                }
        } catch (NullPointerException e) {
            System.out.println("No input files fonded");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkForArgsCorrect(String[] args) {
        if(args.length < 3) {
            printNotification();
        }
    }

    private static void printNotification() {
        System.out.println("Incorrect parameters!");
        System.out.print("First parameter (optional): '-a' or '-d' - sort order" +
                "\nSecond parameter: '-i' or '-s' data type: int or string" +
                "\nThird parameter: '-output file name'" +
                "\nFourth and more: '-input file name ...'\n");
    }

    private static void checkFirstArgument(String[] args) {
        if (args.length > 0) {
            asc = args[0].equals("-a");
            desc = args[0].equals("-d");
            intValues = args[0].equals("-i");
            stringValues = args[0].equals("-s");
            if(!asc && !desc) asc = true;
        }
        if (args.length > 0 && (args[0].equals("-a") || args[0].equals("-d"))) {
            intValues = args[1].equals("-i");
            stringValues = args[1].equals("-s");
        }
    }
}
