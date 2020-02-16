/*
    Created on 16/02/2020 by uex1421
 */
package michal.zawadzki.workdayapp.model.worktime;

import michal.zawadzki.workdayapp.model.Worker;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static org.hibernate.validator.constraints.Length.List;

@Entity
@Table(name = "worker_credentials", indexes = {@Index(columnList = "worker_id", unique = true),
                                               @Index(columnList = "login, password", unique = true)})
public class WorkerCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column(nullable = false)
    @List({
                  @Length(min = 8),
                  @Length(max = 16)
          })
    private String login;

    @Column(nullable = false)
    @List({
                  @Length(min = 8),
                  @Length(max = 16)
          })
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
