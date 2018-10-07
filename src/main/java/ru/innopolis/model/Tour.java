package ru.innopolis.model;

import java.sql.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Tour {

    private Long id;                //идентификатор тура
    private double tourPrice;       //цена всего тура
    private double flightPrice;     //цена авиаперелета
    private Date startDate;         //дата начала тура
    private Date endDate;           //дата окончания тура
    private int maxParticipants;  //количество участников в туре
    private TourStatus tourStatus;  //статус тура
    private Manager creator;        //менеджер, создавший тур
    private String description;     //описание тура
//    private List<Client> clients;   //клиенты, которые внесли оплату
//    private List<Booking> bookings; //брони тура
//    private List<String> cities;    //список городов, через которые проходит тур

    public Tour() {
    }

    public Tour(double tourPrice, double flightPrice, Date startDate, Date endDate, int maxParticipants, TourStatus tourStatus,
                Manager creator, String description) {
        this.tourPrice = tourPrice;
        this.flightPrice = flightPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxParticipants = maxParticipants;
        this.tourStatus = tourStatus;
        this.creator = creator;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Manager getCreator() {
        return creator;
    }

    public void setCreator(Manager creator) {
        this.creator = creator;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return Double.compare(tour.tourPrice, tourPrice) == 0 &&
                Double.compare(tour.flightPrice, flightPrice) == 0 &&
                maxParticipants == tour.maxParticipants &&
                Objects.equals(id, tour.id) &&
                Objects.equals(endDate, tour.endDate) &&
                tourStatus == tour.tourStatus &&
                Objects.equals(creator, tour.creator) &&
                Objects.equals(startDate, tour.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tourPrice, flightPrice, endDate, maxParticipants, tourStatus, creator, startDate);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", tourPrice=" + tourPrice +
                ", flightPrice=" + flightPrice +
                ", endDate=" + endDate +
                ", maxParticipants=" + maxParticipants +
                ", tourStatus=" + tourStatus +
                ", creator=" + creator +
                ", startDate=" + startDate +
                '}';
    }

    public long getDuration() {
        //разница в миллисекундах
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
