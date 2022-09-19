class Solution {

    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> managerToDirectsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int managerId = manager[i];
            if (!managerToDirectsMap.containsKey(managerId)) managerToDirectsMap.put(managerId, new ArrayList<>());
            managerToDirectsMap.get(managerId).add(i);
        }
        return dfs(headId, managerToDirectsMap, informTime);
    }

    private int dfs(int headId, Map<Integer, List<Integer>> managerToDirectsMap, int[] informTime) {
        if (informTime[headId] == 0) return 0;

        int time = 0;
        for (int directId : managerToDirectsMap.get(headId))
            time = Math.max(time, dfs(directId, managerToDirectsMap, informTime));

        return informTime[headId] + time;
    }
}