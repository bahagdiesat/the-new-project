package baha;

import Json.Json1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.*;


public class Main {

    private static Object Room;

    public static void main(String[] args) throws JsonProcessingException {
	// write your code here
        Maze maze= new MazeGame().CreateMaze();
    System.out.println(Json1.jsonStringGen(maze));




    }


}



