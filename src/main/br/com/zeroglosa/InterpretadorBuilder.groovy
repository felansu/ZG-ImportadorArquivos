package br.com.zeroglosa

/**
 * Created by felansu on 6/18/15.
 */
class InterpretadorBuilder {
    Interpretador build(String layout) {
        if (layout?.equals("fibo-layout")) {
            return new InterpretadorFiboLayout()
        }
        throw new IllegalArgumentException()
    }
}