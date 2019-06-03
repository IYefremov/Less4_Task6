//Create a class and demonstrate proper encapsulation techniques
//        the class will be called Printer
//        It will simulate a real Computer printer
//        It should have fields for toner level, number of pages printed, and also
//        whether its a duplex printer (capable of printing on both sides of the paper).
//        Add methods to fill up the toner (up to a maximum of 100%), another method to
//        simulate printing a page(which should increase the number of pages printed).
//        Decide on the scope, whether to use constructors, and anything else you think is needed.
//Example of fields:
//private String manufacturer;
//private String model;
//private boolean isColor;
//private String type;
//private boolean isDuplex;
//private int tonerLevelBlack;
//private int tonerLevelMagenta;
//private int tonerLevelYellow;
//private int tonerLevelBlue;
//private int printedPages;
//        Example of methods:
//        fillUp(int tonerVolume, String color);
//        print(int pages, String color, boolean isDuplex);
//        tonerIsEmpty();
//        getTonerLevel(String toner);
//        etc.

package com.less4task6Package;

public class Main {
    public static void main(String[] args) {


        // создаем объект принтер
        Printer printer = new Printer("Epson", "12he4", "Color", "ink");

        // выводим на экран параметры принтера
        printer.showPrinter();

        // устанавливаем расход краски на страницу печати
        printer.setInkPerPage(0.01f);

        // Узнаем ресурс печати принтера в страницах
        System.out.println("The printer resourse is: " + printer.printerResource(printer.getInkPerPage()) +" pages");

        // Заправляем принтер
        printer.inkFilling();

        // Узнаем ресурс печати принтера в страницах
        System.out.println("The printer resourse is: " + printer.printerResource(printer.getInkPerPage()) +" pages");

        // Эмулируем печать. Задаем количество страниц и устанавливаем флаг дуплексной печати
        printer.printPages(4, true);
        printer.printPages(2, false);
        printer.printPages(13, false);
        printer.printPages(2, false);
        printer.printPages(41, true);
        printer.printPages(3, true);
        printer.printPages(85, true);

        // заправляем принтер
        printer.inkFilling();
        // Узнаем ресурс печати принтера в страницах
        System.out.println("The printer resourse is: " + printer.printerResource(printer.getInkPerPage()) +" pages");

        // Эмулируем печать. Задаем количество страниц и устанавливаем флаг дуплексной печати
        printer.printPages(18, true);
        printer.printPages(2, false);
        printer.printPages(13, false);


        // узнаем сколько принтер напечатал всего страниц
        System.out.println("Total printer printed " + printer.getAllPages() + " pages");

    }
}
