package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.Tournament;
import org.ewkekw.spot.damas.api.repository.TournamentRepository;
import org.ewkekw.spot.damas.api.service.ITournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TournamentService implements ITournamentService {

    @Autowired
    private TournamentRepository tournamentMapper;

    @Override
    public List<Tournament> getUpcomingTournaments(Long estadoId, Long cidadeId, int limit) {
        return tournamentMapper.findUpcomingTournaments(estadoId, cidadeId, limit);
    }

    @Override
    public List<Tournament> getAllUpcomingTournaments(Long estadoId, Long cidadeId) {
        return tournamentMapper.findAllUpcomingTournaments(estadoId, cidadeId);
    }

    @Override
    public List<Tournament> filterTournaments(Long estadoId, Long cidadeId, Date data) {
        return tournamentMapper.filterTournaments(estadoId, cidadeId, data);
    }

    @Override
    public Tournament createTournament(Tournament tournament) {
        tournamentMapper.insertTournament(tournament);
        return tournament;
    }

    @Override
    public void deleteTournament(Long id) {
        tournamentMapper.deleteTournamentById(id);
    }
}
