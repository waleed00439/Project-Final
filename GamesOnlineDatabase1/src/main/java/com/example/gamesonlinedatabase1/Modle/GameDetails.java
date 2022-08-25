package com.example.gamesonlinedatabase1.Modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class GameDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "game Price : can't Be Null !")
    private String gamePrice;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String aboutTheGame;
    private Integer gameId;

}
