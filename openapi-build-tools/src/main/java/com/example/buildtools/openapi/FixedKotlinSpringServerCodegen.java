package com.example.buildtools.openapi;

import org.openapitools.codegen.languages.KotlinSpringServerCodegen;

public class FixedKotlinSpringServerCodegen extends KotlinSpringServerCodegen {

    @Override
    public String toModelImport(String name) {
        if (name.contains(".")) {
            return name;
        }
        return super.toModelImport(name);
    }


    @Override
    public String getName() {
        return "fixed-kotlin-spring";
    }
}