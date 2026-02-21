package com.example.nbaapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Total {
    private Integer standing_place;
    private String standing_place_typel;
    private String standing_team;
    private Integer standing_P;
    private Integer standing_W;
    private Integer standing_WO;
    private Integer standing_L;
    private Integer standing_LO;
    private Integer standing_F;
    private Integer standing_A;
    private String standing_PCT;
    private Integer team_key;
    private Integer league_key;
    private String league_season;
    private String league_round;
    private String standing_updated;
    private Integer fk_stage_key;
    /*private String stage_name;*/
}
