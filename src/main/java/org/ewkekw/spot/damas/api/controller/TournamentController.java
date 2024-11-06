package org.ewkekw.spot.damas.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ewkekw.spot.damas.api.model.Tournament;
import org.ewkekw.spot.damas.api.service.ITournamentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Tournament", description = "Operações relacionadas aos torneios")
@RestController
@RequestMapping("/torneios")
public class TournamentController {

    private final ITournamentService tournamentService;

    public TournamentController(ITournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @Operation(summary = "Próximos torneios", description = "Obtém os 4 próximos torneios na região especificada")
    @GetMapping("/proximos")
    public List<Tournament> getUpcomingTournaments(
            @Parameter(description = "ID do estado") @RequestParam("estado_id") Long estadoId,
            @Parameter(description = "ID da cidade") @RequestParam("cidade_id") Long cidadeId) {
        return tournamentService.getUpcomingTournaments(estadoId, cidadeId, 4);
    }

    @Operation(summary = "Todos os torneios futuros", description = "Obtém todos os torneios futuros na região especificada")
    @GetMapping("/todos")
    public List<Tournament> getAllUpcomingTournaments(
            @Parameter(description = "ID do estado") @RequestParam("estado_id") Long estadoId,
            @Parameter(description = "ID da cidade") @RequestParam("cidade_id") Long cidadeId) {
        return tournamentService.getAllUpcomingTournaments(estadoId, cidadeId);
    }

    @Operation(summary = "Filtra torneios", description = "Filtra torneios por estado, cidade e data")
    @GetMapping("/filtrar")
    public List<Tournament> filterTournaments(
            @Parameter(description = "ID do estado") @RequestParam(value = "estado_id", required = false) Long estadoId,
            @Parameter(description = "ID da cidade") @RequestParam(value = "cidade_id", required = false) Long cidadeId,
            @Parameter(description = "Data para filtrar") @RequestParam(value = "data", required = false)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate data) {
        return tournamentService.filterTournaments(estadoId, cidadeId, data);
    }

    @Operation(summary = "Criação de torneio", description = "Cria um novo torneio")
    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        Tournament createdTournament = tournamentService.createTournament(tournament);
        return new ResponseEntity<>(createdTournament, HttpStatus.CREATED);
    }

    @Operation(summary = "Deleção de torneio", description = "Deleta um torneio específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(
            @Parameter(description = "ID do torneio") @PathVariable("id") Long id) {
        tournamentService.deleteTournament(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
