package LeetCode.Tree;

public class VersionControl {
    private int firstBad;  // テストケースごとに設定される

    boolean isBadVersion(int version) {
        return version >= firstBad;
    }
}
