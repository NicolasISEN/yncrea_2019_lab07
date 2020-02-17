package yncrea.lab07.web.data;

import yncrea.lab07.web.transformation.SlideEncoder;

import javax.websocket.Session;

public class SlideSession {

    private Session session;

    public SlideSession(Session session) {
        this.session = session;
    }

    public void send(Object slide){
        SlideEncoder slideEncoder = new SlideEncoder();

        try {
            session.getBasicRemote().sendObject( slide );
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }


}
