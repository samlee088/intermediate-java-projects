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

        while(bubbleSortTrigger) {
            bubbleSortTrigger = false;

            for(int i = 0; i < storage.size()-1; i++) {
                for(int j = 0; j < storage.get(0).size()-1; j++) {
                    if(storage.get(i).get(j) < storage.get(i+1).get(j+1)) {
                        List<Integer> temp = storage.get(i);
                        storage.set(i, storage.get(i+1));
                        storage.set(i+1, temp);
                        bubbleSortTrigger = true;
                    }
                }
            }

        }
    }
    
    public List<List<Integer>> getPermutations() {
        return storage;
    }
}
