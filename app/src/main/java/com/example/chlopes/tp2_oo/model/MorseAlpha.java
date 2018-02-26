package com.example.chlopes.tp2_oo.model;

/**
 * Created by chlopes on 2018-02-25.
 */

public class MorseAlpha {

    String morse;
    String alpha;

    public MorseAlpha(){}

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public MorseAlpha(String morse, String alpha) {
        this.morse = morse;
        this.alpha = alpha;

    }
}
