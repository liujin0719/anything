/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BreadthFirstSearch
 *
 * @author liujin
 * @date 2022/3/6 14:21
 */
public class BreadthFirstSearch {
	public static void main(String[] args) {

		Graph graph = new Graph(8);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);

		graph.bfs(0,6);

	}

	/**
	 * 无向图
	 */
	public static class Graph {
		/**
		 * 顶点个数
		 */
		private int v;

		private LinkedList<Integer>[] adj;

		public Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList();
			}
		}

		public void addEdge(int s, int t) {
			adj[s].add(t);
			adj[t].add(s);
		}

		public void bfs(int s, int t) {
			if (s == t) {
				return;
			}
			boolean[] visited = new boolean[v];
			visited[s] = true;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(s);
			int[] pre = new int[v];
			for (int i = 0; i < v; i++) {
				pre[i] = -1;
			}
			while (queue.size() != 0) {

				Integer next = queue.poll();
				for (int i = 0; i < adj[next].size(); i++) {
					int q = adj[next].get(i);
					if (!visited[q]) {
						pre[q] = next;
						if (q == t) {
							print(pre, s, t);
							return;
						}
						visited[q] = true;
						queue.add(q);
					}
				}
			}
		}

		public void print(int[] pre, int s, int t) {
			if (pre[t] != -1 && t != s) {
				print(pre, s, pre[t]);
			}
			System.out.println(t + " ");
		}

	}

}