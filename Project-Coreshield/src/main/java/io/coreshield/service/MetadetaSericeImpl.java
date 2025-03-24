package io.coreshield.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.coreshield.dto.LocationMetadataDTO;
import io.coreshield.entity.Location;
import io.coreshield.entity.Metadata;
import io.coreshield.repository.LocationRepository;
import io.coreshield.repository.MetadetaRepository;

@Service
public class MetadetaSericeImpl implements MetadetaService {

	@Autowired
	private MetadetaRepository metaRepo;

	@Autowired
	private LocationRepository locationRepo;

	@Override
	public String loadMetadeta(List<Metadata> metadeta) {
		List<Metadata> saveAll = metaRepo.saveAll(metadeta);
		if (saveAll.isEmpty()) {
			return "Metadata failed to save";
		}
		return "Metadata saved with: " + saveAll.toString();
	}

	@Override
	public List<LocationMetadataDTO> mergeData() {
		List<LocationMetadataDTO> mergeData = metaRepo.mergeData();
		if (mergeData != null) {
			return mergeData;
		}
		return Collections.emptyList();
	}

	@Override
	public Double calculateAvgRating(String type) {

		List<Metadata> types = metaRepo.findByType(type);

		Double value = types.stream().mapToDouble(Metadata::getRating).sum() / types.size();
		return Math.round(value * 100.0) / 100.0;
	}

	@Override
	public String locationWithHigestReview() {
		Integer maxReviewId = metaRepo.maxReview();
		Metadata metadata = metaRepo.findByReviews(maxReviewId);
		Optional<Location> loc = locationRepo.findById(metadata.getId());
		if (loc.isPresent()) {
			return loc.get().toString();
		}
		return "Failed to get the Max Reviewed Location";
	}

	@Override
	public List<Location> locationwithIncompleteData() {
		return locationRepo.locWithIncompleteData();

	}

	@Override
	public String loadLocation(List<Location> location) {
	    List<Location> saveAll = locationRepo.saveAll(location);
	    if (!saveAll.isEmpty()) {  // Check if the list is not empty
	        return "Location saved with: " + saveAll.toString();
	    }
	    return "Failed to load location";
	}


	@Override
	public int calculateValidPoint(String type) {
		List<Metadata> count = metaRepo.findByType(type);
		if (!count.isEmpty())
			return count.size();

		return 0;
	}

}
