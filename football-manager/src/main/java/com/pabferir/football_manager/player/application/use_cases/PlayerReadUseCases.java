package com.pabferir.football_manager.player.application.use_cases;

import com.pabferir.football_manager.player.application.ports.in.PlayerReadService;
import com.pabferir.football_manager.player.application.ports.out.PlayerPersistService;
import com.pabferir.football_manager.player.domain.PlayerAggregate;
import com.pabferir.football_manager.player.domain.PlayerAggregateBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerReadUseCases implements PlayerReadService {
    private final PlayerPersistService playerPersistService;

    @Override
    public List<PlayerAggregate> readAll() {
        log.info("Invoked 'getAll()' method from " + this.getClass().getSimpleName() + "...");
        List<PlayerAggregate> result;
        try {
            result = playerPersistService.selectAll()
                    .stream()
                    .toList();
        } catch (Exception ex) {
            log.error("Could not retrieve Players", ex);
            throw ex;
        }
        log.info("All Players retrieved successfully");

        return result;
    }

    @Override
    public PlayerAggregate readById(Long id) {
        log.info("Invoked 'getById(" + id + ")' method from " + this.getClass().getSimpleName() + "...");
        PlayerAggregate result;
        try {
            result = playerPersistService.selectById(id)
                    .orElseThrow(() -> new IllegalStateException(
                            "Could not find result with id [" + id + "] in the Database."));
        } catch (Exception ex) {
            log.error("Could not retrieve Player with id [" + id +"]", ex);
            throw ex;
        }
        log.info("Player with id [" + result.getId() + "] retrieved successfully");

        return result;
    }

    @Override
    public List<PlayerAggregate> readByCountry(String countryName) {
        log.info("Invoked 'getByCountry(" + countryName + ")' method from " + this.getClass().getSimpleName() + "...");
        List<PlayerAggregate> result;
        try {
            String countryCode = new PlayerAggregateBuilder()
                    .withCountryName(countryName)
                    .build()
                    .getCountryAlpha2Code();
            result = playerPersistService.selectByCountry(countryCode)
                    .stream()
                    .toList();
        } catch (Exception ex) {
            log.error("Could not get Players by country " + countryName, ex);
            throw ex;
        }
        log.info("All Player from country " + countryName + " retrieved successfully");

        return result;
    }
}
