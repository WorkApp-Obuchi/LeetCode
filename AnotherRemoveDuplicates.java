package LeetCode;

/**
 * LeetCode 26. Remove Duplicates from Sorted Array
 * ソート済み配列から重複を削除するクラス
 */
public class AnotherRemoveDuplicates {

    /**
     * ソート済み配列から重複要素をin-placeで削除する
     *
     * @param nums ソート済みの整数配列
     * @return 重複削除後のユニークな要素数
     *
     * アルゴリズム: Two Pointer法
     * - 時間計算量: O(n) - 配列を1回走査
     * - 空間計算量: O(1) - 追加メモリ不使用
     *
     * 例:
     * 入力: [1,1,2]
     * 出力: 2 (配列は[1,2,_]に変更される)
     */
    public int removeDuplicates(int[] nums) {

        // エッジケース1: null配列の場合
        if(nums == null) return 0;

        // エッジケース2: 空配列または単一要素の場合
        // 長さ0または1なら重複はあり得ないので、そのまま長さを返す
        if(nums.length <= 1) return nums.length;

        // Two Pointerの初期化
        // k: 書き込み位置（次にユニークな値を置く位置）
        // 0番目は必ずユニークなので、1から開始
        int k = 1;

        // i: 読み取り位置（配列を順番に調べる位置）
        // 1番目から開始（0番目と比較するため）
        for(int i = 1; i < nums.length; i++) {

            // 現在の要素が前の要素と異なる場合（新しいユニークな値を発見）
            if(nums[i] != nums[i - 1]) {
                // ユニークな値を前方の位置kに移動
                // k++により、書き込み後に次の書き込み位置へ移動
                nums[k++] = nums[i];

                // 処理の流れ：
                // 1. nums[k] = nums[i] (現在のk位置に値をコピー)
                // 2. k = k + 1 (次の書き込み位置へ移動)
            }
            // 重複の場合は何もせず、iだけが進む
        }

        // kは「次に書き込む位置」を指しているので、
        // これがそのままユニークな要素の個数となる
        return k;
    }

    /**
     * メインメソッド - テスト実行用
     */
    public static void main(String[] args) {
        // テスト用インスタンスの作成
        AnotherRemoveDuplicates another = new AnotherRemoveDuplicates();

        // ========== テストケース1: 基本的なケース ==========
        int[] nums1 = {1,1,2};
        int result = another.removeDuplicates(nums1);
        System.out.println("output(result) : " + result); // 期待値: 2
        // 処理後の配列: [1,2,2] (最初の2要素が有効)

        // ========== テストケース2: 複数の重複を含むケース ==========
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int result2 = another.removeDuplicates(nums2);
        System.out.println("output(result2) : " + result2); // 期待値: 5
        // 処理後の配列: [0,1,2,3,4,2,2,3,3,4] (最初の5要素が有効)
    }
}