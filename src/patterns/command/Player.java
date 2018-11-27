package patterns.command;

public abstract class Player implements ISwitchable {
    protected String disc = "";
    protected int volume = 0;

    public void putDisc(String disc) {
        this.disc = disc;
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

    public abstract void startPlayDisc();

    public abstract void stopPlayDisc();

    @Override
    public abstract void on();

    @Override
    public abstract void off();
}
