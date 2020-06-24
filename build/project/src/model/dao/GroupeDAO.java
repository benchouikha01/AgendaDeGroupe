package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.beans.Groupe;
import model.beans.Utilisateur;

public class GroupeDAO extends DAO<Groupe>{

	public GroupeDAO(Connection conn) {
		super(conn);
	}

	public void create(Groupe obj) {

		PreparedStatement state;
		try {
			state = this.connect.prepareStatement("INSERT INTO public.groupe(nom)"
					+" VALUES (?);");
			state.setString(1, obj.getNom());
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Groupe obj) {
		PreparedStatement state;
		try {
			state = ConnectionFactory.getInstance().prepareStatement("DELETE FROM public.groupe"  
					+"	WHERE id = ?;");
			state.setInt(1, obj.getId());
			state.execute();
			ConnectionFactory.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Groupe obj) {
		PreparedStatement state;
		try {
			state = ConnectionFactory.getInstance().prepareStatement("UPDATE public.groupe "
					+"SET  nom=?"
					+"WHERE id = ?;");
			state.setString(1, obj.getNom());
			state.setInt(5, obj.getId());
			state.execute();
			ConnectionFactory.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Groupe find(int id) {
		Groupe groupe = new Groupe();
		try {
			ResultSet result = ConnectionFactory.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM public.groupe"
					+"	WHERE id = "+id);
			if (result.first())
				groupe = new Groupe(result.getInt("id"), result.getString("nom"));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return groupe;
	}
	
	
	public Groupe findGroupByNom(String nom) {
		Groupe groupe = new Groupe();
		try {
			ResultSet result = ConnectionFactory.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM public.groupe"
					+"	WHERE nom = '"+nom+"';");
			if (result.first())
				groupe = new Groupe(result.getInt("id"), result.getString("nom"));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return groupe;
	}
		
	

	
}
