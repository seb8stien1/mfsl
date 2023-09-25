# Multinational Fantasy Soccer League Backend
This project will involve the development of a Multinational Fantasy Soccer
League (MFSL) platform, which will allow soccer enthusiasts to manage soccer fantasy teams
by using players from different soccer leagues together. The team is eager to create MFSL,
which will revolutionize the current fantasy soccer ecosystem. At this time, there is no other
platform that enables multiple national leagues to be selected in one fantasy game, allowing
more diversity of soccer fans to play together in the same game mode. This is a much
demanded feature amid the soccer community, since key players are now scattered across
different European leagues such as Ligue 1 (France), Bundesliga (Germany), La Liga (Spain),
Serie A (Italy) and the Premier League (England). The expected outcomes will consist of a
functioning backend combined with a web application. The backend will be developed with Java
Spring while the frontend will be implemented using the React framework
## Requirements
* Java 17
* Maven
* Docker
## Building the app
1. `mvn install` builds the app and generates a jar file at `target/`
2. `docker build -t mfsl:latest .` will build a docker image with the name mfsl and the tag lastest
3. `docker run --env-file YOUR_ENVIRONMENT_FILE -p 8080:8080 mfsl:latest` will generate and run a container on port 8080.
   * Replace `YOUR_ENVIRONMENT_FILE` with the path to a file that contains sensitive environments variables that cannot be hosted on GitHub
