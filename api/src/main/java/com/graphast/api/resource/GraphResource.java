package com.graphast.api.resource;

import org.insightlab.graphast.model.Graph;
import org.insightlab.graphast.model.Node;
import org.insightlab.graphast.model.components.spatial_components.Point;
import org.insightlab.graphast.model.components.spatial_components.SpatialNodeComponent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graph-generator")
public class GraphResource {
	
	@PostMapping
	public Node createGrah(@RequestBody Point point){
		Graph graph = new Graph();

		SpatialNodeComponent snc = new SpatialNodeComponent(point);
		Node n1 = new Node(01);
		n1.addComponent(snc);
		
		graph.addNode(n1);
		return n1;
	}

}
