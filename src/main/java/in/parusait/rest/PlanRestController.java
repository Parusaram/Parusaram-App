package in.parusait.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.parusait.entitys.Plane;
import in.parusait.entitys.PlaneCategory;
import in.parusait.service.PlaneService;

@RestController
public class PlanRestController {
	@Autowired
	private PlaneService planService;
	@GetMapping("/categorices")
	public ResponseEntity<Map<Integer, String>> getAllPlanCategorices(){
		Map<Integer, String> planeCategories = planService.getPlaneCategories();
		return new ResponseEntity<Map<Integer,String>>(planeCategories,HttpStatus.OK);
	}
	 
	@PostMapping("savePlan")
	public ResponseEntity<String> savePlan(Plane plane){
		
		String msg="";
		
		boolean savePlane = planService.savePlane(plane);
		if(savePlane) {
			msg="Plan saved";
		}else {
			msg ="Not Saved";
		}
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	@GetMapping("/getAllPlans")
	public ResponseEntity<List<Plane>> getAllPlans(){
		List<Plane> allPlanes = planService.getAllPlanes();
		return new ResponseEntity<List<Plane>>(allPlanes,HttpStatus.OK);
	}
	@GetMapping("/plan/{planeId}")
	public ResponseEntity<Plane> editPlan(@PathVariable Integer planeId){
		
		Plane planByiD = planService.getPlameByiD(planeId);
		return new ResponseEntity<Plane>(planByiD,HttpStatus.OK);
		
	}
	
	public ResponseEntity<String> deletePlan(@PathVariable Integer planeId){
		String msg ="";
		boolean isdeleteById = planService.deleteById(planeId);
		if(isdeleteById) {
			msg="Deleted";
		}else {
			msg="Not Deleted";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/updatePlan")
	public ResponseEntity<String> updatePlane(Plane plane){
		
		String msg ="";
		boolean isupdatePlane = planService.updatePlane(plane);
		if(isupdatePlane) {
			msg ="Plan Uptated";
		}else {
			msg="Not Updated";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/statusChange/{planeId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer palaneId , @PathVariable String status){
		String msg ="";
		boolean isplanechangeStatus = planService.planechangeStatus(palaneId, status);
		if(isplanechangeStatus) {
			msg="Status Change";
		}else {
			msg="Not Changed Status";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
