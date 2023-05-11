import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple {
    int first, second, third; 
    Tuple(int first, int second, int third) {
        this.first = first; 
        this.second = second;
        this.third = third; 
    }
}
class Solution {
    public int CheapestFLight(int n,int flights[][],int src,int dst,int K) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        pq.offer(new Tuple(src, 0, 0));
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int node = curr.first;
            int cost = curr.second;
            int stops = curr.third;
            
            if(node == dst)
                return cost;
            if(stops > K)
                continue;            
            if(visited[node])
                continue;
            visited[node] = true;
            for(Pair neighbor : graph.get(node)) {
                int neighborNode = neighbor.first;
                int neighborCost = neighbor.second;
                pq.offer(new Tuple(neighborNode, cost + neighborCost, stops + 1));
            }
        }
        return -1;
    }
}

class tuf {

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        Solution obj = new Solution();
        int ans = obj.CheapestFLight(n,flights,src,dst,K);
        
        System.out.print(ans);
        System.out.println();
    }
}