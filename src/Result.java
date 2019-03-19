
import java.util.*;

class Result {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owners = new HashMap<>();
        Map<String, HashSet<String>> graph = new HashMap<>();

        for (List<String> acc : accounts) {
            for (int i = 1; i < acc.size(); i++) {
                owners.put(acc.get(i), acc.get(0));
                if (graph.containsKey(acc.get(i))) {
                    graph.put(acc.get(i), new HashSet<String>());
                }

                if (i == 1)
                    continue;

                graph.get(acc.get(i)).add(acc.get(i - 1));
                graph.get(acc.get(i - 1)).add(acc.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String node : owners.keySet()) {
            if (!visited.contains(node)) {
                List<String> list = new ArrayList<>();
                dfs(graph, visited, list, node);
                Collections.sort(list);
                list.add(0, owners.get(node));
                result.add(list);
            }
        }
        return result;
    }


    public void dfs(Map<String, HashSet<String>> graph, Set<String> visited, List<String> list, String email) {
        list.add(email);
        visited.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, visited, list, next);
            }
        }
    }

}