package ru.innopolis.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Tour {

    private Long id;                //идентификатор тура
    private double tourPrice;       //цена всего тура
    private double flightPrice;     //цена авиаперелета
    private Date endDate;           //дата окончания тура
    private int participantsCount;  //количество участников в туре
    private TourStatus tourStatus;  //статус тура
    private Manager creator;        //менеджер, создавший тур
    private Date startDate;         //дата начала тура
//    private List<Client> clients;   //клиенты, которые внесли оплату
//    private List<Booking> bookings; //брони тура
//    private List<String> cities;    //список городов, через которые проходит тур

    public Tour() {
    }

    public Tour(double tourPrice, double flightPrice, Date endDate,
                int participantsCount, TourStatus tourStatus, Manager creator,
                Date startDate) {
        this.tourPrice = tourPrice;
        this.flightPrice = flightPrice;
        this.endDate = endDate;
        this.participantsCount = participantsCount;
        this.tourStatus = tourStatus;
        this.creator = creator;
        this.startDate = startDate;
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

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return Double.compare(tour.tourPrice, tourPrice) == 0 &&
                Double.compare(tour.flightPrice, flightPrice) == 0 &&
                participantsCount == tour.participantsCount &&
                Objects.equals(id, tour.id) &&
                Objects.equals(endDate, tour.endDate) &&
                tourStatus == tour.tourStatus &&
                Objects.equals(creator, tour.creator) &&
                Objects.equals(startDate, tour.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tourPrice, flightPrice, endDate, participantsCount, tourStatus, creator, startDate);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", tourPrice=" + tourPrice +
                ", flightPrice=" + flightPrice +
                ", endDate=" + endDate +
                ", participantsCount=" + participantsCount +
                ", tourStatus=" + tourStatus +
                ", creator=" + creator +
                ", startDate=" + startDate +
                '}';
    }
}
