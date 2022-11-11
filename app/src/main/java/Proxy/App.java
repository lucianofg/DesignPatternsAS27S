package Proxy;

public class App {

    public static void main(String[] args) {
        DogFacts test = new DogFacts();
        DogFactsCached cache = new DogFactsCached(test);
        
        // List random fact
        Fact randomCache = cache.getRandomFact();
        Fact randomApi = test.getRandomFact();
        
        System.out.println("A random fact taken from the cache:\n\t" + randomCache.getFact());
        System.out.println("A random fact taken from the api:\n\t" + randomApi.getFact());
    }
}
