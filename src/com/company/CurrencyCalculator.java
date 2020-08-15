package com.company;

/**
 * Алгоритм Дейкстры
 */


import java.util.Stack;
import java.util.StringTokenizer;

public class CurrencyCalculator {

    public static Stack<String> toRPN (String inputValue) {

        inputValue = inputValue.replace(" ", ""); //Удаляем пробелы из полученоё строки

        //** Служебные переменные **//


         Stack<String> stackRPN = new Stack<String>(); //Стак с оператоами todo Техас

         Stack<String> stackAnswer = new Stack<String>(); //Стак на выход todo Калифорния



        int priority; //Приоритет текущего элемента

        //** Разбивка полученных данных на токены **//

        inputValue.replace(" ", "");

        //С помощью Стринг Токенайзера делим строку на на токены, знаки разделители становятся отдельным токеном
        StringTokenizer stringTokenizer = new StringTokenizer(inputValue, "()+-", true);

//        while (stringTokenizer.hasMoreTokens()) {
//            inputStream.push(stringTokenizer.nextToken()); //Додобавляем все токены в наш стек
//        }
//
//        inputStream.removeIf(x -> x.equals(" ")); // Удаляем все пустые эелементы в стеке
//


        //** Преобразуем полученный стек в строку в формате Обратной Польской Записи попытка номер 100500**//

        //Пока в нашем токенайзере есть токены
        while (stringTokenizer.hasMoreTokens()) {
          String token = stringTokenizer.nextToken();

          //Число
          if (getPriority(token) == 0) stackAnswer.push(token);
          //Открывающая скобка
          if (getPriority(token) == 1) stackRPN.push(token);

          //+-
          if (getPriority(token) == 2) {

                  if (getPriority(stackRPN.peek()) == 2 || getPriority(stackRPN.peek()) == 3 || getPriority(stackRPN.peek()) == 0)
                      while (!stackRPN.empty()) {
                          if (getPriority(stackRPN.peek()) >= 2) stackAnswer.push(stackRPN.pop());
                         else break;

              }
              else if (getPriority(stackRPN.peek()) == 1) stackRPN.push(token);

          }

          //toRubles/toDollars по сути умножение деление

            if (getPriority(token) == 3) {

                if (stackRPN.empty()) stackRPN.push(token); //TODO хз

                if (getPriority(stackRPN.peek()) == 2 || getPriority(stackRPN.peek()) == 0 || getPriority(stackRPN.peek()) == 1)  stackRPN.push(token);


                else if (getPriority(stackRPN.peek()) == 3) {
                    while (!stackRPN.empty()) {
                        if (getPriority(stackRPN.peek()) == 3) stackAnswer.push(stackRPN.pop());
                        else break;
                    }
                }


            }

            //Закрывающая скобка

            if (getPriority(token) == -1) {
                while (getPriority(stackRPN.peek()) != 1) {
                    stackAnswer.push(stackRPN.pop());
                }

                stackRPN.pop();
            }





        }




        return stackAnswer; // TODO: 14.08.2020 Заглушка
    }


    //Получение приоритета
    private static int getPriority (String token) {

       if(token.equalsIgnoreCase("toRubles") || token.equalsIgnoreCase("toDollars")) return 3;

       else if (token.equals("+") || token.equals("-") ) return 2;

       else if (token.equals("(")) return 1;

       else if (token.equals(")")) return -1;

       else return 0;

    }



    //подсчет и выдача финального результата
    public static String toCalculate (Stack<String> stackRPN) {

        String answer = "answer";



        return answer;

    }


}
