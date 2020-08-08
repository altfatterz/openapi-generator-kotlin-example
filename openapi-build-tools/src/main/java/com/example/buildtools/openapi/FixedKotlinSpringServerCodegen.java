package com.example.buildtools.openapi;

import org.openapitools.codegen.languages.KotlinSpringServerCodegen;

public class FixedKotlinSpringServerCodegen extends KotlinSpringServerCodegen {

    // instead of 'import com.example.org.zalando.problem.Problem' it will be 'import org.zalando.problem.Problem'
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