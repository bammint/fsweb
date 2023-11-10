package com.example.firstproject.ioc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chick extends Ingredient {

    public Chick(String name) {
        super(name);
    }
}
