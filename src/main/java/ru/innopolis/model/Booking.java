package ru.innopolis.model;

import java.util.Objects;

public class Booking {

    private long timestamp; //время старта брони (в секундах)
    private long clientId;  //клиент, создавший броню
    private long tourId;      //тур, который забронировали
    private Long id;        //идентификатор брони

    public Booking() {
    }

    public Booking(long timestamp, long clientId, long tourId) {
        this.timestamp = timestamp;
        this.clientId = clientId;
        this.tourId = tourId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getTourId() {
        return tourId;
    }

    public void setTourId(long tourId) {
        this.tourId = tourId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return timestamp == booking.timestamp &&
                Objects.equals(clientId, booking.clientId) &&
                Objects.equals(tourId, booking.tourId) &&
                Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, clientId, tourId, id);
    }

    @Override
    public String toString() {
        return "Booking{" + "timestamp=" + timestamp +
                ", clientId=" + clientId + ", tourId=" + tourId
                + ", id=" + id + '}';
    }
}
