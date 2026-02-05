package LeetCode.DFS;

public class GuessGame {
    private int pick;

    public int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num < pick){
            return 1;
        } else {
            return 0;
        }
    }
}
