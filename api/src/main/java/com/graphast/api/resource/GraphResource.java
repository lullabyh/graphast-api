package com.graphast.api.resource;

import org.insightlab.graphast.model.Edge;
import org.insightlab.graphast.model.Graph;
import org.insightlab.graphast.model.Node;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graphast.api.repository.GraphRepo;

@RestController
@RequestMapping("/graph-generator")
public class GraphResource {
	
	@PostMapping
	public Graph createGraph(@RequestBody String graphName){
		
		GraphRepo.getInstance().create(graphName);

		return GraphRepo.getInstance().get(graphName);

	}
	
	@GetMapping
	public Graph getGraph(@RequestParam String graphName){
		return GraphRepo.getInstance().get(graphName);
	}
	
	@PostMapping("/{graphName}/node")
	public ResponseEntity<Graph> createNode(@PathVariable("graphName")String graphName, @RequestBody Node node){
		Graph graph = GraphRepo.getInstance().get(graphName);
		if(graph != null){
			graph.addNode(node);
		}
		return ResponseEntity.ok(graph);
	}
	
	@PostMapping("/{graphName}/{firstNode}/{secondNode}")
	public ResponseEntity<Graph> createEdge(@PathVariable("graphName")String graphName,@PathVariable("firstNode")long firstNode, @PathVariable("secondNode") long secondNode, @RequestBody Edge edge){
		Graph graph = GraphRepo.getInstance().get(graphName);
		graph.addEdge(edge);
		return ResponseEntity.ok(graph);
	}

}
