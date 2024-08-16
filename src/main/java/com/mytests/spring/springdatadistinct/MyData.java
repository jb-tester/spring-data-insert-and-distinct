package com.mytests.spring.springdatadistinct;

import jakarta.persistence.*;

@Entity
public class MyData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firststr;
    private String secondstr;
    private String thirdstr;
    private String fourthstr;
    private String fifthstr;
    private int num1;
    private int num2;
    private int num3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirststr() {
        return firststr;
    }

    public void setFirststr(String firststr) {
        this.firststr = firststr;
    }

    public String getSecondstr() {
        return secondstr;
    }

    public void setSecondstr(String secondstr) {
        this.secondstr = secondstr;
    }

    public String getThirdstr() {
        return thirdstr;
    }

    public void setThirdstr(String thirdstr) {
        this.thirdstr = thirdstr;
    }

    public String getFourthstr() {
        return fourthstr;
    }

    public void setFourthstr(String fourthstr) {
        this.fourthstr = fourthstr;
    }

    public String getFifthstr() {
        return fifthstr;
    }

    public void setFifthstr(String fifthstr) {
        this.fifthstr = fifthstr;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "id=" + id +
                ", firststr='" + firststr + '\'' +
                ", secondstr='" + secondstr + '\'' +
                ", thirdstr='" + thirdstr + '\'' +
                ", fourthstr='" + fourthstr + '\'' +
                ", fifthstr='" + fifthstr + '\'' +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", num3=" + num3 +
                '}';
    }
}
