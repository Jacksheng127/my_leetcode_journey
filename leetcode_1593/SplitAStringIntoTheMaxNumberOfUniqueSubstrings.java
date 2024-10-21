import java.util.HashSet;

class SplitAStringIntoTheMaxNumberOfUniqueSubstrings{
    public int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<String>());
    }
    
    public int backtrack(int start, String s, HashSet<String> seen){
        if(start == s.length()){
            return 0;
        }
        
        int maxSplit = 0;
        for(int end = start + 1; end <= s.length(); end++){
            String substring = s.substring(start, end);
            if(!seen.contains(substring)){
                seen.add(substring);
                maxSplit = Math.max(maxSplit, 1 + backtrack(end, s, seen));
                seen.remove(substring);
            }
        }
        
        return maxSplit;
    }

    public static void main(String[] args) {
        SplitAStringIntoTheMaxNumberOfUniqueSubstrings obj = new SplitAStringIntoTheMaxNumberOfUniqueSubstrings();
        System.out.println(obj.maxUniqueSplit("ababccc"));
    }
}