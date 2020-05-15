package App;


import Client.Client;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();

    }
}
