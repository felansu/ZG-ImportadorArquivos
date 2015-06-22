package br.com.zeroglosa

class InterpretadorFiboLayoutTest extends GroovyTestCase{

    private final String ARQUIVO_PAGAMENTO_UMA_LINHA = 'pagamentoUmaLinha.txt'
    private final String ARQUIVO_PAGAMENTO_NOME_VAZIO = 'pagamentoNomeVazio.txt'

    private InterpretadorFiboLayout interpretadorFiboLayout

    void setUp() {
        interpretadorFiboLayout = new InterpretadorFiboLayout()
    }

    void 'test conteudo nulo lanca excecao'() {
        shouldFail(IllegalArgumentException) {
            interpretadorFiboLayout.getRegistros(null)
        }
    }

    void 'test conteudo vazio lanca excecao'() {
        shouldFail(IllegalArgumentException) {
            interpretadorFiboLayout.getRegistros('')
        }
    }

    void 'test conteudo fibo layout minimo retorna registros'() {
        List<Map> valorEsperado = [[tipo: 'guia',
                                    Senha: '4469552',
                                    Matrícula: '967613',
                                    Nome: 'DIVANI FLORENCIO LACERDA',
                                    'Data de atendimento': '21/03/2015']]

        File arquivo = ArquivoUtil.obtemArquivo(ARQUIVO_PAGAMENTO_UMA_LINHA)

        List<Map> retorno = interpretadorFiboLayout.getRegistros(arquivo.text)
        assertEquals(valorEsperado, retorno)
    }

    void 'test item "nome" com valor vazio retorna o campo "nome" vazio'() {
        List<Map> valorEsperado = [[tipo: 'guia',
                                    Senha: '4469552',
                                    Matrícula: '967613',
                                    Nome: '',
                                    'Data de atendimento': '21/03/2015']]

        File arquivo = ArquivoUtil.obtemArquivo(ARQUIVO_PAGAMENTO_NOME_VAZIO)

        List<Map> retorno = interpretadorFiboLayout.getRegistros(arquivo.text)
        assertEquals(valorEsperado, retorno)
    }
}