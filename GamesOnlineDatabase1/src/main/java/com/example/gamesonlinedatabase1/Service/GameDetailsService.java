package com.example.gamesonlinedatabase1.Service;

import com.example.gamesonlinedatabase1.Modle.GameDetails;
import com.example.gamesonlinedatabase1.Modle.Games;
import com.example.gamesonlinedatabase1.exception.ApiException;
import com.example.gamesonlinedatabase1.repository.GameDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameDetailsService {

    private final GameDetailsRepository gameDetailsRepository;

    public List<GameDetails> GetGameDetails() {
        return gameDetailsRepository.findAll();
    }

    public void addGameDetails(GameDetails gameDetails) {
        gameDetailsRepository.save(gameDetails);
    }

    public List<GameDetails> findGameDetailsByGamePrice(String price) {
        List<GameDetails> gameDetails = gameDetailsRepository.findGameDetailsByGamePrice(price);
        if (gameDetails == null) {
            throw new ApiException(("Worng Game Ratimg"));
        }
        return gameDetails;
    }
    public void UpdateGamesDetails(GameDetails gameDetails, Integer id){
        GameDetails gameDetails1 = gameDetailsRepository.getById(id);
        gameDetails1.setGamePrice(gameDetails.getGamePrice());
        gameDetails1.setAboutTheGame(gameDetails.getAboutTheGame());
        gameDetailsRepository.save(gameDetails1);
    }
    public void deleteGameDetails(Integer id){
        GameDetails gameDetails=gameDetailsRepository.getById(id);
        gameDetailsRepository.delete(gameDetails);
    }

}
