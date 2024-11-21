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

/*

In a client-server architecture, we use socket.getOutputStream() in the client
 (or even in the server after accepting a connection) because the Socket object represents a specific,
 active connection between the client and server. Here's why:

Key Differences Between ServerSocket and Socket
ServerSocket:

Represents the server waiting for incoming connections.
It listens on a specific port (e.g., 5000) but does not handle communication directly.
Once a client connects, ServerSocket creates a new Socket object that represents the specific
connection to the client.

Socket:
Represents an active connection between a server and a specific client.
It provides the actual input and output streams for communication.

Why Use socket.getOutputStream()?
Communication happens through the Socket, not the ServerSocket:
ServerSocket is only responsible for accepting connections.
After the connection is established, the Socket created by the ServerSocket.accept() method is used
to send and receive data.

How Streams Work in Networking
On the Server Side:

The ServerSocket waits for connections.
When a client connects, the ServerSocket hands off the connection to a Socket.
The server communicates with the client through the Socket object.

On the Client Side:
The client creates a Socket to connect to the server.
The client uses the Socket's input and output streams to send and receive data.
 */