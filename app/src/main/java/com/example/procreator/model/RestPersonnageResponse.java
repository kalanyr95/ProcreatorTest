package com.example.procreator.model;

import java.util.List;

public class RestPersonnageResponse {
    private Integer count;
    private List<Personnage> results;

    public List<Personnage> getResults(){
        return results;
    }
}
