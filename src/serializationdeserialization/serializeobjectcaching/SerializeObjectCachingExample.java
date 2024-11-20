package serializationdeserialization.serializeobjectcaching;

import serializationdeserialization.deepcloning.Address;
import serializationdeserialization.deepcloning.Person;

public class SerializeObjectCachingExample {
    public static void main(String[] args) {

        String file = "person.cache";
        Address address = new Address("Noida", "UP", "INDIA");
        Person person = new Person("Keshav", 27, 200000, address);
        System.out.println("Original Object: " + person);
        CacheObject cacheObject = new CacheObject();
        cacheObject.storeToCache(person, file);
        LoadFromCache loadFromCache = new LoadFromCache();
        Person cachedPerson = loadFromCache.leadFromCache(file);
        System.out.println("Person Fetched From Cache: " + cachedPerson);
    }
}
