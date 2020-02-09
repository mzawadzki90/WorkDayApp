/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.cv.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

	@Query(value = "SELECT c FROM Certificate c WHERE c.cv.id IN (:cvIds) ")
	List<Certificate> listByCVIds(Set<Integer> cvIds);

}
