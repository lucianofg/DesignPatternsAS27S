package Proxy;

import java.time.LocalDateTime;
import java.util.List;

public class DogFactsCached implements IDogFacts {

    private final IDogFacts service;
    private List<Fact> factsCache;
    private LocalDateTime lastUpdated;

    public DogFactsCached(IDogFacts service) {
        this.service = service;
        this.factsCache = null;
    }

    @Override
    public List<Fact> getAllDogFacts() {
        if (this.factsCache == null || this.cacheNeedReset()) {
            this.fetchFacts();
        }
        return factsCache;
    }

    @Override
    public Fact getDogFact(int id) {
        if (this.factsCache == null || this.cacheNeedReset()) {
            this.fetchFacts();
        }
        return this.factsCache.get(id);
    }

    private boolean cacheNeedReset() {
        return this.lastUpdated.plusMinutes(10)
                .isAfter(LocalDateTime.now());
    }

    private void fetchFacts() {
        this.lastUpdated = LocalDateTime.now();
        this.factsCache = service.getAllDogFacts();
    }
}
