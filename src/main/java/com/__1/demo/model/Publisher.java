package com.__1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String publisherName;

	String publisherAddress;

	public Publisher() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Publisher publisher = (Publisher) o;
		return Objects.equals(getId(), publisher.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Publisher{" +
				"id=" + id +
				", publisherName='" + publisherName + '\'' +
				", publisherAddress='" + publisherAddress + '\'' +
				'}';
	}

	public Publisher(String publisherName, String publisherAddress) {
		super();
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
	}

}
