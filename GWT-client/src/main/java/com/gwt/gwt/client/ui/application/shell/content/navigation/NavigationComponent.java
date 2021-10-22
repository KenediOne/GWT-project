package com.gwt.gwt.client.ui.application.shell.content.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

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
public class NavigationComponent extends AbstractComponent<INavigationComponent.Controller, HTMLElement> implements INavigationComponent {
  private TreeItem GWTItem;

  public NavigationComponent() {
    super();
  }

  @Override
  public void render() {
    this.GWTItem = TreeItem.create("GWT", Icons.ALL.list())
                    .addClickListener(e -> getController().doNavigateTo("GWT"));
    Tree tree = Tree.create("Navigation");
    tree.appendChild(GWTItem);
    initElement(tree.element());
  }
}
