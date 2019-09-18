package com.__1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((publisherAddress == null) ? 0 : publisherAddress.hashCode());
		result = prime * result + ((publisherName == null) ? 0 : publisherName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (publisherAddress == null) {
			if (other.publisherAddress != null)
				return false;
		} else if (!publisherAddress.equals(other.publisherAddress))
			return false;
		if (publisherName == null) {
			if (other.publisherName != null)
				return false;
		} else if (!publisherName.equals(other.publisherName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", publisherName=" + publisherName + "]";
	}

	public Publisher(String publisherName, String publisherAddress) {
		super();
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
	}

}
