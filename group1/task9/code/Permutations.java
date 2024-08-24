package group1.task9.code;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> storage;

    public Permutations() {
        storage = new ArrayList<>();
    }

    public void createPermutations(int value) {
        storage.clear();

        backTrackingPermutations(value, new ArrayList<>());
    }

    private void backTrackingPermutations(int value, List<Integer> temp) {
        if(temp.size() == value) {
            storage.add(new ArrayList<>(temp));
        } else {
            for(int i = 1; i <= value; i++) {
                if(temp.contains(i)) continue;
                temp.add(i);
                backTrackingPermutations(value, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void bubbleSortPermutations() {
        boolean bubbleSortTrigger = true;
    
        while (bubbleSortTrigger) {
            bubbleSortTrigger = false;
    
            for (int i = 0; i < storage.size() - 1; i++) {
                if (compareLists(storage.get(i), storage.get(i + 1)) > 0) {
                    List<Integer> temp = storage.get(i);
                    storage.set(i, storage.get(i + 1));
                    storage.set(i + 1, temp);
                    bubbleSortTrigger = true;
                }
            }
        }
    }
    
    private int compareLists(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
            if (list1.get(i) != list2.get(i)) {
                return Integer.compare(list1.get(i), list2.get(i));
            }
        }
        return Integer.compare(list1.size(), list2.size());
    }
    
    public List<List<Integer>> getPermutations() {
        return storage;
    }
}
