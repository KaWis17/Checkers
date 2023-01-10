package org.example.Client.View;

import java.awt.event.ActionListener;

/**
 *
 */
public interface View {
  //AbstractModel model = null;

  /**
   *
   */
  void display();

  /**
   *
   * @param view
   */
  void addComponent(View view);

  /**
   *
   * @param listener
   */
  void addAction(ActionListener listener);

  /**
   *
   * @param view
   */
  void remove(View view);

  /**
   *
   * @param i
   * @return
   */
  View download(int i);
}
