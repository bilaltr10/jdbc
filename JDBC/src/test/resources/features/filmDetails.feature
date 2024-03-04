@db
Feature: Film table automation features

  Scenario: Get a list of all films
    Given the film service is up and running
    When I request a list of all films
    Then I should receive a list containing all films in the database


  Scenario Outline: Verification of database by sending film name
    Given the film service is up and running
    When I request a film list contains '<word>'
    Then All the films appeared should contain '<word>'
    Examples:
      | word       |
      | Chamber    |
      | Academy    |
      | Summer     |
      | California |
      | Deep       |
      | Hard       |


  Scenario Outline:Get films' title and description by their ID in order of ascending
    Given the film service is up and running
    When I request title and description of films by IDs '<film_id>'
    Then I should receive the title '<film_id>' and description '<title>' of the film with ID '<description>'
    Examples:
      | film_id | title                     | description                                                                                                             |  |
      | 932     | "Valley Packer"           | "A Astounding Documentary of a Astronaut And a Boy who must Outrace a Sumo Wrestler in Berlin"                          |  |
      | 931     | "Valentine Vanishing"     | "A Thrilling Display of a Husband And a Butler who must Reach a Pastry Chef in California"                              |  |
      | 930     | "Vacation Boondock"       | "A Fanciful Character Study of a Secret Agent And a Mad Scientist who must Reach a Teacher in Australia"                |  |
      | 929     | "Usual Untouchables"      | "A Touching Display of a Explorer And a Lumberjack who must Fight a Forensic Psychologist in A Shark Tank"              |  |
      | 928     | "Uptown Young"            | "A Fateful Documentary of a Dog And a Hunter who must Pursue a Teacher in An Abandoned Amusement Park"                  |  |
      | 611     | "Musketeers Wait"         | "A Touching Yarn of a Student And a Moose who must Fight a Mad Cow in Australia"                                        |  |
      | 610     | "Music Boondock"          | "A Thrilling Tale of a Butler And a Astronaut who must Battle a Explorer in The First Manned Space Station"             |  |
      | 609     | "Muscle Bright"           | "A Stunning Panorama of a Sumo Wrestler And a Husband who must Redeem a Madman in Ancient India"                        |  |
      | 608     | "Murder Antitrust"        | "A Brilliant Yarn of a Car And a Database Administrator who must Escape a Boy in A MySQL Convention"                    |  |
      | 607     | "Muppet Mile"             | "A Lacklusture Story of a Madman And a Teacher who must Kill a Frisbee in The Gulf of Mexico"                           |  |
      | 606     | "Mummy Creatures"         | "A Fateful Character Study of a Crocodile And a Monkey who must Meet a Dentist in Australia"                            |  |
      | 128     | "Catch Amistad"           | "A Boring Reflection of a Lumberjack And a Feminist who must Discover a Woman in Nigeria"                               |  |
      | 127     | "Cat Coneheads"           | "A Fast-Paced Panorama of a Girl And a A Shark who must Confront a Boy in Ancient India"                                |  |
      | 126     | "Casualties Encino"       | "A Insightful Yarn of a A Shark And a Pastry Chef who must Face a Boy in A Monastery"                                   |  |
      | 125     | "Cassidy Wyoming"         | "A Intrepid Drama of a Frisbee And a Hunter who must Kill a Secret Agent in New Orleans"                                |  |
      | 124     | "Casper Dragonfly"        | "A Intrepid Documentary of a Boat And a Crocodile who must Chase a Robot in The Sahara Desert"                          |  |
      | 5       | "African Egg"             | "A Fast-Paced Documentary of a Pastry Chef And a Dentist who must Pursue a Forensic Psychologist in The Gulf of Mexico" |  |
      | 4       | "Affair Prejudice"        | "A Fanciful Documentary of a Frisbee And a Lumberjack who must Chase a Monkey in A Shark Tank"                          |  |
      | 3       | "Adaptation Holes"        | "A Astounding Reflection of a Lumberjack And a Car who must Sink a Lumberjack in A Baloon Factory"                      |  |
      | 226     | "Destiny Saturday"        | "A Touching Drama of a Crocodile And a Crocodile who must Conquer a Explorer in Soviet Georgia"                         |  |
      | 225     | "Destination Jerk"        | "A Beautiful Yarn of a Teacher And a Cat who must Build a Car in A U-Boat"                                              |  |
      | 224     | "Desperate Trainspotting" | "A Epic Yarn of a Forensic Psychologist And a Teacher who must Face a Lumberjack in California"                         |  |
      | 223     | "Desire Alien"            | "A Fast-Paced Tale of a Dog And a Forensic Psychologist who must Meet a Astronaut in The First Manned Space Station"    |  |
      | 222     | "Desert Poseidon"         | "A Brilliant Documentary of a Butler And a Frisbee who must Build a Astronaut in New Orleans"                           |  |
      | 221     | "Deliverance Mulholland"  | "A Astounding Saga of a Monkey And a Moose who must Conquer a Butler in A Shark Tank"                                   |  |
      | 220     | "Deer Virginian"          | "A Thoughtful Story of a Mad Cow And a Womanizer who must Overcome a Mad Scientist in Soviet Georgia"                   |  |


