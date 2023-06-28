package in.parusait.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.parusait.entitys.Plane;
import in.parusait.entitys.PlaneCategory;
import in.parusait.repo.PlaneCategoryRepo;
import in.parusait.repo.PlaneRepo;

@Service
public class PlanServiceImp implements PlaneService {

	@Autowired
	private PlaneRepo planeRepo;
	@Autowired
	private PlaneCategoryRepo categoryRepo;

	@Override
	public Map<Integer, String> getPlaneCategories() {

		List<PlaneCategory> categorice = categoryRepo.findAll();
		Map<Integer, String> mapCategorice = new HashMap<>();
		categorice.forEach(cat -> {
			mapCategorice.put(cat.getPlanecategoryId(), cat.getCategoryName());
		});

		return mapCategorice;
	}

	@Override
	public List<Plane> getAllPlanes() {

		return planeRepo.findAll();
	}

	@Override
	public Plane getPlameByiD(Integer planeId) {
		Optional<Plane> findById = planeRepo.findById(planeId);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlane(Plane plane) {
		planeRepo.save(plane);

		return plane.getPlaneId() != null;
	}

	@Override
	public boolean deleteById(Integer planeId) {
		boolean status = false;
		try {
			planeRepo.deleteById(planeId);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean planechangeStatus(Integer planeId, String status) {
		Optional<Plane> findById = planeRepo.findById(planeId);
		if (findById.isPresent()) {
			Plane plane = findById.get();
			plane.setActiveSw(status);
			planeRepo.save(plane);
			return true;
		}
		return false;
	}

	@Override
	public boolean savePlane(Plane plane) {
		Plane saved = planeRepo.save(plane);
		return saved.getPlaneId() != null;
	}

}
