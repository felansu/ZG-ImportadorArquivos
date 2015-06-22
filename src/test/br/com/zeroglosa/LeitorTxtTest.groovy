package br.com.zeroglosa

class LeitorTxtTest extends GroovyTestCase{

    private LeitorTxt leitorTxt = new LeitorTxt()
    private final File arquivoTxt = new File("src/pagamentoUmaLinha.txt")
    private final File arquivoPdf = new File("src/main/br/com/zeroglosa/LeitorTxt.groovy")

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
