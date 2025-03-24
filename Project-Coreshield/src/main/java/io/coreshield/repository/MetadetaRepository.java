package io.coreshield.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.coreshield.dto.LocationMetadataDTO;
import io.coreshield.entity.Metadata;

@Repository
public interface MetadetaRepository extends JpaRepository<Metadata, String> {

	public List<Metadata> findByType(String type);

	@Query(value = "SELECT MAX(reviews) FROM metadata", nativeQuery = true)
	public Integer maxReview();

	@Query(value = "SELECT COALESCE(m.id, l.id) AS id, m.type, m.rating, m.reviews, l.latitude,  l.longitude FROM metadata m LEFT JOIN location l ON m.id = l.id", nativeQuery = true)
	public List<LocationMetadataDTO> mergeData();

	public Metadata findByReviews(Integer rewiew);

}
