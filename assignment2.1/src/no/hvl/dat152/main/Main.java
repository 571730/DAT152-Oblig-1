package no.hvl.dat152.main;

import no.hvl.dat152.TUI.StoreFront;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        Locale nb = new Locale("en");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("apptext", nb);
        StoreFront.interfaceLoop(resourceBundle);
    }
}

