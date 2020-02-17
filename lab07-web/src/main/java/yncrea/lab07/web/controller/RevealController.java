package yncrea.lab07.web.controller;

import org.slf4j.LoggerFactory;
import yncrea.lab07.web.dto.Slide;
import yncrea.lab07.web.transformation.SlideDecoder;
import yncrea.lab07.web.transformation.SlideEncoder;
import yncrea.lab07.web.utils.CurrentSlideHolder;
import yncrea.lab07.web.utils.SessionManager;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Logger;

@ServerEndpoint(
        value = "/control",
        decoders = { SlideDecoder.class },
        encoders = { SlideEncoder.class })
public class RevealController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(RevealController.class);


    @OnOpen
    public void open(Session s) throws IOException, EncodeException {
        SessionManager.getInstance().addSession(s);
        SessionManager.getInstance().sendToSession(s, CurrentSlideHolder.getInstance().getSlide());
    }

    @OnClose
    public void close(Session s){
        SessionManager.getInstance().removeSession(s);
    }


    @OnMessage
    public void onSlide(Slide slide, Session session) {
        CurrentSlideHolder.getInstance().setCurrentSlide((slide));
        SessionManager.getInstance().broadcast(slide);
    }



}
