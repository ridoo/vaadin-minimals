
package org.n52.vaadin.minimal.tree;

import com.vaadin.annotations.Theme;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;

@Theme("valo")
//@Theme("reindeer")
@SpringUI(path = "/tree")
public class TreeView extends UI {
    
    private static final long serialVersionUID = 115863691972771953L;

    @Override
    protected void init(VaadinRequest request) {

        Tree<String> tree = new Tree<>();
        TreeData<String> treeData = new TreeData<>();

        // Couple of childless root items
        treeData.addItem(null, "Mercury");
        treeData.addItem(null, "Venus");

        // Items with hierarchy
        treeData.addItem(null, "Earth");
        treeData.addItem("Earth", "The Moon");

        TreeDataProvider<String> inMemoryDataProvider = new TreeDataProvider<>(treeData);
        tree.setDataProvider(inMemoryDataProvider);
        tree.expand("Earth"); // Expand programmatically

        treeData.addItem(null, "Mars");
        treeData.addItem("Mars", "Phobos");
        treeData.addItem("Mars", "Deimos");
        inMemoryDataProvider.refreshAll();

        setContent(tree);
        
    }
}
