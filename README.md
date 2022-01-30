# League Table #

## Purpose ##
To accumulate and print a league table of points awarded for sports matches. The application reads game scores and apportions points from game results. The final league result is printed showing the league position of each team.
## Function ##
In this league, a draw (tie) is worth 1 point and a win is worth 3 points. A loss is worth 0 points. If two or more teams have the same number of points, they will have the same rank and be printed in alphabetical order (as in the tie for 3rd place in the sample data).
## Operation ##
The application is built as an executable JAR archive file. The file is named archive.jar and contains everything required to run the application. The application runs from the command line and it should have one or more result file names as arguments as in the example below.
- java -jar league.jar result_file1.txt result_file2.txt
## Input ##
Result files should be provided to the application with the following structure and the filenames should be added as parameters to the command when running the application.
### Structure ###
```
Lions 3, Snakes 3
Tarantulas 1, FC Awesome 0
Lions 1, FC Awesome 1
Tarantulas 3, Snakes 1
Lions 4, Grouches 0
```
## Output ##
When the application completes it will output a file named _LeagueTable.out_ in the directory from which the application is run. The output file has the following structure.
### Structure ###
```
1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Snakes, 1 pt
5. Grouches, 0 pts
```
## Development ##
The application is built as a standard java fat jar commandline application. The final executable jar is renamed by the _maven-assembly-plugin_.