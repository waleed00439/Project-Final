package com.example.gamesonlinedatabase1.Service;

import com.example.gamesonlinedatabase1.Modle.Games;
import com.example.gamesonlinedatabase1.exception.ApiException;
import com.example.gamesonlinedatabase1.repository.GamesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final GamesRepository gamesRepository;


    public List<Games> GetGames() {
        return gamesRepository.findAll();
    }

    public void addGames(Games games) {
        gamesRepository.save(games);
    }

    public void UpdateGames(Games games, Integer id) {
        Games oldgames = gamesRepository.findGamesById(id);
        oldgames.setGameName(games.getGameName());
        oldgames.setGameType(games.getGameType());
        oldgames.setGameRating(games.getGameRating());
//        oldgames.setGameDate(games.getGameDate());
        gamesRepository.save(oldgames);
    }

    public void deleteGames(Integer id) {
        Games myGame = gamesRepository.findGamesById(id);
        gamesRepository.delete(myGame);
    }

    public List<Games> findGamesByGameType(String GameType) {
        List<Games> games = gamesRepository.findGamesByGameType(GameType);
        if (games == null) {
            throw new ApiException("Worng Game Type !");
        }
        return games;
    }

    public Games findGamesByGameName(String gameName) {
        Games games = gamesRepository.findGamesByGameName(gameName);
        if (games == null) {
            throw new ApiException("Worng Game Type !");
        }
        return games;
    }

    public List<Games> findGamesByGameRating(String gameRating) {
        List<Games> games = gamesRepository.findGamesByGameRating(gameRating);
        if (games == null) {
            throw new ApiException(("Worng Game Ratimg !"));
        }
        return games;
    }

    public List<Games> findGamesByGameDate(String date) {
        List<Games> games = gamesRepository.findGamesByGameDate(date);
        if (games == null) {
            throw new ApiException("Worng Game Date !");
        }
        return games;
    }

    public Games findGamesById(Integer id) {
        Games games = gamesRepository.findGamesById(id);
        if (games == null) {
            throw new ApiException("Not Found ID !");
        }
        return games;
    }

    public Games findGamesByGameNamee(String topGames) {
        Games games = gamesRepository.findGamesByGameName(topGames);
        if (games == null) {
            throw new ApiException("Worng top Games !");
        }
        return games;
    }
}