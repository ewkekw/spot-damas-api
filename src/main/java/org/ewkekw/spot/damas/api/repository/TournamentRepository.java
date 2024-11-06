package org.ewkekw.spot.damas.api.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ewkekw.spot.damas.api.model.Tournament;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TournamentRepository {

    List<Tournament> findUpcomingTournaments(@Param("estadoId") Long estadoId, @Param("cidadeId") Long cidadeId, @Param("limit") int limit);

    List<Tournament> findAllUpcomingTournaments(@Param("estadoId") Long estadoId, @Param("cidadeId") Long cidadeId);

    List<Tournament> filterTournaments(@Param("estadoId") Long estadoId, @Param("cidadeId") Long cidadeId, @Param("data") LocalDate data);

    void insertTournament(Tournament tournament);

    void deleteTournamentById(Long id);
}
