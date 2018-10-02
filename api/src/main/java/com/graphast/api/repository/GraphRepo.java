package com.graphast.api.repository;

import java.util.HashMap;
import java.util.Map;

import org.insightlab.graphast.model.Graph;
import org.springframework.stereotype.Repository;

@Repository
public class GraphRepo {
	
	Map<String, Graph> map = new HashMap<>();

	private static GraphRepo graphRepo;

	private GraphRepo() {

	}

	public static GraphRepo getInstance() {
		if (graphRepo == null) {
			graphRepo = new GraphRepo();
		}

		return graphRepo;
	}

	public void create(String graphName) {
		Graph graph = new Graph();
		map.put(graphName, graph);
	}

	public void update(String graphName, Graph graph) {
		if (map.containsKey(graphName)) {
			map.put(graphName, graph);
		}
	}

	public void delete(String name) {
		map.remove(name);
	}

	public Graph get(String name) {
		return map.get(name);
	}
}
