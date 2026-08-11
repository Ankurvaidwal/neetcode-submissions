class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, result, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> track) {
        if(nums.length == track.size()){
            result.add(new ArrayList<>(track));
            return;
        }
        for(int num :nums){
            if(!track.contains(num)){
                track.add(num);
                backtrack(nums,result,track);
                track.remove(track.size()-1);
            }
        }
    }
}
