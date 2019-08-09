
package org.n52.vaadin.minimal.paging;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Theme("valo")
@SpringUI(path = "/paging")
public class PagingView extends UI {

    private static final long serialVersionUID = 2725597505023009531L;

    @Override
    protected void init(VaadinRequest request) {
        setContent(new ButtonPagingComponent(Stream.of("Nothing", "First", "Second", "Third")
                                                   .map(Label::new)
                                                   .map(HorizontalLayout::new)
                                                   .collect(Collectors.toList())));
    }
}
