package controller;

import helper.Converter;
import helper.Wrapper;
import model.responser.JoinRoomResponser;
import model.responser.NewRoomResponser;
import model.responser.QuitRoomResponser;
import model.responser.Responser;
import model.responser.RoomsListResponser;
import model.responser.FinishMatchResponser;
import model.responser.LoginResponser;
import model.responser.RenewRoomResponser;
import model.responser.StartMatchResponser;

// Using pattern: Factory method
public class MessagesManager {
    
    public static Responser recvRequest(byte[] message) {
        switch(Converter.toInt((byte[])Wrapper.INSTANCE.unwrap(message)[0])) {
            case 0:
                return FinishMatchResponser.Instance;
            case 1:
                return JoinRoomResponser.Instance;
            case 2:
                return NewRoomResponser.Instance;
            case 3:
                return QuitRoomResponser.Instance;
            case 4:
                return RoomsListResponser.Instance;
            case 5:
                return StartMatchResponser.Instance;
            case 6:
                return LoginResponser.Instance;
            case 7:
                return RenewRoomResponser.Instance;
            default:
                return null;
        }
    }
    
}
