package state.inner.ui;

import java.util.ArrayList;
import java.util.List;

public class Player {

  private final List<String> playlist = new ArrayList<>();
  private State state;
  private boolean playing = false;
  private int currentTrack = 0;

  public Player() {
    this.state = new ReadyState();
    setPlaying(true);
    for (int i = 1; i <= 12; i++) {
      playlist.add("Track " + i);
    }
  }

  private void changeState(State state) {
    this.state = state;
  }

  private boolean isPlaying() {
    return playing;
  }

  private void setPlaying(boolean playing) {
    this.playing = playing;
  }

  private String startPlayback() {
    return "Playing " + playlist.get(currentTrack);
  }

  private String nextTrack() {
    currentTrack = (currentTrack + 1) % playlist.size();
    return "Playing " + playlist.get(currentTrack);
  }

  private String previousTrack() {
    currentTrack = (playlist.size() + currentTrack - 1) % playlist.size();
    return "Playing " + playlist.get(currentTrack);
  }

  private void setCurrentTrackAfterStop() {
    this.currentTrack = 0;
  }

  public String onLock() {
    return state.onLock();
  }

  public String onPlay() {
    return state.onPlay();
  }

  public String onNext() {
    return state.onNext();
  }

  public String onPrevious() {
    return state.onPrevious();
  }

  private interface State {

    String onLock();

    String onNext();

    String onPlay();

    String onPrevious();
  }

  private class LockedState implements State {

    public LockedState() {
      setPlaying(false);
    }

    @Override
    public String onLock() {
      if (isPlaying()) {
        changeState(new ReadyState());
        return "Stop playing";
      } else {
        return "Locked...";
      }
    }

    @Override
    public String onPlay() {
      changeState(new ReadyState());
      return "Ready";
    }

    @Override
    public String onNext() {
      return "Locked...";
    }

    @Override
    public String onPrevious() {
      return "Locked...";
    }
  }

  private class PlayingState implements State {

    public PlayingState() {
      setPlaying(true);
    }

    @Override
    public String onLock() {
      changeState(new LockedState());
      setCurrentTrackAfterStop();
      return "Stop playing";
    }

    @Override
    public String onPlay() {
      changeState(new ReadyState());
      return "Paused...";
    }

    @Override
    public String onNext() {
      return nextTrack();
    }

    @Override
    public String onPrevious() {
      return previousTrack();
    }
  }

  private class ReadyState implements State {

    public ReadyState() {
    }

    @Override
    public String onLock() {
      changeState(new LockedState());
      return "Locked...";
    }

    @Override
    public String onPlay() {
      String action = startPlayback();
      changeState(new PlayingState());
      return action;
    }

    @Override
    public String onNext() {
      return "Locked...";
    }

    @Override
    public String onPrevious() {
      return "Locked...";
    }
  }
}
