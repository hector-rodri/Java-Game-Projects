package com.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class musica {
    
    private static Clip clip;

    public static void reproducir(String rutaArchivo) {
        try {
            File archivoSonido = new File(rutaArchivo);
            AudioInputStream stream = AudioSystem.getAudioInputStream(archivoSonido);
            clip = AudioSystem.getClip();
            clip.open(stream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }
}
