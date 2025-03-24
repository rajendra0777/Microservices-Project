package io.coreshield.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Metadata {
	@Id
	private String id;

	private String type;

	private Double rating;

	private Integer reviews;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate created;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updated;

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

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDate updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "MetaData [id=" + id + ", type=" + type + ", rating=" + rating + ", reviews=" + reviews + ", created="
				+ created + ", updated=" + updated + "]";
	}

}
