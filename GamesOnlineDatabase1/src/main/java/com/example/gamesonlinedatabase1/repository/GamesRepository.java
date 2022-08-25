package com.example.gamesonlinedatabase1.repository;

import com.example.gamesonlinedatabase1.Modle.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {


    List<Games> findGamesByGameType(String GameType);

    Games findGamesByGameName(String gameName);

    Games findGamesById(Integer id);

    List<Games> findGamesByGameRating(String gameRating);

    List<Games> findGamesByGameDate(String date);


}
