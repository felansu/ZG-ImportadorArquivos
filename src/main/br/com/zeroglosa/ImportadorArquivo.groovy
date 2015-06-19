package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class ImportadorArquivo {

    List<Map> obterRegistros(File arquivo, String nomeLayout) {
        if (!nomeLayout || arquivo.text.empty) {
            throw new IllegalArgumentException()
        }

        LeitorBuilder leitorBuilder = new LeitorBuilder()
        Leitor leitorConteudo = leitorBuilder.build(arquivo)

        InterpretadorBuilder builder = new InterpretadorBuilder()
        Interpretador interpretador = builder.build(nomeLayout)
        interpretador.getRegistros(leitorConteudo.getConteudo(arquivo))

    }
}
