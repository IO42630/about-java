package com.olexyn.about.java.lambda.method_reference.types;

import java.util.function.Supplier;

public class ConstructorMethodReference {


    public static void main(String... args) {

        Supplier<Product> supplier1 = () -> new Product();
        Supplier<Product> supplier2 = Product::new;



    }
}





class Product{}
