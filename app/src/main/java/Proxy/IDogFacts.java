package Proxy;

import java.util.List;

public interface IDogFacts {

    public List<Fact> getAllDogFacts();

    public Fact getDogFact(int id);
}
