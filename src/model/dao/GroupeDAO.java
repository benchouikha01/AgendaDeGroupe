package model.dao;

import java.sql.Connection;

import model.beans.Groupe;

public class GroupeDAO extends DAO<Groupe>{

	public GroupeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public void create(Groupe obj) {
		
	}

	@Override
	public void delete(Groupe obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Groupe obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Groupe find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
