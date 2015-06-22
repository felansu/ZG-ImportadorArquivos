package br.com.zeroglosa

class LeitorBuilderTest extends GroovyTestCase {

    private final String ARQUIVO_PAGAMENTO = 'pagamentoUmaLinha.txt'
    private final String ARQUIVO_DIFERENTE = 'LeitorTxt.groovy'
    private final String DIRETORIO_ARQUIVO_DIFERENTE = 'main/br/com/zeroglosa'

    private LeitorBuilder leitorBuilder

    void setUp() {
        leitorBuilder = new LeitorBuilder()
    }

    void 'test build txt retorna leitor txt'() {
        assert leitorBuilder.build(ArquivoUtil.obtemArquivo(ARQUIVO_PAGAMENTO)) instanceof LeitorTxt
    }

    void "test build arquivo formato desconhecido lanca excecao"(){
        shouldFail(IllegalArgumentException){
            leitorBuilder.build(ArquivoUtil.obtemArquivo(DIRETORIO_ARQUIVO_DIFERENTE, ARQUIVO_DIFERENTE))
        }
    }

    void "test build arquivo nulo lanca excecao"() {
        shouldFail(IllegalArgumentException) {
            leitorBuilder.build(null)
        }
    }
}