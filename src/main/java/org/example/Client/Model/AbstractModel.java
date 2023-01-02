package org.example.Client.Model;

import org.example.Client.View.View;

  /**
   * Abstract model
   */
  public abstract class AbstractModel {

  /**
   * view
   */
    protected View view;

  /**
   * setter for view
   * @param view view
   */
  public void setView(View view){
      this.view = view;
    }
  }
