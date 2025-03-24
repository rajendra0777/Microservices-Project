package io.coreshield.dto;

public class LocationMetadataDTO {

	private String id;
	private String type;
	private Double rating;
	private Integer reviews;
	private Double latitude;
	private Double longitude;

	public LocationMetadataDTO(String id, String type, Double rating, Integer reviews, Double latitude,
			Double longitude) {

		this.id = id;
		this.type = type;
		this.rating = rating;
		this.reviews = reviews;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getReviews() {
		return reviews;
	}

	public void setReviews(Integer reviews) {
		this.reviews = reviews;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "LocationMetadataDTO [id=" + id + ", type=" + type + ", rating=" + rating + ", reviews=" + reviews
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
