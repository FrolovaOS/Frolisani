package com.example.Recipes.screens;

public class Product_class {
  private int id;
  private String name;
  private int IsExit;
  private int position;

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public int getIsExit() {
    return IsExit;
  }

  public void setIsExit(int isExit) {
    IsExit = isExit;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
