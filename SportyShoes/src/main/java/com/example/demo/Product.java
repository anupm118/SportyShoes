package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int sNo;
private String productId;
private String productName;
}
