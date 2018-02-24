package yncrea.pw08.web.controller;

import yncrea.pw08.web.utils.SessionManager;

import java.io.IOException;

@ServerEndpoint(
        value = "/control",
        decoders = { SlideDecoder.class },
        encoders = { SlideEncoder.class })
public class RevealController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RevealController.class);


    @OnOpen
    public void open(Session s) throws IOException, EncodeException {
        SessionManager.getInstance().addSession(s);
        SessionManager.getInstance().sendToSession(s, CurrentSlideHolder.getInstance().getCurrentSlide());
    }

    @OnClose
    public void close(Session s){
        SessionManager.getInstance().removeSession(s);
    }


    @OnMessage
    public void onSlide(Slide slide, Session session) {
        CurrentSlideHolder.getInstance().setCurrentSlide(slide);
        SessionManager.getInstance().broadcast(slide);
    }



}
