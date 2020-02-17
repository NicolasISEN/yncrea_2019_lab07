package yncrea.lab07.web.transformation;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import yncrea.lab07.web.dto.Slide;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;
import java.io.OutputStream;

public class SlideEncoder implements Encoder.Text<Slide> {
    private ObjectMapper objectMapper;


    @Override
    public String encode(Slide slide) throws EncodeException {
        try {
            return this.objectMapper.writeValueAsString(slide);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void destroy() {

    }
}
