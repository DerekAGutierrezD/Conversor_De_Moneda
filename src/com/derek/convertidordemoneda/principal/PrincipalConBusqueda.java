package com.derek.convertidordemoneda.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalConBusqueda {

    private String monedaBase;
    private String monedaDestino;
    private double tasa;

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public void consultarTasa() {

        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try {
            String apiKey = "3f08359682b0c757355730c5";

            String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaBase + "/" + monedaDestino;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            if (jsonObject.get("result").getAsString().equals("success")) {
                tasa = jsonObject.get("conversion_rate").getAsDouble();
                System.out.println("Tasa de cambio: 1 " + monedaBase + " = " + tasa + " " + monedaDestino);
            } else {
                System.out.println("Error en la respuesta de la API: " + jsonObject.get("error-type").getAsString());
            }

        }catch (IllegalArgumentException | IOException | InterruptedException e){
            System.out.println("Error en la URI, verifique la dirección");
        }
    }
}