package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Yue_
 * @create 2021-02-15-11:14
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();
        //graph.dfs(graph.isVisited, 0);
        System.out.println();
        graph.bfs(graph.isVisited, 0);
    }

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public Graph(int n) {
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
        numOfEdges = 0;
    }

    public int findAdjacencyNode(int index) {
        for (int i = index; i < getNumOfVertex(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public int findAdjacencyNode(int v1, int v2) {
        for (int i = v2 + 1; i < getNumOfVertex(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited, int index) {
        System.out.println(getValueByIndex(index));
        isVisited[index] = true;
        int adjacencyNodeIndex = findAdjacencyNode(index);
        while (adjacencyNodeIndex != -1) {
            boolean adjacencyIsVisited = isVisited[adjacencyNodeIndex];
            if (!adjacencyIsVisited) {
                dfs(isVisited, adjacencyNodeIndex);
            }
            adjacencyNodeIndex = findAdjacencyNode(index, adjacencyNodeIndex);
        }
    }

    // 对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u; // 表示队列的头结点对应下标
        int w; // 邻接结点w
        // 队列，记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // 访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "=>");
        // 标记为已访问
        isVisited[i] = true;
        // 将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {// 体现出我们的广度优先
            // 取出队列的头结点下标
            u = queue.removeFirst();
            // 得到第一个邻接结点的下标 w
            w = findAdjacencyNode(u);
            while (w != -1) {// 找到
                // 是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    // 标记已经访问
                    isVisited[w] = true;
                    // 入队
                    queue.addLast(w);
                }
                // 以u为前驱点，找w后面的下一个邻结点
                w = findAdjacencyNode(u, w);
            }
        }
    }

    public void showGraph() {
        for (int i = 0; i < edges.length; i++) {
            System.out.println(Arrays.toString(edges[i]));
        }
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        //无向图
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
