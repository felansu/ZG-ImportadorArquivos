package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class ImportadorArquivo {

    List<Map> obterRegistros(File arquivo, String nomeLayout) {
        if (!nomeLayout) {
            throw new IllegalArgumentException()
        }

        if (arquivo.text.empty) {
            throw new IllegalArgumentException()
        }

        List<Map> dadosArquivo = new ArrayList<Map>()

        dadosArquivo << [tipo: 'guia', senha: '4469552', matricula: '967613', nome: 'DIVANI FLORENCIO LACERDA',
                        dataAtendimento: 21/03/2015]
    }
}
