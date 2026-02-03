package hu.infokristaly.loginserver.repository;

import hu.infokristaly.loginserver.entity.RFIDFailedLog;
import hu.infokristaly.loginserver.entity.RFIDLogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RFIDFailedLogRepository extends JpaRepository<RFIDFailedLog, Long> {
    List<RFIDFailedLog> findAllByOrderByLogDateDesc();
}
