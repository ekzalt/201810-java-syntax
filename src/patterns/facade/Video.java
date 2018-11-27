package patterns.facade;

import patterns.command.Player;

public class Video extends Player {
    @Override
    public void startPlayDisc() {
        System.out.println("Video start play " + disc + " on volume " + volume);
    }

    @Override
    public void stopPlayDisc() {
        System.out.println("Video stop play " + disc);
    }

    @Override
    public void on() {
        System.out.println("Video is ON");
    }

    @Override
    public void off() {
        System.out.println("Video is OFF");
    }
}
