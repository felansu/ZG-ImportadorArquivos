package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class LeitorTxt implements Leitor{

    @Override
    String getConteudo(File arquivo) {
        if (arquivo && arquivo.name.endsWith("txt")) return arquivo.text
        throw new IllegalArgumentException()
    }
}
