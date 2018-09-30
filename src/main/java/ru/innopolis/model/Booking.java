package ru.innopolis.model;

import java.util.Objects;

public class Booking {

    private long timestamp; //время старта брони (в секундах)
    private Client client;  //клиент, создавший броню
    private Tour tour;      //тур, который забронировали
    private Long id;        //идентификатор брони

    public Booking() {
    }

    public Booking(long timestamp, Client client, Tour tour) {
        this.timestamp = timestamp;
        this.client = client;
        this.tour = tour;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
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
                Objects.equals(client, booking.client) &&
                Objects.equals(tour, booking.tour) &&
                Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, client, tour, id);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "timestamp=" + timestamp +
                ", client=" + client +
                ", tour=" + tour +
                ", id=" + id +
                '}';
    }
}
