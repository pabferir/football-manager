package com.pabferir.football_manager.player.application.use_cases;

import com.neovisionaries.i18n.CountryCode;
import com.pabferir.football_manager.player.application.ports.in.PlayerReadService;
import com.pabferir.football_manager.player.application.ports.out.PlayerRepository;
import com.pabferir.football_manager.player.domain.PlayerAggregate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerRead implements PlayerReadService {
    private final PlayerRepository playerRepository;

    @Override
    public List<PlayerAggregate> readAll() {
        log.info("Invoked 'getAll()' method from " + this.getClass().getSimpleName() + "...");
        List<PlayerAggregate> result;
        try {
            result = playerRepository.selectAll()
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
            result = playerRepository.selectById(id)
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
            String countryCode = CountryCode.findByName("(?i).*" + countryName + ".*")
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Could not find country with name " + countryName))
                    .getAlpha2();
            result = playerRepository.selectByCountry(countryCode)
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
