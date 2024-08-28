package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        String message = "{\"orderId\":\"ABC83939\",\"products\":[{\"name\":\"No1 soap\",\"quantity\":10,\"unitPrice\":93}]}";

        Type t = new TypeToken<Wrapper>() {}.getType();

        Gson gson = new Gson();

        Wrapper w = gson.fromJson(message, t);

         System.out.println(w.orderId);
         System.out.println(w.products[0].name);
         System.out.println(w.products[0].quantity);
         System.out.println(w.products[0].unitPrice);

    }
}

class Wrapper {
    String orderId;
    Product[] products;
}

class Product {
    String name;
    int quantity;
    int unitPrice;
}
