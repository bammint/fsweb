package com.example.firstproject.ioc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Beef extends Ingredient {
    public Beef(String name) {
        super(name);
    }
}
