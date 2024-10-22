package br.gov.prodeb.testeapi1.exceptions;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("Produto não encontrado!");
    }

}
