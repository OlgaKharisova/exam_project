package ru.innopolis.entity;

import ru.innopolis.entity.user.Client;

import javax.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;        //идентификатор брони

    private long timestamp; //время старта брони (в секундах)

    @ManyToOne
    private Client client;  //клиент, создавший броню

    @ManyToOne
    private Tour tour;      //тур, который забронировали

    public Booking() {
    }

    public Booking(long timestamp, Client client, Tour tour) {
        this.timestamp = timestamp;
        this.client = client;
        this.tour = tour;
    }


    public long getId() {
        return id;
    }

    public Booking setId(long id) {
        this.id = id;
        return this;
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
}
