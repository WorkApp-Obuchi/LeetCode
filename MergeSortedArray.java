package LeetCode;

public class MergeSortedArray {

    /**
     * 2つの昇順ソート済み配列 nums1 と nums2 をマージし、
     * nums1 内に昇順で格納するメソッド。
     *
     * nums1 には nums2 の要素を格納できるだけの十分なスペース（0埋め部分）がある前提。
     *
     * 例:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6], n = 3
     * → 出力: nums1 = [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // nums1 の最後の有効要素のインデックス
        int i = m - 1;

        // nums2 の最後の要素のインデックス
        int j = n - 1;

        // nums1 の末尾（マージ結果を格納していく場所）
        int k = m + n - 1;

        // nums1 と nums2 の両方に要素がある間、後ろから大きい方を配置していく
        while (i >= 0 && j >= 0) {
            // nums1 の値の方が大きければそれを末尾に置く
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                // nums2 の値の方が大きければそれを末尾に置く
                nums1[k] = nums2[j];
                j--;
            }
            k--; // 次の末尾の位置へ
        }

        /**
         * 残りの nums2 の要素を nums1 にコピーする
         * （nums1 の方が先に尽きた場合）
         *
         * 例:
         * nums1 = [4,5,6,0,0,0], nums2 = [1,2,3]
         * → 上の while が終わった時点で nums1 は [4,5,6,4,5,6]
         * → ここで nums2 の残り（1,2,3）を先頭に埋める
         */
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }

        /**
         * nums1 側に要素が残っている場合はコピー不要。
         * （既に nums1 に格納済みであり、昇順が保たれているため）
         */
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        // ✅ テストケース1：一般的なケース
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println("結果1: " + java.util.Arrays.toString(nums1));
        // → [1, 2, 2, 3, 5, 6]

        // ✅ テストケース2：nums1 のすべてが nums2 より大きい
        int[] nums3 = {4, 5, 6, 0, 0, 0};
        int m2 = 3;
        int[] nums4 = {1, 2, 3};
        int n2 = 3;
        solution.merge(nums3, m2, nums4, n2);
        System.out.println("結果2: " + java.util.Arrays.toString(nums3));
        // → [1, 2, 3, 4, 5, 6]

        // ✅ テストケース3：nums1 が空、nums2 のみ存在
        int[] nums5 = {0};
        int m3 = 0;
        int[] nums6 = {1};
        int n3 = 1;
        solution.merge(nums5, m3, nums6, n3);
        System.out.println("結果3: " + java.util.Arrays.toString(nums5));
        // → [1]

        // ✅ テストケース4：nums2 が空（マージ不要）
        int[] nums7 = {1};
        int m4 = 1;
        int[] nums8 = {};
        int n4 = 0;
        solution.merge(nums7, m4, nums8, n4);
        System.out.println("結果4: " + java.util.Arrays.toString(nums7));
        // → [1]
    }
}