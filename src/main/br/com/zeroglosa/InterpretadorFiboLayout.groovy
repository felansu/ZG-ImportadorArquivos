package br.com.zeroglosa

import java.util.regex.Pattern

/**
 * Created by felansu on 6/18/15.
 */
class InterpretadorFiboLayout implements Interpretador {

    private final String CABECALHO = /(?<=#).*/
    private final String VALOR = /^[^#].+$/

    private Map<String, List<String>> obtenhaTiposDeRegistro(List<List<String>> cabecalhoTokenized) {
        Map<String, List<String>> tiposDeRegistros = [:]
        cabecalhoTokenized.each {
            def key = it[0]
            it[0] = 'tipo'
            tiposDeRegistros[key] = it
        }
        tiposDeRegistros
    }

    private List<List<String>> filtraConteudo(String conteudo, String regex) {
        conteudo.readLines().collect{
            it.find(regex)
        }.grep().collect{ it.split(/\|/) }
    }

    private List<Map<String, String>> criaMapaDeRegistros(List<List<String>> valores, Map<String, List<String>> tiposDeRegistro) {
        valores.collect { valor ->
            def mapaRetorno = [:]
            def keys = tiposDeRegistro[valor[0]]
            keys.eachWithIndex { item, idx ->
                mapaRetorno[item] =  valor[idx]
            }
            mapaRetorno
        }
    }

    @Override
    List<Map> getRegistros(String conteudo) {
        if (conteudo) {
            List<List<String>> cabecalho = filtraConteudo(conteudo, CABECALHO)
            List<List<String>> valores = filtraConteudo(conteudo, VALOR)
            criaMapaDeRegistros(valores, obtenhaTiposDeRegistro(cabecalho))
        } else {
            throw new IllegalArgumentException()
        }
    }
}
