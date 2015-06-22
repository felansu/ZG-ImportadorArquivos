package br.com.zeroglosa

class ArquivoUtil {

    protected static final File obtemArquivo(String nome) {
        new File("src/$nome")
    }

    protected static final File obtemArquivo(String directory, String nome) {
        new File("src/$directory/$nome")
    }

}
