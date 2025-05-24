package results;

import java.util.List;
import java.util.Set;

import static java.lang.System.out;
import static util.Anagrams.gerarAnagramas;

public class ExibeReultado {

    public static void exibeAnagramas(Set<Character> letras) {
        //Estancia um objeto do tipo Stringbuklder para acumular os caracteres dititados
        StringBuilder input = new StringBuilder();
        for (char c : letras) {
            input.append(c);
        }

        //Chama a função de geração do anagramas
        // Exibe os anagramas separados por ','.
        List<String> anagramas = gerarAnagramas(input.toString());
        out.println("Anagramas gerados: " + String.join(", ", anagramas));
    }
}
