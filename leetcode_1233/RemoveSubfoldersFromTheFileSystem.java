package leetcode_1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RemoveSubfoldersFromTheFileSystem{
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folder array in lexicographical order so that parent folder comes before their subfolder
        Arrays.sort(folder);

        // Initialize the result list with the first folder
        List<String> res = new ArrayList<>();
        res.add(folder[0]);

        // Iterate through the folder array starting from the 2nd folder / 2nd index / 2nd element
        for (int i = 1; i < folder.length; i++) {
            // Get the last added folder from the result list and append trailing slash
            String lastFolder = res.get(res.size() - 1) + "/";
            
            // Check if the current folder starts with the last added folder
            // If not, then it is not a subfolder of the last added folder
            if (!folder[i].startsWith(lastFolder)) 
                res.add(folder[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        RemoveSubfoldersFromTheFileSystem obj = new RemoveSubfoldersFromTheFileSystem();
        System.out.println(obj.removeSubfolders(folder));
    }
}