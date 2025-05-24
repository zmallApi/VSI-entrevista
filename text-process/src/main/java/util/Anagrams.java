package util;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {

    public static   List<String> gerarAnagramas(String input) {
        //Estancia uma lista para armazenar as permutações
        List<String> resultado = new ArrayList<>();
        permutar("", input, resultado);
        return resultado;
    }

    //metodo permutar gera as combinações recursivamente efetuado todas as conbinaççoes possiveis
    //Número de permutações para n letras = n! (fatorial de n)
    //Para 3 letras: 3! = 6 permutações
    //Para 4 letras: 4! = 24 permutações
    //Para 5 letras: 5! = 120, etc.
    private static void permutar(String prefixo, String restante, List<String> resultado) {
        if (restante.isEmpty()) {
            resultado.add(prefixo);
        } else {
            for (int i = 0; i < restante.length(); i++) {
                permutar(
                        prefixo + restante.charAt(i),
                        restante.substring(0, i) + restante.substring(i + 1),
                        resultado
                );
            }
        }
    }
}
