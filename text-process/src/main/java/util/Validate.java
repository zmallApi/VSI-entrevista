package util;

import java.util.Set;
import java.util.logging.Logger;

import static results.ExibeReultado.exibeAnagramas;

public class Validate {
    // mátodo para validar as entradas digitadas
    public static boolean validateEntradaMultiple(String entrada, Logger logger, Set<Character> letras) {
        String[] tokens = entrada.contains(" ") ? entrada.split("\\s+") : entrada.split("");

        boolean entradaValida = true;
        //varre os tokens para verificar se é um caracter válido 'letras'
        for (String token : tokens) {
            if (token.length() != 1 || !Character.isLetter(token.charAt(0))) {
                logger.warning("Caractere inválido ignorado: " + token);
                entradaValida = false;
            } else {
                letras.add(Character.toLowerCase(token.charAt(0)));
            }
        }

        return entradaValida;
    }

    public static boolean  validaEntrada(Set<Character> letras, Logger logger) {
        //valida a entrada nao pode ter menos que 3 letras
        if (letras.size() < 3) {
            logger.info("Você deve fornecer pelo menos 3 letras distintas.");
            return false;
        }
        //se passar gera e exibe os anagramas
        exibeAnagramas(letras);
        return true;
    }
}
