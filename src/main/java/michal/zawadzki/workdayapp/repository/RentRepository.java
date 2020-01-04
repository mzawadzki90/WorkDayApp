/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import java.util.List;
import michal.zawadzki.workdayapp.model.equipment.Rent;
import michal.zawadzki.workdayapp.model.equipment.RentId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<RentId, Rent> {

	@Query(value = "SELECT r FROM Rent r LEFT JOIN FETCH r.id.worker w LEFT JOIN FETCH r.id.equipment e WHERE w.id = :workerId")
	List<Rent> listByWorkerId(int workerId);

}
