package io.coreshield.service;

import java.util.List;

import io.coreshield.dto.LocationMetadataDTO;
import io.coreshield.entity.Location;
import io.coreshield.entity.Metadata;


public interface MetadetaService {

	public String loadMetadeta(List<Metadata> metadeta);

	public String loadLocation(List<Location> location);

	public List<LocationMetadataDTO> mergeData();

	public Double calculateAvgRating(String type);

	public String locationWithHigestReview();

	public List<Location> locationwithIncompleteData();

	public int calculateValidPoint(String type);

}
