class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int neighbour : graph[i]) {
                adj.get(neighbour).add(i); // reverse edge
                indegree[i]++; // indegree in reversed graph
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        List<Integer> safe = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safe.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }

        Collections.sort(safe);
        return safe;
    }
}