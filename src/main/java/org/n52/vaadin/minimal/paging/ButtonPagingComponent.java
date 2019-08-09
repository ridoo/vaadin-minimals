package org.n52.vaadin.minimal.paging;

import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

public class ButtonPagingComponent extends PagingComponent {

    private static final long serialVersionUID = -6335727329820886591L;

    public ButtonPagingComponent(List<? extends Component> components) {
        super(components);
    }

    @Override
    protected Component createNavigation() {
        HorizontalLayout hl = new HorizontalLayout();
        hl.addComponent(createNavigationButton("Back", e -> previous()));
        hl.addComponent(createNavigationButton("Next", e -> next()));
        return hl;
    }

    private Button createNavigationButton(String label, ClickListener clickListener) {
        Button button = new Button(label);
        button.addClickListener(clickListener);
        return button;
    }

}
