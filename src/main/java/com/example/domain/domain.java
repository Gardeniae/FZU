package com.example.domain;

public class domain {

    private String string;


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "domain{" +
                "string='" + string + '\'' +
                '}';
    }
}
