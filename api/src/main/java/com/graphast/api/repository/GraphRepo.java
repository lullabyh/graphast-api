package com.graphast.api.repository;

import java.util.HashMap;
import java.util.Map;

import org.insightlab.graphast.model.Graph;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("singleton")
public class GraphRepo {
	
	private Map<String, Graph> map = new HashMap<>();

	public Map<String, Graph> getMap() {
		return map;
	}
	
	public void setMap(Map<String, Graph> map) {
		this.map = map;
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
	
	public Map<String, Graph> getAll(){
		return map;
	}

	public void delete(String name) {
		map.remove(name);
	}	
}
