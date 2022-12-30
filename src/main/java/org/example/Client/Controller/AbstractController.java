package org.example.Client.Controller;

import org.example.Client.Model.AbstractModel;
import org.example.Client.View.View;

public abstract class AbstractController {

  protected View view;

  protected AbstractModel model;

  public void setView(View view){
    this.view = view;
  }

  public void setModel(AbstractModel model){
    this.model = model;
  }
}
