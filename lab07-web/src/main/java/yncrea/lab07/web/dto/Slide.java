package yncrea.lab07.web.dto;

public class Slide {

    private int  indexv;
    private int  indexh;
    private int  indexf;


    public Slide(int indexv, int indexh, int indexf) {
        this.indexv = indexv;
        this.indexh = indexh;
        this.indexf = indexf;
    }

    public int getIndexv() {
        return indexv;
    }

    public void setIndexv(int indexv) {
        this.indexv = indexv;
    }

    public int getIndexh() {
        return indexh;
    }

    public void setIndexh(int indexh) {
        this.indexh = indexh;
    }

    public int getIndexf() {
        return indexf;
    }

    public void setIndexf(int indexf) {
        this.indexf = indexf;
    }
}
