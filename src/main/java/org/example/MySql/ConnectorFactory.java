package org.example.MySql;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectorFactory {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        // GET
        HttpResponse<String> response = client.send(
                HttpRequest
                        .newBuilder(new URI("http://www.foo.com/"))
                        .headers("Foo", "foovalue", "Bar", "barvalue")
                        .GET()
                        .build(),
                BodyHandler.asString()
        );
    }
}
