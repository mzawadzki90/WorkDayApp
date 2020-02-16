/*
    Created on 16/02/2020 by uex1421
 */
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.worktime.WorkerCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerCredentialsRepository extends JpaRepository<WorkerCredentials, Integer> {

    @Query("SELECT wc FROM WorkerCredentials wc LEFT JOIN FETCH wc.worker w WHERE wc.login = :login AND wc.password = :password")
    Optional<WorkerCredentials> getByLoginAndPasswordWithWorker(String login, String password);

}
