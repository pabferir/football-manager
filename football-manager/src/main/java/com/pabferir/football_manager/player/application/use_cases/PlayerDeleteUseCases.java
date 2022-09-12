package com.pabferir.football_manager.player.application.use_cases;

import com.pabferir.football_manager.player.application.ports.in.PlayerDeleteService;
import com.pabferir.football_manager.player.application.ports.out.PlayerPersistService;
import com.pabferir.football_manager.player.domain.PlayerAggregate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerDeleteUseCases implements PlayerDeleteService {
    private final PlayerPersistService playerPersistService;

    @Override
    public List<PlayerAggregate> deleteAll() {
        log.info("Invoked 'deleteAll' method from " + this.getClass().getSimpleName() + "...");
        List<PlayerAggregate> result;
        try {
            result = playerPersistService.selectAll()
                    .stream()
                    .toList();
            playerPersistService.deleteAll();
        } catch (Exception ex) {
            log.error("Could not delete Players", ex);
            throw ex;
        }
        log.info("All Players deleted successfully");

        return result;
    }

    @Override
    public PlayerAggregate deleteById(Long id) {
        log.info("Invoked 'deleteById' method from " + this.getClass().getSimpleName() + "...");
        PlayerAggregate result;
        try {
            result = playerPersistService.selectById(id)
                    .orElseThrow(() -> new IllegalStateException(
                            "Couldn't find Player with id [" + id + "] in the Database."));
            playerPersistService.deleteById(id);
        } catch (Exception ex) {
            log.error("Could not delete Player with id [" + id + "]", ex);
            throw ex;
        }
        log.info("Player with id [" + result.getId() + "] deleted successfully");

        return result;
    }
}
