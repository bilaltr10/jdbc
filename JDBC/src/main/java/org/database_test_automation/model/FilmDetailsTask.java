package org.database_test_automation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmDetailsTask {
    private String title;
    private String description;
    private int releaseYear;
    private String category;
    private  String actorList;
}
