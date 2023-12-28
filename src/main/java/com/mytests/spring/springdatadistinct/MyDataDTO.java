package com.mytests.spring.springdatadistinct;


public class MyDataDTO {

    String f1;
    String f2;
    int n1;
    int n2;

    public MyDataDTO(int n1, int n2, String f1, String f2) {
        this.f1 = f1;
        this.f2 = f2;
        this.n1 = n1;
        this.n2 = n2;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    @Override
    public String toString() {
        return "MyDataDTO{" +
                "f1='" + f1 + '\'' +
                ", f2='" + f2 + '\'' +
                ", n1=" + n1 +
                ", n2=" + n2 +
                '}';
    }
}
