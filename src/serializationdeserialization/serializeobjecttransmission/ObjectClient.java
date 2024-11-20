package serializationdeserialization.serializeobjecttransmission;

import serializationdeserialization.deepcloning.Person;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ObjectClient {
    public static void main(String[] args) {

        ObjectInputStream inputStream;
        Person person;
        try {

            Socket socket = new Socket("localhost", 1234);
            inputStream = new ObjectInputStream(socket.getInputStream());
            person = (Person) inputStream.readObject();
            inputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Received: " + person);
    }
}
