package com.ocr.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ocr.beans.BeanException;
import com.ocr.beans.User;
import com.ocr.dao.factory.DaoFactory;

public class UserDaoImpl implements UserDao  {

	    private DaoFactory daoFactory;

	    public UserDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	    }

	    @Override
	    public void add(User utilisateur) throws DaoException {
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
	            preparedStatement.setString(1, utilisateur.getName());
	            preparedStatement.setString(2, utilisateur.getFirstname());

	            preparedStatement.executeUpdate();
	            connexion.commit();
	        } catch (SQLException e) {
	            try {
	            	
	            	// in case of problem we cancel the transaction :
	                if (connexion != null) {
	                    connexion.rollback();
	                }
	            } catch (SQLException e2) {
	            }
	            throw new DaoException("Impossible de communiquer avec la base de donn�es");
	        }
	        finally {
	            try {
	                if (connexion != null) {
	                    connexion.close();  
	                }
	            } catch (SQLException e) {
	                throw new DaoException("Impossible de communiquer avec la base de donn�es");
	            }
	        }

	    }


	    @Override
	    public List<User> list() throws DaoException {
	        List<User> utilisateurs = new ArrayList<User>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");

	            while (resultat.next()) {
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");

	                User utilisateur = new User();
	                utilisateur.setName(nom);
	                utilisateur.setFirstname(prenom);

	                utilisateurs.add(utilisateur);
	            }
	        } catch (SQLException e) {
	            throw new DaoException("Impossible de communiquer avec la base de donn�es");
	        } catch (BeanException e) {
	            throw new DaoException("Les donn�es de la base sont invalides");
	        }
	        finally {
	            try {
	                if (connexion != null) {
	                    connexion.close();  
	                }
	            } catch (SQLException e) {
	                throw new DaoException("Impossible de communiquer avec la base de donn�es");
	            }
	        }
	        return utilisateurs;
	    }

	}