package io.coreshield.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.coreshield.entity.Location;

public interface LocationRepository extends JpaRepository<Location, String> {

	public Optional<Location> findById(String id);

	@Query(
			value = "SELECT * FROM location WHERE latitude IS NULL OR longitude IS NULL", 
			nativeQuery = true)
	public List<Location> locWithIncompleteData();

}
