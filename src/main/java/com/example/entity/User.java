package com.example.entity;
import java.io.Serializable;

import javax.persistence.*;

@Entity
    @Table(name = "t_user")
    public class User implements Serializable{
        private static final long serialVersionUID = -6933265249358475103L;
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demo_emp_seq")
        @SequenceGenerator(name="demo_emp_seq", sequenceName="T_User_ID",allocationSize = 1)
        private Integer id;
        private String name;
        private int age;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

    }
