package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.Tournament;
import org.ewkekw.spot.damas.api.repository.TournamentRepository;
import org.ewkekw.spot.damas.api.service.ITournamentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TournamentService implements ITournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public List<Tournament> getUpcomingTournaments(Long estadoId, Long cidadeId, int limit) {
        return tournamentRepository.findUpcomingTournaments(estadoId, cidadeId, limit);
    }

    @Override
    public List<Tournament> getAllUpcomingTournaments(Long estadoId, Long cidadeId) {
        return tournamentRepository.findAllUpcomingTournaments(estadoId, cidadeId);
    }

    @Override
    public List<Tournament> filterTournaments(Long estadoId, Long cidadeId, LocalDate data) {
        return tournamentRepository.filterTournaments(estadoId, cidadeId, data);
    }

    @Override
    public Tournament createTournament(Tournament tournament) {
        tournamentRepository.insertTournament(tournament);
        return tournament;
    }

    @Override
    public void deleteTournament(Long id) {
        tournamentRepository.deleteTournamentById(id);
    }
}
