package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class LeitorBuilderTest extends GroovyTestCase {

    LeitorBuilder leitorBuilder
    File arquivoTxt = new File("/home/felansu/IdeaProjects/importadordearquivos/src/pagamentoUmaLinha.txt")
    File arquivoPdf = new File("/home/felansu/IdeaProjects/importadordearquivos/src/main/br/com/zeroglosa/LeitorTxt.groovy")

    void setUp() {
        leitorBuilder = new LeitorBuilder()
    }

    void 'test build txt retorna leitor txt'() {
        assert leitorBuilder.build(arquivoTxt) instanceof LeitorTxt
    }

    void "test build arquivo formato desconhecido lanca excecao"(){
        shouldFail(IllegalArgumentException){
            leitorBuilder.build(arquivoPdf)
        }
    }

    void "test build arquivo nulo lanca excecao"() {
        shouldFail(IllegalArgumentException) {
            leitorBuilder.build(null)
        }
    }


}
