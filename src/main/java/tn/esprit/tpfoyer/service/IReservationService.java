package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
     List<Reservation> retrieveAllReservations();
     Reservation retrieveReservation(Long reservationId);
     Reservation addReservation(Reservation c);
     void removeReservation(Long reservationId);
     Reservation modifyReservation(Reservation reservation);
}
