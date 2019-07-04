package org.n52.vaadin.minimal.grid;

import org.n52.vaadin.minimal.data.Customer;
import org.n52.vaadin.minimal.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.Grid.SelectionMode;

@Theme("valo")
@SpringUI(path = "/grid")
public class GridSelectionView extends UI  {

    private static final long serialVersionUID = 3771831685835764334L;

    private final CustomerRepository customers;    
    
    private Grid<Customer> grid;
    
    @Autowired
    public GridSelectionView(CustomerRepository customers) {
        this.customers = customers;
    }
    
    @Override
    protected void init(VaadinRequest request) {
        this.grid = new Grid<>(Customer.class);
        this.grid.setSelectionMode(SelectionMode.MULTI);
        this.grid.setItems(customers.findAll());
        setContent(grid);
    }
}
