package org.ewkekw.spot.damas.api.controller;

import org.ewkekw.spot.damas.api.model.Tournament;
import org.ewkekw.spot.damas.api.service.ITournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/torneios")
public class TournamentController {

    @Autowired
    private ITournamentService tournamentService;

    @GetMapping("/proximos")
    public List<Tournament> getUpcomingTournaments(@RequestParam("estado_id") Long estadoId, @RequestParam("cidade_id") Long cidadeId) {
        return tournamentService.getUpcomingTournaments(estadoId, cidadeId, 4);
    }

    @GetMapping("/todos")
    public List<Tournament> getAllUpcomingTournaments(@RequestParam("estado_id") Long estadoId, @RequestParam("cidade_id") Long cidadeId) {
        return tournamentService.getAllUpcomingTournaments(estadoId, cidadeId);
    }

    @GetMapping("/filtrar")
    public List<Tournament> filterTournaments(
            @RequestParam(value = "estado_id", required = false) Long estadoId,
            @RequestParam(value = "cidade_id", required = false) Long cidadeId,
            @RequestParam(value = "data", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date data) {
        return tournamentService.filterTournaments(estadoId, cidadeId, data);
    }

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        Tournament createdTournament = tournamentService.createTournament(tournament);
        return new ResponseEntity<>(createdTournament, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable("id") Long id) {
        tournamentService.deleteTournament(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
