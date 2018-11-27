package patterns.command;

public class Audio extends Player {
    private double wave = 100.5;

    public void setWave(double wave) {
        this.wave = wave;
    }

    public void startPlayRadio() {
        System.out.println("Audio start play radio on wave " + wave + "FM on volume " + volume);
    }

    public void stopPlayRadio() {
        System.out.println("Audio stop play radio on wave " + wave + "FM");
    }

    @Override
    public void startPlayDisc() {
        System.out.println("Audio start play " + disc + " on volume " + volume);
    }

    @Override
    public void stopPlayDisc() {
        System.out.println("Audio stop play " + disc);
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
