/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.equipment.Rent;
import michal.zawadzki.workdayapp.model.equipment.RentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, RentId> {

	@Query(value = "SELECT r FROM Rent r LEFT JOIN FETCH r.id.worker w LEFT JOIN FETCH r.id.equipment e WHERE w.id = :workerId")
	List<Rent> listByWorkerId(int workerId);

}
