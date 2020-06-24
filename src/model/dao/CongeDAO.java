package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.beans.Conge;
import model.beans.Groupe;

public class CongeDAO extends DAO<Conge> {

	public CongeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public void create(Conge obj) {
		PreparedStatement state;
		try {
			state = this.connect.prepareStatement("INSERT INTO public.conge(\r\n" + 
					" motif_demande, demandeur_id, date_debut, reponse, date_fin, repondeur_id)\r\n" + 
					" VALUES ( ?, ?, ?, ?, ?, ?, ?);");
			/*state.setString(1, obj.getMotifDemande()());
			state.setString(2, obj.getDemandeurId());
			state.setDate(3, obj.getDateDebut().);
			state.setBoolean(4, obj.getReponse());*/
			
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(Conge obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Conge obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conge find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
