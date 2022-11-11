package Proxy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class DogFactsCached implements IDogFacts {

    private final IDogFacts service;
    private List<Fact> factsCache;
    private Fact currentFact;
    private LocalDateTime lastUpdated;

    public DogFactsCached(IDogFacts service) {
        this.service = service;
        this.factsCache = null;
    }

    @Override
    public List<Fact> getAllDogFacts() {
        this.fetchFacts();
        return this.factsCache;
    }

    @Override
    public Fact getDogFact(int id) {
        if (this.currentFact.getId() == id) {
            return this.currentFact;
        }
        this.fetchFacts();

        this.currentFact = this.factsCache.get(id);
        return this.currentFact;
    }

    private boolean cacheNeedReset() {
        return this.lastUpdated.plusMinutes(10)
                .isAfter(LocalDateTime.now());
    }

    private void fetchFacts() {
        if (this.factsCache == null || this.cacheNeedReset()) {
            this.lastUpdated = LocalDateTime.now();
            this.factsCache = service.getAllDogFacts();
        }
    }

    @Override
    public Fact getRandomFact() {
        this.fetchFacts();
        Random rand = new Random();
        return this.factsCache.get(rand.nextInt(this.factsCache.size()));
    }
}
