package in.parusait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.parusait.entitys.Plane;


public interface PlaneRepo extends JpaRepository<Plane, Integer> {

}
