package com.jpa.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Models.Agent;
import Models.Flight;
import Models.Passenger;
import Models.Reservation;
import Util.HibernateUtil;

public class App {

	static Session session = null;
	static Transaction transaction = null;

	public static void main(String[] args) throws SQLException {

		Passenger passenger1 = new Passenger();
		Flight flight1 = new Flight();
		Agent agent1 = new Agent();
		Reservation reservation1 = new Reservation();

		passenger1.setPassenger_id(104);
		passenger1.setFirst_name("Julio");
		passenger1.setLast_name("Bahag");

		flight1.setFlight_no(1001);
		flight1.setCapacity(200);
		flight1.setDate("Oct 11, 2019");
		flight1.setDestination("Manila");
		flight1.setOrigin("Lapu - Lapu");
		flight1.setDeparture_time("10:00 am");
		flight1.setArrival_time("12:00 pm");

		agent1.setAgent_id(1013);
		agent1.setName("Cebu Pacific");

		reservation1.setReservation_code(100);
		reservation1.setFlight_no(flight1);
		reservation1.setPassenger_id(passenger1);
		reservation1.setAgent_id(agent1);
		reservation1.setSeat_no(200);

		save(passenger1, flight1, agent1, reservation1);
		// listAll();
		// listByFlightNo(flight1);
		// findByName("uli");
		// update(reservation1.getReservation_code());
		// Delete(1);

		HibernateUtil.shutdown();
	}

	public static void save(Passenger passenger1, Flight flight1, Agent agent1, Reservation reservation1) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.save(passenger1);
			session.save(flight1);
			session.save(agent1);
			session.save(reservation1);

			transaction.commit();
			System.out.println("Successfuly Save! \n");

		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}

		listAll();
	}

	@SuppressWarnings("unchecked")
	public static void listAll() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			List<Reservation> reservation = session.createQuery("from Reservation").list();
			System.out.println();
			for (Reservation reserve : reservation) {

				Passenger p = reserve.getPassenger_id();
				Agent agent = reserve.getAgent_id();
				Flight flight = reserve.getFlight_no();

				System.out.println("Reservation code : " + reserve.getReservation_code() + ", Flight no: "
						+ flight.getFlight_no() + ", Passenger Name: " + p.getFirst_name() + " " + p.getLast_name()
						+ ", Seat no: " + reserve.getSeat_no() + ", Agent Id: " + agent.getAgent_id() + ", Agent Name: "
						+ agent.getName());
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void listByFlightNo(Flight flight_no) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria object
			CriteriaQuery<Reservation> criteriaQuery = builder.createQuery(Reservation.class);
			Root<Reservation> reserveRoot = criteriaQuery.from(Reservation.class);
			criteriaQuery.select(reserveRoot);
			criteriaQuery.where(builder.equal(reserveRoot.get("flight_no"), flight_no));

			// Get a list of Contact objects according to the Criteria object
			List<Reservation> list = session.createQuery(criteriaQuery).getResultList();

			System.out.println();
			if (!list.isEmpty()) {
				for (Reservation objects : list) {
					Reservation reserve = (Reservation) objects;

					Passenger p = reserve.getPassenger_id();
					Agent agent = reserve.getAgent_id();
					Flight flight = reserve.getFlight_no();

					System.out.println("Reservation code : " + reserve.getReservation_code() + ", Flight no: "
							+ flight.getFlight_no() + ", Passenger Name: " + p.getFirst_name() + " " + p.getLast_name()
							+ ", Seat no: " + reserve.getSeat_no() + ", Agent Id: " + agent.getAgent_id()
							+ ", Agent Name: " + agent.getName());
				}
			} else
				System.out.println("\nNo records found");

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private static void findByName(String name) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria object
			CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
			Root<Reservation> reserveRoot = criteriaQuery.from(Reservation.class);
			Root<Passenger> passRoot = criteriaQuery.from(Passenger.class);
			criteriaQuery.multiselect(reserveRoot, passRoot);
			criteriaQuery
					.where(builder.and(builder.equal(reserveRoot.get("passenger_id"), passRoot.get("passenger_id")),
							builder.or(builder.like(passRoot.<String>get("first_name"), "%" + name + "%"),
									builder.equal(passRoot.<String>get("last_name"), "%" + name + "%"))));

			// Get a list of Contact objects according to the Criteria object
			List<Object[]> list = session.createQuery(criteriaQuery).getResultList();

			System.out.println();
			if (!list.isEmpty()) {
				for (Object[] objects : list) {
					Reservation reserve = (Reservation) objects[0];

					Passenger p = reserve.getPassenger_id();
					Agent agent = reserve.getAgent_id();
					Flight flight = reserve.getFlight_no();

					System.out.println("Reservation code : " + reserve.getReservation_code() + ", Flight no: "
							+ flight.getFlight_no() + ", Passenger Name: " + p.getFirst_name() + " " + p.getLast_name()
							+ ", Seat no: " + reserve.getSeat_no() + ", Agent Id: " + agent.getAgent_id()
							+ ", Agent Name: " + agent.getName());
				}
			} else
				System.out.println("\nNo records found");

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void Delete(int reservation_code) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();

			// Delete a persistent object
			Reservation Reservation1 = session.get(Reservation.class, reservation_code);
			if (Reservation1 != null) {
				session.delete(Reservation1);
				System.out.println("\nSuccesfuly is deleted");
			} else
				System.out.println("\nNo records to deleted");

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void update(int reservation_code) {
		Agent agent = new Agent();
		agent.setAgent_id(1013);
		agent.setName("Cebu Pacific");

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();

			// Delete a persistent object
			Reservation Reservation1 = session.load(Reservation.class, reservation_code);
			if (Reservation1 != null) {
				Reservation1.setAgent_id(agent);
				session.update(Reservation1);

				System.out.println("Succesfuly Updated! \n");
			} else
				System.out.println("\nNo records to Updated! \n");

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
