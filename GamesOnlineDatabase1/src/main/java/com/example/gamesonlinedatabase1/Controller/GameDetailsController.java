package com.example.gamesonlinedatabase1.Controller;

import com.example.gamesonlinedatabase1.Modle.GameDetails;
import com.example.gamesonlinedatabase1.Modle.Games;
import com.example.gamesonlinedatabase1.Service.GameDetailsService;
import com.example.gamesonlinedatabase1.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/details")
public class GameDetailsController {

    private final GameDetailsService gameDetailsService;

    @GetMapping
    public ResponseEntity getGameDetails() {
        return ResponseEntity.status(200).body(gameDetailsService.GetGameDetails());
    }

    @PostMapping("/det")
    public ResponseEntity addGameDetails(@RequestBody @Valid GameDetails gameDetails) {
        gameDetailsService.addGameDetails(gameDetails);
        return ResponseEntity.status(201).body(new ApiResponse("New GameDetails added !", 201));
    }

    @GetMapping("/price")
    public ResponseEntity<List<GameDetails>> findGameDetailsByGamePrice(@RequestParam String price) {
        List<GameDetails> gameDetails = gameDetailsService.findGameDetailsByGamePrice(price);
        return ResponseEntity.status(200).body(gameDetails);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateDetails(@RequestBody @Valid GameDetails gameDetails,@PathVariable Integer id){
        gameDetailsService.UpdateGamesDetails(gameDetails,id);
        return ResponseEntity.status(200).body(new ApiResponse("game Details Updated !",200));
    }
    @DeleteMapping("/delDetails")
    public ResponseEntity deleteGameDetails(@PathVariable Integer id){
        gameDetailsService.deleteGameDetails(id);
        return ResponseEntity.status(200).body(new ApiResponse("Game Details Deleted ! ",200));
    }
}