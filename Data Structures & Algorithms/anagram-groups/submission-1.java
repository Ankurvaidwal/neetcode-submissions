class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str : strs){
            String sortedStr  = getSortedString(str);
            List<String> newList = new ArrayList<String>();
            if(map.containsKey(sortedStr)){
                newList = map.get(sortedStr);
            }
                newList.add(str);
                map.put(sortedStr,newList);
        }

        // List<List<String>> finalList = new ArrayList<List<String>>();
        // for(List<String> list: map.values()){
        //     finalList.add(list);
        // }

        return new ArrayList<>(map.values());
    }

    public String getSortedString(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
