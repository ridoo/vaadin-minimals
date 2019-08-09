
package org.n52.vaadin.minimal.paging;

import java.util.Collections;
import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public abstract class PagingComponent extends CustomComponent {

    private static final long serialVersionUID = -3586532522863590591L;

    private final List<? extends Component> components;

    private final Panel content;

    private int currentPosition;

    public PagingComponent(List<? extends Component> components) {
        this(components, 0);
    }
    
    public PagingComponent(List<? extends Component> components, int currentPosition) {
        this.currentPosition = currentPosition;
        this.components = components == null
                ? Collections.emptyList()
                : components;
        this.content = new Panel();
        
        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(this.content);
        vl.addComponent(createNavigation());
        setCompositionRoot(vl);
        showCurrentComponent();
    }

    protected abstract Component createNavigation();

    public void next() {
        currentPosition++;
        if (currentPosition < components.size()) {
            showCurrentComponent();
        } else {
            currentPosition = 0;
            showCurrentComponent();
        }
    }

    public void previous() {
        currentPosition--;
        if (currentPosition >= 0) {
            showCurrentComponent();
        } else {
            currentPosition = components.size() - 1;
            showCurrentComponent();
        }
    }

    private void showCurrentComponent() {
        if (currentPosition >= 0 && currentPosition < components.size()) {
            content.setContent(components.get(currentPosition));
        }
    }
}
