package serializationdeserialization.serializeobjectcaching;

import serializationdeserialization.deepcloning.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadFromCache {
    public Person loadFromCache(String file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            Person person = (Person) inputStream.readObject();
            inputStream.close();
            fileInputStream.close();
            return person;

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
