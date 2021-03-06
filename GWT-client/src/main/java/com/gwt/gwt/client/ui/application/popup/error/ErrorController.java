package com.gwt.gwt.client.ui.application.popup.error;

import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponentController;
import com.github.nalukit.nalu.client.component.annotation.ErrorPopUpController;
import com.gwt.gwt.client.GWTContext;
import java.lang.Override;

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
@ErrorPopUpController(
    componentInterface = IErrorComponent.class,
    component = ErrorComponent.class
)
public class ErrorController extends AbstractErrorPopUpComponentController<GWTContext, IErrorComponent> implements IErrorComponent.Controller {
  public ErrorController() {
  }

  @Override
  public void onBeforeShow() {
    this.component.clear();
  }

  @Override
  public void show() {
    this.component.edit(this.errorEventType, this.route, this.message, this.dataStore);
    this.component.show();
  }

  @Override
  public void doRouteHome() {
    this.router.route("/application/GWT");
  }
}
