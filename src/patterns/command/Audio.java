package patterns.command;

public class Audio implements ISwitchable {
    private String disc = "";
    private int volume = 0;

    public void putDisc(String disc) {
        this.disc = disc;
    }

    public void startPlayDisc() {
        System.out.println("Audio start play " + disc + " on volume " + volume);
    }

    public void stopPlayDisc() {
        System.out.println("Audio stop play " + disc);
    }

    public String pullDisc() {
        String extract = disc;
        disc = "";
        return extract;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void on() {
        System.out.println("Audio is ON");
    }

    @Override
    public void off() {
        System.out.println("Audio is OFF");
    }
}
