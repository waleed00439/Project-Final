package com.example.gamesonlinedatabase1.repository;

import com.example.gamesonlinedatabase1.Modle.GameDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDetailsRepository extends JpaRepository<GameDetails, Integer> {

    List<GameDetails> findByGameId(Integer idd);


    List<GameDetails> findGameDetailsByGamePrice(String price);
}
