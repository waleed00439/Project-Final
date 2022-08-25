package com.example.gamesonlinedatabase1.Modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "GameName: Can't be Empty")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String gameName;
    @Pattern(regexp = "(WAR|SPORTS|HORROR|SEAL|ADVENTURE|Fighting)")
    private String gameType;
    @Pattern(regexp = "(1|2|3|4|5)")
    private String gameRating;
    private String gameDate;


}



