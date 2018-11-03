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
	public ResponseEntity<Graph> createGraph(@RequestBody String graphName){

		GraphRepo.getInstance().create(graphName);
		return ResponseEntity.ok(GraphRepo.getInstance().get(graphName));
	}
	
	@GetMapping
	public ResponseEntity<?> getGraph(@RequestParam String graphName){
		return ResponseEntity.ok(GraphRepo.getInstance().get(graphName));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllGraphs(){
		return ResponseEntity.ok(GraphRepo.getInstance().getAll());
	}
	
	@PostMapping("/{graphName}/node")
	public ResponseEntity<?> createNode(@PathVariable("graphName")String graphName, @RequestBody Node node){
		int codeResponse = 200;
		
		Graph graph = GraphRepo.getInstance().get(graphName);
		
		if(graph == null){
			codeResponse = 204;
		}else{
			graph.addNode(node);
		}
		return ResponseEntity.status(codeResponse).build();
	}
	
	@GetMapping("/{graphName}/node")
	public ResponseEntity<?> getNodeGraph(@PathVariable()String graphName){
		return ResponseEntity.ok(GraphRepo.getInstance().get(graphName).getNode(01));
	}
	
	@PostMapping("/{graphName}/{firstNode}/{secondNode}")
	public ResponseEntity<Graph> createEdge(@PathVariable("graphName")String graphName,@PathVariable("firstNode")long firstNode, @PathVariable("secondNode") long secondNode, @RequestBody Edge edge){
		Graph graph = GraphRepo.getInstance().get(graphName);
		graph.addEdge(edge);
		return ResponseEntity.ok(graph);
	}
	
	@GetMapping("/{graphName}/edge")
	public ResponseEntity<?> getEdgeGraph(@PathVariable()String graphName){
		return ResponseEntity.ok(GraphRepo.getInstance().get(graphName).getNodes());
	}

}
