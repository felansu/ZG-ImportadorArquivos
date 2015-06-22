package br.com.zeroglosa

class TesteNumeroMaior extends GroovyTestCase{

    static int maiorNumero(List<Integer> numeros){
        numeros.sort { Integer a, Integer b ->
            b.toString()+a.toString() <=> a.toString()+b.toString()
        }.join("").toInteger()
    }

    void "test do Halisson"(){
        assertEquals 951213, maiorNumero([9,51,2,13])
    }

    void "test 1"() {
        assertEquals 987634521, maiorNumero([1,2,345,6,7,8,9])
    }

    void "test 2"() {
        assertEquals 998, maiorNumero([9,98])
    }

}
