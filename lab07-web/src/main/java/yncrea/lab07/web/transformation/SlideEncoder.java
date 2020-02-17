package yncrea.lab07.web.transformation;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.encoder.Encoder;
import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import yncrea.lab07.web.dto.Slide;

import java.io.IOException;
import java.io.OutputStream;

public class SlideEncoder implements Encoder<Slide> {
    private ObjectMapper objectMapper;

    @Override
    public void init(OutputStream outputStream) throws IOException {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void doEncode(Slide slide) throws IOException {
        this.objectMapper.writeValueAsString(slide);
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void setContext(Context context) {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void addStatus(Status status) {

    }

    @Override
    public void addInfo(String s) {

    }

    @Override
    public void addInfo(String s, Throwable throwable) {

    }

    @Override
    public void addWarn(String s) {

    }

    @Override
    public void addWarn(String s, Throwable throwable) {

    }

    @Override
    public void addError(String s) {

    }

    @Override
    public void addError(String s, Throwable throwable) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }
}
