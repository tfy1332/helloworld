package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.dao.PlanetDAO;
import com.ipartek.formacion.model.dao.PlanetDAOImpl;
import com.ipartek.formacion.pojo.Planeta;

public class ServicePlanetImplDB implements ServicePlanet {
	
	private static ServicePlanetImplDB INSTANCE = null;
	private PlanetDAO daoPLaneta;
	
	private ServicePlanetImplDB() {
				daoPLaneta = PlanetDAOImpl.getInstance();
			}
		
			public static ServicePlanetImplDB getInstance() {
				if (INSTANCE == null) {
					createInstance();
				}
				return INSTANCE;
			}
		
			private synchronized static void createInstance() {
				if (INSTANCE == null) {
					INSTANCE = new ServicePlanetImplDB();
				}
			}
		
			@Override
			public List<Planeta> getAll() {		
				return daoPLaneta.getAll();
			}
		
			@Override
			public Planeta getById(int id) {
				// TODO Auto-generated method stub
				return null;
			}
		
			@Override
			public boolean delete(long id) {
				// TODO Auto-generated method stub
				return false;
			}
		
			@Override
			public Planeta save(Planeta p) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		
			@Override
			public List<Planeta> search(String criterio) {
				
				return daoPLaneta.search(criterio);
			}
		
		}