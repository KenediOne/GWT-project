package com.gwt.gwt.client.ui.application.shell.content.statusbar;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.gwt.gwt.client.GWTContext;
import com.gwt.gwt.client.event.StatusChangeEvent;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import org.gwtproject.event.shared.HandlerRegistration;

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
@Controller(
    route = "/application/",
    selector = "footer",
    componentInterface = IStatusbarComponent.class,
    component = StatusbarComponent.class
)
public class StatusbarController extends AbstractComponentController<GWTContext, IStatusbarComponent, HTMLElement> implements IStatusbarComponent.Controller {
  private HandlerRegistration registration;

  public StatusbarController() {
  }

  @Override
  public void start() {
    this.registration = this.eventBus.addHandler(StatusChangeEvent.TYPE, e -> component.edit(e.getStatus()));
  }

  @Override
  public void stop() {
    this.registration.removeHandler();
  }
}
