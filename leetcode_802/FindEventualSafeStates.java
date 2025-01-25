import java.util.ArrayList;
import java.util.List;

class FindEventualSafeStates{
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; // Total number of nodes
        // 0: unvisited, 1: visited, 2: safe
        int [] state = new int[n]; // Array to keep track of the state of each node
        List<Integer> safe = new ArrayList<>();

        for(int i = 0; i < n; i++){
            // Perform DFS on each node and check if it is safe
            if(dfs(graph, state, i)){
                safe.add(i);
            }
        }
        
        return safe;
    }

    private boolean dfs(int[][] graph, int[] state, int node){
        // If the node is already visited, return true if it is safe
        if(state[node] > 0)
            return state[node] == 2; // true if safe, false if not safe
        
        // Mark current exploring node as visited
        state[node] = 1;

        for(int next : graph[node]){
            // If the next node is visited or If any neighbor is in a cycle or leads to a cycle, this node is unsafe
            if(state[next] == 1 || !dfs(graph, state, next)){
                return false; // cycle detected
            }
        }

        state[node] = 2; // Mark the node as safe
        return true;
    }

    public static void main(String[] args) {
        FindEventualSafeStates fess = new FindEventualSafeStates();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> safe = fess.eventualSafeNodes(graph);
        System.out.println(safe);
    }
}