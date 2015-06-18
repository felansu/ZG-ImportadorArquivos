package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class InterpretadorFiboLayout implements Interpretador{
    @Override
    List<Map> getRegistros(String conteudo) {
        //TODO A gente parou por aqui
        if (conteudo) {
            def tiposDeRegistros = conteudo.findAll(/(?<=#).*?\n/)
            def dados = []
            tiposDeRegistros.each{ << it.tokenize('|')}

            return dados
        }
        throw new IllegalArgumentException()
    }
}
