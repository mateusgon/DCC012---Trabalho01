package ordenacao;

import model.Resultado;

public class MergeSort {

    public void ordena(Integer vetor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        mergeSortInteiro(vetor, 0, vetor.length - 1, resultado);
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

    public void mergeSortInteiro(Integer vetor[], Integer limiteInferior, Integer limiteSuperior, Resultado resultado) {
        if (limiteInferior < limiteSuperior) {
            Integer meio = ((limiteInferior + limiteSuperior) / 2);
            mergeSortInteiro(vetor, limiteInferior, meio, resultado);
            mergeSortInteiro(vetor, meio + 1, limiteSuperior, resultado);
            merge(vetor, limiteInferior, meio, limiteSuperior, resultado);
        } else {
            return;
        }
    }

    public void merge(Integer vetor[], Integer limiteInferior, Integer meio, Integer limiteSuperior, Resultado resultado) {

        Integer vetorAuxiliar[] = new Integer[vetor.length];
        Integer limiteInferiorAux = limiteInferior;
        Integer meioAux = meio + 1;
        Integer contador = limiteInferior;

        do {
            if (vetor[limiteInferiorAux] < vetor[meioAux]) {
                vetorAuxiliar[contador] = vetor[limiteInferiorAux];
                limiteInferiorAux++;
            } else {
                vetorAuxiliar[contador] = vetor[meioAux];
                meioAux++;
            }
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            contador++;
        } while (limiteInferiorAux <= meio && meioAux <= limiteSuperior);

        do {
            vetorAuxiliar[contador] = vetor[limiteInferiorAux];
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            limiteInferiorAux++;
            contador++;
        } while (limiteInferiorAux <= meio);

        do {
            vetorAuxiliar[contador] = vetor[meioAux];
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            meioAux++;
            contador++;
        } while (meioAux <= limiteSuperior);

        contador = limiteInferiorAux;
        while (contador < limiteSuperior) {
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            vetor[contador] = vetorAuxiliar[contador - limiteInferior];
            contador++;
        }
    }
}
