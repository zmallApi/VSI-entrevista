package test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
import static util.Anagrams.gerarAnagramas;
import static util.Validate.validaEntrada;
import static util.Validate.validateEntradaMultiple;

public class AnagramasUtilTest {

    @Test
    public void testGerarAnagramasSimples() {
        List<String> resultado = gerarAnagramas("abc");
        List<String> esperado = List.of("abc", "acb", "bac", "bca", "cab", "cba");

        assertEquals(new HashSet<>(esperado), new HashSet<>(resultado));
        assertEquals(6, resultado.size());
    }

    @Test
    public void testValidaEntradaMultiplaComEspacos() {
        Logger logger = Logger.getLogger("Teste");
        Set<Character> letras = new LinkedHashSet<>();

        boolean valido = validateEntradaMultiple("a b c", logger, letras);

        assertTrue(valido);
        assertTrue(letras.containsAll(List.of('a', 'b', 'c')));
    }

    @Test
    public void testValidaEntradaMultiplaComCaracterInvalido() {
        Logger logger = Logger.getLogger("Teste");
        Set<Character> letras = new LinkedHashSet<>();

        boolean valido = validateEntradaMultiple("a b 1", logger, letras);

        assertFalse(valido);
        assertFalse(letras.contains('1'));
    }

    @Test
    public void testValidaEntradaComMenosDeTres() {
        Logger logger = Logger.getLogger("Teste");
        Set<Character> letras = new LinkedHashSet<>(Set.of('a', 'b'));

        boolean resultado = validaEntrada(letras, logger);

        assertFalse(resultado);
    }

    @Test
    public void testValidaEntradaComVazia() {
        Logger logger = Logger.getLogger("Teste");
        Set<Character> letras = new LinkedHashSet<>(Set.of(' '));

        boolean resultado = validaEntrada(letras, logger);

        assertFalse(resultado);
    }

    @Test
    public void testValidaEntradaCorreta() {
        Logger logger = Logger.getLogger("Teste");
        Set<Character> letras = new LinkedHashSet<>(Set.of('a', 'b', 'c'));

        assertDoesNotThrow(() -> validaEntrada(letras, logger));
    }
}
