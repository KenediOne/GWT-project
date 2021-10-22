package com.gwt.gwt.client.ui.login.content.login;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.logging.client.LoggingPopup;
import com.google.gwt.user.client.ui.Widget;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.ModalDialog;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class LoginComponent extends AbstractComponent<ILoginComponent.Controller, HTMLElement> implements ILoginComponent {
  private TextBox intro;
  private FieldsGrouping fieldsGrouping;

  public LoginComponent() {
    super();
  }

  @Override
  public void render() {
    fieldsGrouping = FieldsGrouping.create();
    this.intro = TextBox.create("Enter number")
            .groupBy(fieldsGrouping);
    initElement(Card.create("Intro")
                            .appendChild(Row.create()
                                            .addColumn(Column.span12()
                                                             .appendChild(this.intro)))
                            .appendChild(Row.create()
                                            .setGap("10px")
                                            .addColumn(Column.span12()
                                                             .appendChild(Button.createPrimary("Enter")
                                                                                .setSize(ButtonSize.LARGE)
                                                                                .style()
                                                                                .setMinWidth("120px")
                                                                                .get()
                                                                                .addClickListener(e -> validation(intro.getValue()))))
                                            .style()
                                            .setTextAlign("right"))
                            .element());
  }
  private void validation(String data){
    if (data.length() == 0){
      DomGlobal.window.confirm("Please, enter a number in the range from 1 to 1000!");
    }else {
      int inputNumber = 0;
      try {
        inputNumber = Integer.parseInt(data);
        if(inputNumber <= 1000) {
          if(inputNumber > 0){
            getController().doLogin(inputNumber);
          }else {
            DomGlobal.window.confirm("Number is less than 1, please enter a number between 1 and 1000!");
          }
        }else {
          DomGlobal.window.confirm("The number is too large, please, enter a number between 1 and 1000!");
        }
      } catch (NumberFormatException e) {
        DomGlobal.window.confirm("You cannot enter text, please enter a number in the range from 1 to 1000!");
      }
    }
    //("You entered: "+this.intro);
  }
}
