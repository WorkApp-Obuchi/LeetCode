class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false; //文字の個数が一緒かどうか

        char[] sArr = s.toCharArray(); //String →char[] へ
        char[] tArr = t.toCharArray();//String →char[] へ

        Arrays.sort(sArr); //昇順で並び替え
        Arrays.sort(tArr); //昇順で並び替え

        return Arrays.equals(sArr,tArr); //比較してtrue,falseで返す
    }
}
