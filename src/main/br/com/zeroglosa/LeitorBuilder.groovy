package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class LeitorBuilder {

    Leitor build(File arquivo) {
        if (arquivo?.name?.endsWith("txt"))
            new LeitorTxt()
        else
            throw new IllegalArgumentException()
    }
}
