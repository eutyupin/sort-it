package shift;

import java.util.ArrayList;

public class Sorter {

    public ArrayList<Integer> sortIntegerData(ArrayList<ArrayList<Integer>> listMega) {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();
        if (listMega.size() > 1) {
            first.addAll(listMega.get(0));
            for (int k = 1; k < listMega.size(); k++) {
                other.clear();
                other.addAll(listMega.get(k));
                int i = 0;
                int j = 0;
                while (true) {
                    if (j > other.size() - 1) {
                        break;
                    }
                    if (i > first.size() - 1) {
                        for (int x = j; x < other.size(); x++) {
                            first.add(i, other.get(x));
                            i++;
                        }
                        break;
                    }
                    if (first.get(i) > other.get(j)) {
                        first.add(i, other.get(j));
                        i++;
                        j++;
                    } else if (first.get(i) < other.get(j)) {
                        i++;
                    } else if (first.get(i).equals(other.get(j))) {
                        first.add(i, other.get(j));
                        i++;
                        j++;
                    }
                }
            }
        }
        return first;
    }

    public ArrayList<String> sortStringData(ArrayList<ArrayList<String>> listMega) {
        ArrayList<String> first = new ArrayList<>();
        ArrayList<String> other = new ArrayList<>();
        if (listMega.size() > 1) {
            first.addAll(listMega.get(0));
            for (int k = 1; k < listMega.size(); k++) {
                other.clear();
                other.addAll(listMega.get(k));
                int i = 0;
                int j = 0;
                while (true) {
                    if (j > other.size() - 1) {
                        break;
                    }
                    if (i > first.size() - 1) {
                        for (int x = j; x < other.size(); x++) {
                            first.add(i, other.get(x));
                            i++;
                        }
                        break;
                    }
                    if (first.get(i) > other.get(j)) {
                        first.add(i, other.get(j));
                        i++;
                        j++;
                    } else if (first.get(i) < other.get(j)) {
                        i++;
                    } else if (first.get(i).equals(other.get(j))) {
                        first.add(i, other.get(j));
                        i++;
                        j++;
                    }
                }
            }
        }
        return first;

        return null;
    }
}
