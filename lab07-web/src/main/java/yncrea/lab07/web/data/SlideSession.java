package yncrea.lab07.web.data;

import yncrea.lab07.web.dto.Slide;
import yncrea.lab07.web.transformation.SlideEncoder;

import javax.websocket.Session;

public class SlideSession {

    private Session session;

    public SlideSession(Session session) {
        this.session = session;
    }

    public void send(Object slide){
        try {
            SlideEncoder slideEncoder = new SlideEncoder();
            String encodeSlide = slideEncoder.encode((Slide) slide);

            session.getBasicRemote().sendObject( encodeSlide );
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }


}
