package console;

import java.util.*;

import static java.lang.System.out;
import static util.Validate.validaEntrada;
import static util.Validate.validateEntradaMultiple;

import java.util.logging.Logger;

public class AnagramasConsole {

    public static void main(String[] args) {

        final Logger logger = Logger.getLogger(AnagramasConsole.class.getName());
        Scanner scanner = new Scanner(System.in);
        Set<Character> letras = new LinkedHashSet<>();
        out.println("Digite pelo menos 3 letras distintas (tudo junto, separado por espaço ou uma por linha).");
        out.println("Digite 'OK' para finalizar a entrada.");

        while (true) {
            //inicia o scanner de letras do terminal
            out.println("Letra: ");
            String entrada = scanner.nextLine().trim();
            //verifica se o cliente digitou 'ok' e chama o validaEntrada
            if (entrada.equalsIgnoreCase("OK") && validaEntrada(letras, logger)){
                    break;
                }
            //Valida as entradas multiltiplas executando um clean se for inválido
            boolean valido = validateEntradaMultiple(entrada, logger, letras);
            if (!valido) {
                logger.warning("Entrada inválida detectada. Reiniciando as letras já digitadas.");
                letras.clear();
            }
        }
    }
}
