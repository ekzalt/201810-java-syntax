package patterns.command;

public class CommandAudioStopPlay implements ICommand {
    private Audio audio;

    public CommandAudioStopPlay(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.stopPlayDisc();
        audio.pullDisc();
        audio.off();
    }

    @Override
    public void undo() {
        audio.on();
        audio.putDisc("Mi-mi-mi");
        audio.setVolume(50);
        audio.startPlayDisc();
    }
}
