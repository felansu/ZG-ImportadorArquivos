package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class InterpretadorFiboLayout implements Interpretador {
    @Override
    List<Map> getRegistros(String conteudo) {
        //TODO A gente parou por aqui
        if (conteudo) {


            def tiposDeRegistros = [:]

// Retornamos um array de strings que define o layout
            conteudo.findAll(/(?<=#).*?\n/).collect {
                it = it[0..-2]
                it.tokenize('|')
            }.each {
                def key = it[0]
                it[0] = 'tipo'
                tiposDeRegistros[key] = it
            }

// Pegamos os registros, definimos um mapa onde preenchemos as Keys com
            def valoresDoRegistro = conteudo.split('\n').findAll {
                it.matches('^[^#]+$')
            }.collect {
                it = it.tokenize('|')
                def mapaRetorno = [:]
                def keys = tiposDeRegistros[it[0]]

                it.eachWithIndex { item, idx ->
                    mapaRetorno[keys[idx]] = item
                }
                mapaRetorno
            }



            return valoresDoRegistro
        }
        throw new IllegalArgumentException()
    }
}
