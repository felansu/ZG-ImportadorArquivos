package br.com.zeroglosa

class InterpretadorBuilderTest extends GroovyTestCase {

    private final String LAYOUT_DIFERENTE = 'layout-diferente'
    private final String FIBO_LAYOUT = 'fibo-layout'

    private InterpretadorBuilder interpretadorBuilder

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
           interpretadorBuilder.build(LAYOUT_DIFERENTE)
        }
    }

    void 'test fibo layout retorna interpretador fibo layout'() {
        assert interpretadorBuilder.build(FIBO_LAYOUT) instanceof InterpretadorFiboLayout
    }
}