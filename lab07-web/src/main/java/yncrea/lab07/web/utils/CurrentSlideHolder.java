package yncrea.lab07.web.utils;

import yncrea.lab07.web.dto.Slide;

public class CurrentSlideHolder {
    private Slide slide;
    private static CurrentSlideHolder currentSlideHolder;

    public Slide getSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    private CurrentSlideHolder() {
    }

    public static CurrentSlideHolder getInstance() {
        if (currentSlideHolder==null) {
            return new CurrentSlideHolder();
        }
        return currentSlideHolder;
    }

    public static Slide getCurrentSlide() {
        return CurrentSlideHolder.getInstance().getSlide();
    }

    public static void setCurrentSlide(Slide currentSlideHolder) {
        CurrentSlideHolder.getInstance().setSlide(currentSlideHolder);
    }
}
