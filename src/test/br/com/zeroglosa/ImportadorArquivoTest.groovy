package br.com.zeroglosa

class ImportadorArquivoTest extends GroovyTestCase {

    private final String ARQUIVO_PAGAMENTO = 'pagamento.txt'
    private final String ARQUIVO_PAGAMENTO_VAZIO = 'pagamentoVazio.txt'
    private final String ARQUIVO_PAGAMENTO_UMA_LINHA = 'pagamentoUmaLinha.txt'
    private final String LAYOUT_FIBO = 'fibo-layout'

    private ImportadorArquivo importadorArquivo

    void setUp() {
        importadorArquivo = new ImportadorArquivo()
    }

    void "test Nome do layout vazio lança exceção"() {
        shouldFail(IllegalArgumentException) {
            importadorArquivo.obterRegistros(ArquivoUtil.obtemArquivo(ARQUIVO_PAGAMENTO), "")
        }
    }

    void "test Nome do layout nulo lança exceção"() {
        shouldFail(IllegalArgumentException) {
            importadorArquivo.obterRegistros(ArquivoUtil.obtemArquivo(ARQUIVO_PAGAMENTO), null)
        }
    }

    void "test Arquivo 'txt' do tipo Pagamento retorna lista de mapa"() {
        List<Map> dadosArquivo = importadorArquivo.obterRegistros(ArquivoUtil.obtemArquivo(ARQUIVO_PAGAMENTO), LAYOUT_FIBO)
        assertNotNull dadosArquivo
    }

    void "test arquivo sem conteudo lança exceção"() {
        shouldFail(IllegalArgumentException) {
            importadorArquivo.obterRegistros(ArquivoUtil.obtemArquivo(ARQUIVO_PAGAMENTO_VAZIO), LAYOUT_FIBO)
        }
    }

    void "test Layout de pagamento minimo retorna registros"() {
        List<Map> valorEsperado = [[tipo                 : 'guia',
                                    Senha                : '4469552',
                                    Matrícula            : '967613',
                                    Nome                 : 'DIVANI FLORENCIO LACERDA',
                                    'Data de atendimento': '21/03/2015']]

        List<Map> retorno = importadorArquivo.obterRegistros(ArquivoUtil.obtemArquivo(ARQUIVO_PAGAMENTO_UMA_LINHA), LAYOUT_FIBO)
        assertEquals(valorEsperado, retorno)
    }
}
