package org.example.Client.Model;

import org.example.Client.View.View;

public abstract class AbstractModel {
  protected View view;

  public void setView(View view){
    this.view = view;
  }
}
