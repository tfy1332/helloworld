package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseHelperImpl;
import com.ipartek.formacion.pojo.Planeta;

public class PlanetDAOImpl implements PlanetDAO {
	
		private static PlanetDAOImpl INSTANCE = null;
		private static DataBaseHelperImpl db;
		private Connection conexion;
	
		private PlanetDAOImpl() {
			db = DataBaseHelperImpl.getInstance();
		}
	
		public static PlanetDAOImpl getInstance() {
			if (INSTANCE == null) {
				createInstance();
			}
			return INSTANCE;
		}
	
		private synchronized static void createInstance() {
			if (INSTANCE == null) {
				INSTANCE = new PlanetDAOImpl();
			}
		}
	
		@Override
		public boolean create(Planeta pojo) {
			boolean resul = false;
			String sql = "{call insertPlaneta(?,?,?)}";
			CallableStatement cst = null;
			try {
				conexion = db.getConexion();
				cst = conexion.prepareCall(sql);
				cst.setString(1,pojo.getNombre());
				cst.setString(2,pojo.getImg());
				//parametro de salida , id nuevo generado
				cst.registerOutParameter(3, Types.NUMERIC);
				
				if(cst.executeUpdate() == 1){
					resul = true;
					pojo.setId(cst.getInt(3));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				db.desconectar();
			}
			return resul;
		}
	
		@Override
		public List<Planeta> getAll() {
			List<Planeta> planetas = null;
			String sql = "{call getAllPlanetas()}";
			try {
				conexion = db.getConexion();
				Planeta p = null;
				CallableStatement cSmt = conexion.prepareCall(sql);
				ResultSet rs = cSmt.executeQuery();
				planetas = new ArrayList<Planeta>();
				while (rs.next()) {
					p = new Planeta();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setImg(rs.getString("imagen"));
					// add en lista
					planetas.add(p);
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.desconectar();
			}
			return planetas;
		}
	
		@Override
		public Planeta getById(int id) {
			String sql = "{call getById()}";
			try {
				conexion = db.getConexion();
				Planeta p = null;
				CallableStatement cSmt = conexion.prepareCall(sql);
				ResultSet rs = cSmt.executeQuery();
				while (rs.next()) {
					rs.getInt("id");
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.desconectar();
			}
			Planeta p = null;
			return  p;
		}
	
		@Override
		public boolean update(Planeta pojo) {
			boolean resul = false;
			String sql = "{call updatePlaneta(?,?,?)}";
			CallableStatement cst = null;
			try {
				conexion = db.getConexion();
				cst = conexion.prepareCall(sql);
				cst.setString(1,pojo.getNombre());
				cst.setString(2,pojo.getImg());
				cst.setInt(3, pojo.getId());
				
				if(cst.executeUpdate() == 1){
					resul = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				db.desconectar();
			}
			return resul;
		}
	
		@Override
		public boolean delete(long id) {
			boolean resul = false;
			String sql = "{call deletePlaneta(?)}";
			CallableStatement cst = null;
			try {
				conexion = db.getConexion();
				cst = conexion.prepareCall(sql);
				cst.setLong(1,id);
				if(cst.executeUpdate() == 1){
					resul = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				db.desconectar();
			}
			return resul;
		}
	
		@Override
		public List<Planeta> search(String criterio) {
			ArrayList<Planeta> resul = new ArrayList<Planeta>();
			Planeta p = null;
			try {
				conexion = db.getConexion();
				CallableStatement cst = conexion.prepareCall("{call buscarPlanetas(?)}");
				cst.setString(1, criterio);
				ResultSet rs = cst.executeQuery();
				while (rs.next()){
					p= new Planeta();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setImg(rs.getString("imagen"));
					resul.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				db.desconectar();
			}
			return resul;
		}
	
	}