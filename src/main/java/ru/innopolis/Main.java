package ru.innopolis;

import ru.innopolis.dao.BookingDao;
import ru.innopolis.dao.ClientDao;
import ru.innopolis.dao.ManagerDao;
import ru.innopolis.dao.TourDao;
import ru.innopolis.model.*;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        Client client = new Client(
                "name", "secondName1",
                "patronymic", "email17");
        ClientDao clientDao = new ClientDao();
        clientDao.save(client);
//        clientDao.delete(12);

        ManagerDao managerDao = new ManagerDao();
        Manager manager = new Manager("name5", "secondName5",
                "patronymic5", "email17");
        managerDao.save(manager);
//        manager.setName("Arkadi");
//        managerDao.update(manager);
//        managerDao.delete(2);

        Tour tour = new Tour(50.00, 100.00, Date.valueOf("2018-09-30"),
                4, TourStatus.ACTIVE, manager,
                Date.valueOf("2018-09-30"));
        TourDao tourDao = new TourDao();
        tourDao.save(tour);
//        Tour tourFromDB= tourDao.get(tour.getId());
///*        System.out.println(tour.equals(tourFromDB));
//        System.out.println(tour);
//        System.out.println(tourFromDB);*/
//        tour.setFlightPrice(2000.00);
//        tourDao.update(tour);
//        tourDao.delete(tour.getId());

        Booking booking = new Booking(60, client, tour);
        BookingDao bookingDao = new BookingDao();
        bookingDao.save(booking);

        Booking bookingFromDB= bookingDao.get(booking.getId());
/*        System.out.println(bookingFromDB);
        System.out.println(booking.equals(bookingFromDB));*/
        booking.setTimestamp(80);
        bookingDao.update(booking);
        bookingDao.delete(3);
    }
}