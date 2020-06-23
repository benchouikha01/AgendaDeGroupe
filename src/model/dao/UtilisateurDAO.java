package model.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.beans.Groupe;
import model.beans.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur>{

	public UtilisateurDAO(Connection conn) {
		super(conn);
	}
	@Override
	public void create(Utilisateur obj) {
		PreparedStatement state;
		GroupeDAO groupDao = new GroupeDAO(ConnectionFactory.getInstance());
		try {
			state = ConnectionFactory.getInstance().prepareStatement("INSERT INTO public.utilisateur("
					+"adresse_mail, password, nom, prenom) "
					+"VALUES (?, ?, ?, ?);");
			state.setString(1, obj.getAdresseMail());
			state.setString(2, obj.getPassword());
			state.setString(3, obj.getNom());
			state.setString(4, obj.getPrenom());
			groupDao.create(new Groupe(obj.getNom()));
			state.execute();
			ConnectionFactory.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Utilisateur obj) {
		
		PreparedStatement state;
		try {
			state = ConnectionFactory.getInstance().prepareStatement("DELETE FROM public.utilisateur"  
					+"	WHERE id = ?;");
			state.setInt(1, obj.getId());
			state.execute();
			ConnectionFactory.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Utilisateur obj) {
		
		PreparedStatement state;
		try {
			state = ConnectionFactory.getInstance().prepareStatement("UPDATE public.utilisateur "
					+"SET  adresse_mail=?, password=?, nom=?, prenom=? "
					+"WHERE id = ?;");
			state.setString(1, obj.getAdresseMail());
			state.setString(2, obj.getPassword());
			state.setString(3, obj.getNom());
			state.setString(4, obj.getPrenom());
			state.setInt(5, obj.getId());
			state.execute();
			ConnectionFactory.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public  Utilisateur find(int id) {
		Utilisateur utilisateur = new Utilisateur();
		try {
			ResultSet result = ConnectionFactory.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM public.utilisateur"
					+"	WHERE id = "+id);
			if (result.first())
				utilisateur = new Utilisateur(result.getInt("id"), result.getString("adresse_mail"), result.getString("nom"), result.getString("prenom"), result.getString("password"));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public static Utilisateur findUserByNom(String nom) {
	
		Utilisateur utilisateur = new Utilisateur();
		try {
			ResultSet result = ConnectionFactory.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM public.utilisateur"
					+"	WHERE upper(nom) LIKE "+nom.toUpperCase()+"%");
			if (result.first())
				utilisateur = new Utilisateur(result.getInt("id"), result.getString("adresse_mail"), result.getString("nom"), result.getString("prenom"), result.getString("password"));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public static Utilisateur findUserByPrenom(String prenom) {
		
		Utilisateur utilisateur = new Utilisateur();
		try {
			ResultSet result = ConnectionFactory.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM public.utilisateur"
					+"	WHERE upper(prenom) LIKE " + prenom.toUpperCase()+"%");
			if (result.first())
				utilisateur = new Utilisateur(result.getInt("id"), result.getString("adresse_mail"), result.getString("nom"), result.getString("prenom"), result.getString("password"));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public static Utilisateur findUserByMail(String mail) {
		
		Utilisateur utilisateur = new Utilisateur();
		try {
			ResultSet result = ConnectionFactory.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM public.utilisateur"
					+"	WHERE adresse_mail LIKE '" + mail+"';");
			if (result.first())
				utilisateur = new Utilisateur(result.getInt("id"), result.getString("adresse_mail"), result.getString("nom"), result.getString("prenom"), result.getString("password"));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}


	public static boolean seConnecter(String mail, String password) {
		Utilisateur utilisateur = UtilisateurDAO.findUserByMail(mail);
		if(utilisateur.getAdresseMail().equals(mail)) {
			if (utilisateur.getPassword().equals(password)) {
					return true;
			}
		}
		return false;
	}


	
	
}
