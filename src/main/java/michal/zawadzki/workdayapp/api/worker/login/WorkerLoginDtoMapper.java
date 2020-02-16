/*
    Created on 16/02/2020 by uex1421
 */
package michal.zawadzki.workdayapp.api.worker.login;

import michal.zawadzki.workdayapp.model.Worker;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface WorkerLoginDtoMapper {

    WorkerLoginDto fromWorker(Worker worker);

}
