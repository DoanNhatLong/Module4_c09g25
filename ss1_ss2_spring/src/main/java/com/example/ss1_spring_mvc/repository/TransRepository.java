package com.example.ss1_spring_mvc.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class TransRepository implements ITransRepository {
    private static final Map<String, String> dictionary = Map.of(
            "one", "Một",
            "two", "hai",
            "three", "ba"
    );


    @Override
    public String findWord(String word) {
        if (word == null) {
            return null;
        } else
            return dictionary.get(word);
    }
}
