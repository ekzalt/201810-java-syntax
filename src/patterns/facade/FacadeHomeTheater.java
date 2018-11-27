package patterns.facade;

import patterns.command.Audio;
import patterns.command.Light;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FacadeHomeTheater {
    private PopcornMachine popcorn;
    private Screen screen;
    private Light light;
    private Video video;
    private Audio audio;

    public FacadeHomeTheater(
            PopcornMachine popcorn,
            Screen screen,
            Light light,
            Video video,
            Audio audio) {
        this.popcorn = popcorn;
        this.screen = screen;
        this.light = light;
        this.video = video;
        this.audio = audio;
    }

    public void watchMovie(String movie) {
        popcorn.on();
        popcorn.setCorn(100);
        popcorn.getCorn();

        screen.down();

        light.setBrightness(10);
        light.on();

        video.on();
        video.putDisc(movie);
        video.setVolume(50);
        video.startPlayDisc();
    }

    public void endMovie() {
        video.stopPlayDisc();
        video.pullDisc();
        video.off();

        light.setBrightness(100);
        light.on();

        screen.up();

        popcorn.off();
    }

    // имплементация других фасадных методов

    public void playMusic(String music) {
        throw new NotImplementedException();
    }

    public void endMusic() {
        throw new NotImplementedException();
    }

    public void listenRadio(double wave) {
        throw new NotImplementedException();
    }

    public void endRadio() {
        throw new NotImplementedException();
    }
}
