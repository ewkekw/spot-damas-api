package org.ewkekw.spot.damas.api.service;

import org.ewkekw.spot.damas.api.model.Tournament;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ITournamentService {

    List<Tournament> getUpcomingTournaments(Long estadoId, Long cidadeId, int limit);

    List<Tournament> getAllUpcomingTournaments(Long estadoId, Long cidadeId);

    List<Tournament> filterTournaments(Long estadoId, Long cidadeId, LocalDate data);

    Tournament createTournament(Tournament tournament);

    void deleteTournament(Long id);
}
