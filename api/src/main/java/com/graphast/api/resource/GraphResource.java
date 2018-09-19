package com.graphast.api.resource;

import org.insightlab.graphast.model.Graph;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
