package in.parusait.service;

import java.util.List;
import java.util.Map;

import in.parusait.entitys.Plane;

public interface PlaneService {
	
	public Map<Integer, String> getPlaneCategories();
	
	public boolean savePlane(Plane plane);
	
	public List<Plane> getAllPlanes();
	
	public Plane getPlameByiD(Integer planeId);
	
	public boolean updatePlane(Plane plane);
	
	public boolean deleteById(Integer planeId);
	
	public boolean planechangeStatus(Integer planeId, String status);

}
