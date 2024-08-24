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
    
    public List<List<Integer>> getPermutations() {
        return storage;
    }
}
