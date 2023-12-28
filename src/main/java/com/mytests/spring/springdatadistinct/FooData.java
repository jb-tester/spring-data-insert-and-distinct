package com.mytests.spring.springdatadistinct;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

// no syntax highlighting for 'insert into' here: https://youtrack.jetbrains.com/issue/IDEA-318718
@Entity
@NamedQuery(name = "myInsertQuery", query = "insert into FooData(id,str,number) select d.id, 'updated_' || d.firststr, :arg2 + d.num2 from MyData d where d.num2 = :arg1  ")
public class FooData {
    @Id
    private Integer id;
    String str;
    int number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FooData{" +
               "id=" + id +
               ", str='" + str + '\'' +
               ", number=" + number +
               '}';
    }
}
