package com.example.gamesonlinedatabase1.Controller;

import com.example.gamesonlinedatabase1.Modle.GameDetails;
import com.example.gamesonlinedatabase1.Modle.Games;
import com.example.gamesonlinedatabase1.Service.GamesService;
import com.example.gamesonlinedatabase1.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/games")
public class gamesController {

    private final GamesService gamesService;

    @GetMapping
    public ResponseEntity getGames() {
        return ResponseEntity.status(200).body(gamesService.GetGames());
    }

    @PostMapping("/add")
    public ResponseEntity addGames(@RequestBody @Valid Games games) {
        gamesService.addGames(games);
        return ResponseEntity.status(200).body(new ApiResponse("New game added !", 200));
    }

    @PutMapping("/updategame/{gameid}")
    public ResponseEntity UpdateGame(@RequestBody @Valid Games games, @PathVariable Integer gameid) {
        gamesService.UpdateGames(games, gameid);
        return ResponseEntity.status(200).body(new ApiResponse("game Updated !", 200));
    }

    @DeleteMapping("/delegame/{gameid}")
    public ResponseEntity deletegame(@PathVariable Integer gameid) {
        gamesService.deleteGames(gameid);
        return ResponseEntity.status(200).body(new ApiResponse("Game deleted !", 200));
    }

    @GetMapping("/gametype")
    public ResponseEntity<List<Games>> findGamesByGameType(@RequestParam String gameType) {
        List<Games> games = gamesService.findGamesByGameType(gameType);
        return ResponseEntity.status(200).body(games);
    }

    @GetMapping("/gameName")
    public ResponseEntity<Games> findGamesByGameName(@RequestParam String gameName) {
        Games games = gamesService.findGamesByGameName(gameName);
        return ResponseEntity.status(200).body(games);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Games>> findGamesByGameRating(@RequestParam String gameRating) {
        List<Games> games = gamesService.findGamesByGameRating(gameRating);
        return ResponseEntity.status(200).body(games);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Games>> findGamesByGameDateGreaterThan(@RequestParam String date) {
        List<Games> games = gamesService.findGamesByGameDate(date);
        return ResponseEntity.status(200).body(games);
    }

    @GetMapping("/id")
    public ResponseEntity<Games> findGamesById(@RequestParam Integer id) {
        Games games = gamesService.findGamesById(id);
        return ResponseEntity.status(200).body(games);
    }

    @GetMapping("/topGame")
    public ResponseEntity<Games> findGamesByGameNamee(@RequestParam String topGame) {
        Games games = gamesService.findGamesByGameName(topGame);
        return ResponseEntity.status(200).body(games);
    }

}




