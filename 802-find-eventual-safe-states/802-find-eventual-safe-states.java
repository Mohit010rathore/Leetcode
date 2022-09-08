class Solution {
    public boolean dfs(int node,int vis[],int pathVis[],List<List<Integer>> adj,int check[]){
        
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it,vis,pathVis,adj,check)){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        
        check[node] = 1;
        pathVis [node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];
        
        //converting into adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, vis, pathVis, adj,check);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(check[i] == 1)
                ans.add(i);
        }
        
        return ans;
        
    }
}