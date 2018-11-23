package patterns.command;

public class CommandAudioStartPlay implements ICommand {
    private Audio audio;

    public CommandAudioStartPlay(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() {
        // можно вызывать множественные комманды
        // или методы фасада, если сложный интерфейс
        audio.on();
        audio.putDisc("Mi-mi-mi");
        audio.setVolume(50);
        audio.startPlayDisc();
    }

    @Override
    public void undo() {
        audio.stopPlayDisc();
        audio.pullDisc();
        audio.off();
    }
}
