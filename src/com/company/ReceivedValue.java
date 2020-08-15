package com.company;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Класс получает курс из конфига и содержит методы конвертации

public class ReceivedValue {


    //Конвертация в рубли

   public static double toRubles (double value){

        double output;



        return output = value * getDollarsCurse();
   }

   //Конвертация в долара

   public static double  toDollars (double value){

       double output;



       return output = value / getDollarsCurse();


   }


    // Получаем значение из конфиг файла
  public static double getDollarsCurse() {

       double n = 0;

       try {

           Properties properties = new Properties();
           FileInputStream inputStream = new FileInputStream("Config.properties");
           properties.load(inputStream);

           return n = Double.parseDouble(properties.getProperty("RubleExchangeRate"));

       } catch (IOException e) {
           e.printStackTrace();
       }

      return n;



  }



}
