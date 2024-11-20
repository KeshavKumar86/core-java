package serializationdeserialization.serializeobjecttransmission;

import serializationdeserialization.deepcloning.Address;
import serializationdeserialization.deepcloning.Person;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {
    public static void main(String[] args) {

        ObjectOutputStream outputStream;
        Address address = new Address("Noida", "UP", "India");
        Person person = new Person("Keshav", 27, 45000, address);
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port: " + 1234 + "....");
            Socket socket = serverSocket.accept();
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(person);
            System.out.println("Sent: " + person);
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
/*
2. Networking: Serialize Objects for Transmission Over Sockets
In networking, serialization is used to send objects across a network. The object is serialized into
a byte stream, transmitted via a socket, and then deserialized on the receiving end.

Execution Steps
Run the server program.
Run the client program.
The server sends a serialized Person object, and the client deserializes and displays it.
 */