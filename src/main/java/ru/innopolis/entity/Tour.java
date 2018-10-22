package ru.innopolis.entity;

import ru.innopolis.entity.user.Client;
import ru.innopolis.entity.user.Manager;
import ru.innopolis.enums.TourStatus;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;                //идентификатор тура

    private double tourPrice;       //цена всего тура

    private double flightPrice;     //цена авиаперелета

    private Date startDate;         //дата начала тура

    private Date endDate;           //дата окончания тура

    private int maxParticipants;    //количество участников в туре

    private TourStatus tourStatus;  //статус тура

    @OneToOne
    private Manager manager;        //менеджер, создавший тур

    private String description;     //описание тура

    @OneToMany
    private List<Client> clients;   //клиенты, которые внесли оплату

    @OneToMany
    private List<Booking> bookings; //брони тура

    @ElementCollection
    private List<String> cities;    //список городов, через которые проходит тур

    @ManyToMany
    private List<Tag> tags;         // список тегов, связанных с данным туром

    public Tour() {
    }

    public Tour(double tourPrice, double flightPrice, Date startDate, Date endDate, int maxParticipants, TourStatus tourStatus, Manager manager, String description, List<Client> clients, List<Booking> bookings, List<String> cities, List<Tag> tags) {
        this.tourPrice = tourPrice;
        this.flightPrice = flightPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxParticipants = maxParticipants;
        this.tourStatus = tourStatus;
        this.manager = manager;
        this.description = description;
        this.clients = clients;
        this.bookings = bookings;
        this.cities = cities;
        this.tags = tags;
    }

    public long getDuration() {
        //разница в миллисекундах
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public Long getId() {
        return id;
    }

    public Tour setId(Long id) {
        this.id = id;
        return this;
    }

    public double getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(double tourPrice) {
        this.tourPrice = tourPrice;
    }

    public double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public TourStatus getTourStatus() {
        return tourStatus;
    }

    public void setTourStatus(TourStatus tourStatus) {
        this.tourStatus = tourStatus;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}
