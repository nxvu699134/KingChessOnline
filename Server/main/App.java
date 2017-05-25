package main;

import model.WaitingClient;
import model.datatype.RoomList;

public class App {
    
    public static final App INSTANCE = new App();
    
    public RoomList Rooms;
    
    private App() {
        Rooms = new RoomList();
    }
    
    public void start() {
        WaitingClient.asynchronousWaitingOn("127.0.0.1", 3000, 100);
    }
    
}
