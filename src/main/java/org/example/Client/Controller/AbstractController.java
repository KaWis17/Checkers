package org.example.Client.Controller;

import org.example.Client.Model.AbstractModel;
import org.example.Client.View.View;

/**
 * abstract controller class
 */
public abstract class AbstractController {

  /**
   * view
   */
  protected View view;

  /**
   * model
   */
  protected AbstractModel model;

  /**
   * setter for view
   * @param view view
   */
  public void setView(View view){
    this.view = view;
  }

  /**
   * setter for model
   * @param model model
   */
  public void setModel(AbstractModel model){
    this.model = model;
  }
}
