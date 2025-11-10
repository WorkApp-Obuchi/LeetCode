class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet<>();

        for(int num :nums1){ //nums1の中での重複チェック
            map.add(num);
        }

        HashSet<Integer> result = new HashSet<>();
        for(int num :nums2){ //nums1とnums2での重複チェック
            if(map.contains(num)){
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        int i = 0;
        for(int num : result){
            ans[i++] = num;
        }
        return ans;
    }
}