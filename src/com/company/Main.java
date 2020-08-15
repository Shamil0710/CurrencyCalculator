
package com.company;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  {



//        System.out.println(CurrencyCalculator.toRPN("2+2-2"));

//        String inputStream = "toDollars(737р + toRubles($85,4))";
//
//       inputStream = inputStream.replace(" ", "");
//
//        System.out.println(inputStream);
//
//
//
//
//        //С помощью Стринг Токенайзера делим строку на на токены, знаки разделители становятся отдельным токеном
//        StringTokenizer stringTokenizer = new StringTokenizer( " toDollars(737р + toRubles($85,4)) ", " ()+-", true);
//
//
//

        for (String in: CurrencyCalculator.toRPN("toDollars(737р + toRubles($85,4))")) {

            System.out.println(in);

        }



        }


    }

