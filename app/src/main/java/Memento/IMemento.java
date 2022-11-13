package Memento;

import java.time.LocalDateTime;

public interface IMemento {

    public void restore();

    public LocalDateTime getCreationDate();
}
