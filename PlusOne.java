package LeetCode;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // =============================================
        // 問題：配列で表現された整数に1を加算
        // 戦略：右端から処理し、繰り上がりを伝播
        // =============================================

        // 【防御的プログラミング】
        // nullポインタ例外を防ぐ
        if(digits == null) return null;

        // =============================================
        // メインロジック：右端から左へ繰り上がり処理
        // =============================================
        for(int i = digits.length - 1; i >= 0; i--) {
            // 現在の桁に1を加算
            // - 最初のループ：実際に+1を実行
            // - 2回目以降：前の桁からの繰り上がりを処理
            digits[i] += 1;

            // 【分岐1】繰り上がりなし（99%のケースはここで終了）
            if(digits[i] < 10) {
                return digits;  // 早期リターンで効率化
            }

            // 【分岐2】繰り上がりあり
            // 10になった場合、現在の桁を0にして次の桁へ
            digits[i] = 0;
            // ループ継続 → 次の桁（左隣）で digits[i] += 1 が実行される
        }

        // =============================================
        // 特殊ケース：全桁が9だった場合の処理
        // =============================================
        // ループを抜けた = 全ての桁で繰り上がりが発生
        // 例: [9,9,9] → [1,0,0,0]

        // 桁数を1つ増やした新しい配列を作成
        int[] result = new int[digits.length + 1];
        result[0] = 1;  // 最上位桁のみ1
        // result[1]～result[n]は自動的に0（Javaの初期値）

        return result;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();

        int[] digits1 = {1,2,3};
        int[] result1 = po.plusOne(digits1);
        System.out.println("PlusOne, digits1 : " + Arrays.toString(result1));

        int[] digits2 = {4,3,2,1};
        int[] result2 = po.plusOne(digits2);
        System.out.println("PlusOne, digits1 : " + Arrays.toString(result2));

        int[] digits3 = {9};
        int[] result3 = po.plusOne(digits3);
        System.out.println("PlusOne, digits1 : " + Arrays.toString(result3));
    }
}
