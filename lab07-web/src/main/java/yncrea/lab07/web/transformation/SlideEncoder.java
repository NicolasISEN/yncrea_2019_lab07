package yncrea.lab07.web.transformation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import yncrea.lab07.web.dto.Slide;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class SlideEncoder implements Encoder.Text<Slide> {
    private ObjectMapper objectMapper;


    @Override
    public String encode(Slide slide) {

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
