/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJBMail;

/**
 *
 * @author 18722
 */
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class MyWebSocketEndpoint {

    @OnMessage
    public void onMessage(String message, Session session) {
        // Handle incoming messages
    }
}
