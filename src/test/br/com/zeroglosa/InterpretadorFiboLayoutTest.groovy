package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class InterpretadorFiboLayoutTest extends GroovyTestCase{

    InterpretadorFiboLayout interpretadorFiboLayout

    void setUp() {
        interpretadorFiboLayout = new InterpretadorFiboLayout()
    }

    private File obtemArquivo(String nome) {
        File arquivo = new File("/home/felansu/IdeaProjects/importadordearquivos/src/$nome")
        arquivo
    }

    void 'test conteudo nulo lanca excecao'() {
        shouldFail(IllegalArgumentException) {
            interpretadorFiboLayout.getRegistros(null)
        }
    }

    void 'test conteudo vazio lanca excecao'() {
        shouldFail(IllegalArgumentException) {
            interpretadorFiboLayout.getRegistros("")
        }
    }

    void 'test conteudo fibo layout minimo retorna registros'() {
        List<Map> valorEsperado = [[tipo: 'guia', senha: '4469552', matricula: '967613', nome: 'DIVANI FLORENCIO LACERDA',
                                   dataAtendimento: 21/03/2015]]
        File arquivo = obtemArquivo("pagamentoUmaLinha.txt")

        List<Map> retorno = interpretadorFiboLayout.getRegistros(arquivo.text)
        assertEquals(valorEsperado, retorno)
    }

}
