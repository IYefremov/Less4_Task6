package com.less4task6Package;

public class Printer {

     private String manufacturer;
     private String model;
     private String isColor;
     private String type;

    private long allPages = 0;

    private float tonerLevelBlack;
    private float tonerLevelMagenta;
    private float tonerLevelYellow;
    private float tonerLevelBlue;

    private float inkPerPage;


    public long getAllPages() {
        return allPages;
    }

    public float getInkPerPage() {
        return inkPerPage;
    }

    public void setInkPerPage(float inkPerPage) {
        this.inkPerPage = inkPerPage;
    }

    public Printer(String manufacturer, String model,  String isColor, String type){
        this.manufacturer = manufacturer;
        this.model = model;
        this.isColor = isColor;
        this.type = type;
    }

    public void showPrinter(){
        System.out.println("Printer: " + this.manufacturer + " " + this.model + " " + this.isColor + " " + this.type);

    }

    public float printerResource (float inkPerPage){
        return this.tonerLevelBlack / inkPerPage;  // принимаем за данность, что все краски расходуются равномерно
    }

    public void inkFilling (){
        this.tonerLevelBlack = 1;
        this.tonerLevelMagenta = 1;
        this.tonerLevelYellow = 1;
        this.tonerLevelBlue = 1;
        System.out.println("Printer has been successfully filled in");
    }

    public void printPages (int pages, boolean isDuplex){
        int currentPage;
        int paperSheets = 0;

        for (currentPage = 0; currentPage < pages; currentPage++ ) {

            this.tonerLevelBlack -=  this.inkPerPage;
            this.tonerLevelMagenta -=  this.inkPerPage;
            this.tonerLevelYellow -=  this.inkPerPage;
            this.tonerLevelBlue -=  this.inkPerPage;

            if (this.tonerLevelBlack < 0 || this.tonerLevelMagenta < 0 || this.tonerLevelYellow < 0 || this.tonerLevelBlue < 0) {
                if (isDuplex){
                    paperSheets = (int) ((float)currentPage/2 + 0.5);
                }
                System.out.println("Sorry, printer can't print " + pages + " pages." + "The ink is out ");
                System.out.println("Printer printed " + currentPage + " pages" + " and used " + paperSheets + " sheets of paper" );
                System.out.println("Please, fill in the printer");
                this.allPages += currentPage;
                return;
            }
        }
        if (isDuplex){
            paperSheets = (int)((float)currentPage/2 + 0.5);
        } else paperSheets = currentPage;
        System.out.println("Printer printed " + currentPage + " pages and used " + paperSheets + " sheets of paper");
        this.allPages += currentPage;
    }

}
