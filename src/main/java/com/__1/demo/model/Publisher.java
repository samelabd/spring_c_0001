package com.__1.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long publisherId;

    String publisherName;

    String publisherAdd;

    @OneToOne(mappedBy = "publisher")
    @JoinColumn(name = "id")
    Book book;

    public Publisher(String publisherName, String publisherAdd) {
        this.publisherName = publisherName;
        this.publisherAdd = publisherAdd;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAdd() {
        return publisherAdd;
    }

    public void setPublisherAdd(String publisherAdd) {
        this.publisherAdd = publisherAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(publisherId, publisher.publisherId) &&
                Objects.equals(publisherName, publisher.publisherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, publisherName);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + publisherId +
                ", publisherName='" + publisherName + '\'' +
                ", publisherAdd='" + publisherAdd + '\'' +
                '}';
    }
}
