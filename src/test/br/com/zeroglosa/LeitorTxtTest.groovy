package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class LeitorTxtTest extends GroovyTestCase{

    LeitorTxt leitorTxt = new LeitorTxt()
    File arquivoTxt = new File("/home/felansu/IdeaProjects/importadordearquivos/src/pagamentoUmaLinha.txt")
    File arquivoPdf = new File("/home/felansu/IdeaProjects/importadordearquivos/src/main/br/com/zeroglosa/LeitorTxt.groovy")

    void 'test leitor txt retorna conteudo txt'() {
        assertEquals arquivoTxt.text , leitorTxt.getConteudo(arquivoTxt)
    }

    void 'test leitor arquivo nulo lanca excecao'() {
        shouldFail(IllegalArgumentException) {
            leitorTxt.getConteudo(null)
        }
    }

    void 'test leitor txt lanca excecao arquivo formato incorreto'(){
        shouldFail(IllegalArgumentException) {
            leitorTxt.getConteudo(arquivoPdf)
        }
    }


}
