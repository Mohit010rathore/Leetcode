class Solution {
    private static void dfs(int node,ArrayList<ArrayList<Integer>> list,int visited[]){
        visited[node] = 1;
        for(int it:list.get(node)){
            if(visited[it] == 0){
                dfs(it,list,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        
        int V = isConnected[0].length;
        //first we create adjacency list from adjacency matrix given
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0;i<V;i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i =0;i< V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int visited[] = new int[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                count++;
                dfs(i,list,visited);
            }
        }
        return count;
    }
}