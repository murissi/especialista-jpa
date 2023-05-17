package murissi;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class treinoTest {

    @BeforeClass
    public static void inicio() {
        System.out.println("Iniando antes dos testes");
    }

    @Before
    public void beforemethod() {
        System.out.println("Before");
    }

    @Test
    public void hello() throws IllegalAccessException {
        var idade = 18;
        if (idade < 18) {
            throw new IllegalAccessException("Idade não permitida");
        }
        System.out.println("Idade permitida");
    }
}
