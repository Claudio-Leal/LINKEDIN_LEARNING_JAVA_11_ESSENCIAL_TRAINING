/*
Nesta última versão, ao executar o debug, vi que o código todos os valores...
são passados para as classes "parceiras",...conforme os métodos vão sendo chamados.
Fazendo desta forma,..conseguimos imprimir na tela o conjunto de informações de...
// shirt e hat.
// Conceitos de subclasse (hat e shirt), superclasse (ClothingItem),...herança...
polimorfirmos, etc., foram mostrados aqui.
*/



package com.company;


import com.company.model.ClothingItem;
import com.company.model.ClothingSize;
import com.company.model.Hat;
import com.company.model.Shirt;

import java.text.NumberFormat;

public class Main {
    public static void main (String [] args) {

        // Através de REFACTOR > RENAME, renomeei a variável item para shirt,...conforme foi feito com hat.
        // Pelo que entendi, não impactou na variável item que está sendo declarada no método lá embaixo,...
        // justamente por isso: ela está sendo declarada com o tipo: ClothingItem
        var shirt = new Shirt (
                ClothingSize.G,
                3,
                19.45);
        displayItemDetails(shirt);

        var hat = new Hat(
                ClothingSize.M,
                2,
                21.60);
        displayItemDetails(hat);

        // quando utilizei REFACTOR > EXTRACT > METHOD, o método foi criado, englobando todos os...
        // comandos que estavam sendo utilizados anteriormente.
        // Abaixo, devidamente comentado,...a chamada do método, com a passagem do valor "item" no parámetro.
        // Coloquei a chamada mais acima, logo após cada chamada do método.
        // displayItemDetails(item);
    }

    // Aqui, o método que foi criado com REFACTOR > EXTRACT > METHOD.
    // Considerações:
    // private: não pode ser chamado de qualquer parte da aplicação, apenas da classe main.
    // static: pode ser acessado por contextos estáticos, como o que ocorre com shirt e hat,...
    // quanod chamam este método.
    // static void: preparado para retornar vazio (métodos possuem retorno, diferente de CONSTRUCTOR METHODS).
    // displayItemDetails: nome do método, conforme inserido no quadro REFACTOR > EXTRACT > METHOD.
    // Nos argumentos:
    // ClothingItem: classe que aqui funciona como tipo de dado.
    // item: variável declarada mais acima,...e que receberá os valores quando o método for chamado.
    // {}: todos os comandos já declarados previamente.
    // Variável item não está mais sendo declarada no início do código. Agora temos os itens (Shirt, Hat,...
    // sendo especificados no código.
    //
    private static void displayItemDetails(ClothingItem item) {
        var total = item.getPrice() * item.getQuantity();
        var formatNumber = NumberFormat.getCurrencyInstance();
        var output = String.format("Your %s size %s order will cust %s",
                item.getType(),
                item.getSize(),
                formatNumber.format(total));
        System.out.println(output);
    }
}
