package com.mystique.springdrivercard.repositories;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.models.Picture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class SqlCardApplicationRepository implements CardApplicationRepository {

    private SessionFactory sessionFactory;

    @Override
    public List<CardApplicationForm> getAllCardApplications() {

        List<CardApplicationForm> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from CardApplicationForm").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public CardApplicationForm getCardApplicationsByID(int id) {
        CardApplicationForm result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(CardApplicationForm.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void updateCardApplication(int id, CardApplicationForm cardApplicationForm) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            CardApplicationForm cardFormToChange = session.get(CardApplicationForm.class, id);
            cardFormToChange.setStatus(cardApplicationForm.getStatus());
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public Driver getDriverByID(int id) {
        Driver result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Driver.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void updateDriverDetailsForm(int id, Driver truckDriver) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Driver trakerFormToChange = session.get(Driver.class, id);

            // field names should be changed in Driver, according to DB
            trakerFormToChange.setFirstName(truckDriver.getFirstName());
            trakerFormToChange.setLastName(truckDriver.getLastName());
            trakerFormToChange.setAddress(truckDriver.getAddress());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    @Override
    public void addNewDriverDetails(Driver truckDriver) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(truckDriver);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    @Override
    public Picture getPictureByID(int id) {
        Picture result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Picture.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void addNewPicture(Picture picture) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(picture);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
