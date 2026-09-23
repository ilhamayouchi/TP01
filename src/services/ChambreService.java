/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IDao;
import entities.Chambre;
import entities.Chambre.EtatChambre;
import entities.Hotel;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class ChambreService  implements IDao<Chambre> {

   
 
    @Override
    public boolean create(Chambre o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean delete(Chambre o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean update(Chambre o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public Chambre findById(long id) {
        Session session = null;
        Transaction tx = null;
        Chambre s = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            s = (Chambre) session.get(Chambre.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return s;
    }

    @Override
    public List<Chambre> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Chambre> chambres = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            chambres = session.createQuery("from Chambre").list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return chambres;
    } 
    
    // Afficher les chambres par  hôtel
public List<Chambre> findByHotel(Hotel hotel) {

    Session session = null;
    Transaction tx = null;
    List<Chambre> chambres = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        chambres = session.createQuery(
                "from Chambre c where c.hotel = :hotel"
        )
        .setParameter("hotel", hotel)
        .list();

        tx.commit();

    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
    } finally {
        if (session != null) {
            session.close();
        }
    }

    return chambres;
}

// Chercher les chambres par le prix
public List<Chambre> findByPrix(float prix) {

    Session session = null;
    Transaction tx = null;
    List<Chambre> chambres = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        chambres = session.createQuery(
                "from Chambre c where c.prix = :prix"
        )
        .setParameter("prix", prix)
        .list();

        tx.commit();

    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
    } finally {
        if (session != null) {
            session.close();
        }
    }

    return chambres;
}

// Chercher les chambres par l'état
public List<Chambre> findByEtat(EtatChambre etat) {

    Session session = null;
    Transaction tx = null;
    List<Chambre> chambres = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        chambres = session.createQuery(
                "from Chambre c where c.etat = :etat"
        )
        .setParameter("etat", etat)
        .list();

        tx.commit();

    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
    } finally {
        if (session != null) {
            session.close();
        }
    }

    return chambres;
}
}

    
   
