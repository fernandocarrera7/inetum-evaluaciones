package com.ineutm.backend.evaluaciones.expose.utils;

public class Util {
    public static void validateEmailFormat(String correo) {
        if (correo == null || !correo.matches("[a-zA-Z0-9._%+-]+@inetum\\.com\\.pe")) {
            throw new IllegalArgumentException("Formato de email con dominio 'inetum.com.pe' inválido");
        }
    }

    public static void validateDniFormat(String dni) {
        if (dni == null || !dni.matches("\\d{8}")) {
            throw new IllegalArgumentException("Formato de DNI inválido");
        }
    }
    public  static String encriptFirstFourCharacter(String value){
        String FirstFourCharacter = value.substring(0, 4);
        String otherCharacter = value.substring(4);
        FirstFourCharacter =obfuscateCharacter(FirstFourCharacter);
        return FirstFourCharacter + otherCharacter;
    }
    private static String obfuscateCharacter(String str) {

        return str.replaceAll(".", "*");
    }
    public static String constructDni(String dni){
        String tipoDoc = "dni";
       return tipoDoc+ "-" + dni;
    }
}
