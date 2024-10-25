from typing import List


class RemoveSubfoldersFromTheFileSystem:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        # Sort the folder in lexicographical order so that parent folder comes before their subfolder
        folder.sort()
        
        # Initialize the result list with the first folder
        ans = [folder[0]]
        
        # Iterate through the folder list starting from the 2nd folder / 2nd index
        for i in range(1, len(folder)):
            
            # Get the last added folder and append trailing slash
            last_folder = ans[-1] + "/"
            
            # Check if the current folder is a subfolder of the last folder in the result list
            # If it doesn't start with the last folder, then it is not a subfolder
            if not folder[i].startswith(last_folder):
                ans.append(folder[i])
                
        return ans

def main():
    main_instance = RemoveSubfoldersFromTheFileSystem()
    print(main_instance.removeSubfolders(["/a","/a/b","/c/d","/c/d/e","/c/f"])) # ["/a","/c/d","/c/f"]
    
if __name__ == "__main__":
    main()