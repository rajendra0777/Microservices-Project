package io.coreshield.rest;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.coreshield.dto.LocationMetadataDTO;
import io.coreshield.entity.Location;
import io.coreshield.entity.Metadata;
import io.coreshield.service.MetadetaService;

@RestController
public class MetadataController {

	@Autowired
	private MetadetaService service;

	@PostMapping("/save/metadata")
	public ResponseEntity<String> saveMetaData(@RequestBody List<Metadata> metadata) {
		if (metadata == null || metadata.isEmpty()) {
			return new ResponseEntity<>("Failed to save metadata: Empty request body", HttpStatus.BAD_REQUEST);
		}

		String metadeta = service.loadMetadeta(metadata);
		if (metadeta != null) {
			return new ResponseEntity<>("Metadata saved with: " + metadeta, HttpStatus.CREATED);
		}

		return new ResponseEntity<>("Failed to save metadata", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/save/location")
	public ResponseEntity<String> saveLocation(@RequestBody List<Location> location) {
	    if (location == null || location.isEmpty()) {
	        return new ResponseEntity<>("Failed to save metadata: Empty request body", HttpStatus.BAD_REQUEST);
	    }

	    String locationData = service.loadLocation(location);
	    
	    if (locationData != null) {
	        return new ResponseEntity<>("Location saved with: " + locationData, HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>("Failed to save location", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@GetMapping("/rating/{type}")
	public ResponseEntity<String> findAvgRating(@PathVariable("type") String type) {

		Double avgRating = service.calculateAvgRating(type);
		if (avgRating != null) {
			return new ResponseEntity<>("The average rating of " + type + " is: " + avgRating, HttpStatus.OK);
		}

		return new ResponseEntity<>("Failed to get the average of type " + type, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/valid-point/{type}")
	public ResponseEntity<String> findExistingValidPoint(@PathVariable("type") String type) {
		int point = service.calculateValidPoint(type);
		if (point > 0) {
			return new ResponseEntity<>("The available valid points of " + type + " is: " + point, HttpStatus.OK);
		}

		return new ResponseEntity<>("Failed to get the available valid points of type " + type,
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/highest-review")
	public ResponseEntity<String> findLocationWithMostReviews() {
		String response = service.locationWithHigestReview();
		if (response != null) {
			return new ResponseEntity<>("The hoghest reviwed " + response, HttpStatus.OK);

		}
		return new ResponseEntity<>("Failed to load  max reviwed location.", HttpStatus.BAD_REQUEST);

	}

	@GetMapping(value = "/incomplete-location", produces = "application/json")
	public ResponseEntity<List<Location>> test() {
		List<Location> list = service.locationwithIncompleteData();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}

		return ResponseEntity.ok(Collections.emptyList());
	}

	@GetMapping(value = "/merge-data", produces = "application/json")
	public ResponseEntity<List<LocationMetadataDTO>> mergeData() {

		List<LocationMetadataDTO> mergeData = service.mergeData();
		if (mergeData != null) {
			return new ResponseEntity<>(mergeData, HttpStatus.OK);
		}

		return ResponseEntity.ok(Collections.emptyList());

	}

}