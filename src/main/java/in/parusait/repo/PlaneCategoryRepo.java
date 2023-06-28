package in.parusait.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.parusait.entitys.PlaneCategory;
@Repository
public interface PlaneCategoryRepo extends JpaRepository<PlaneCategory, Integer> {

}
