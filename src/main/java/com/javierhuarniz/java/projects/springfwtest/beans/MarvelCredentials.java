package com.javierhuarniz.java.projects.springfwtest.beans;

/**
 * Created by javier on 28/01/2017..
 */
public class MarvelCredentials {
    private String publicKey;
    private String privateKey;

    public MarvelCredentials() {

    }

    public MarvelCredentials(String publicKey, String privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
