package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class InterpretadorBuilderTest extends GroovyTestCase {

    InterpretadorBuilder interpretadorBuilder

    void setUp() {
        interpretadorBuilder = new InterpretadorBuilder()
    }

    void 'test Layout nulo lança excecao'() {
        shouldFail(IllegalArgumentException) {
            interpretadorBuilder.build(null)
        }
    }

    void 'test Layout nao conhecido lanca excecao'() {
        shouldFail(IllegalArgumentException) {
           interpretadorBuilder.build("layout-diferente")
        }
    }

    void 'test fibo layout retorna interpretador fibo layout'() {
        assert interpretadorBuilder.build("fibo-layout") instanceof InterpretadorFiboLayout
    }

}