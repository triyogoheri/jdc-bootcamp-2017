package com.agit.jdc.bootcamp.main.model.tree;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.TreeNode;

/**
 *
 * @author bayutridewanto
 */
public class BinaryPackageController extends SelectorComposer<Component> {
 
    private static final long serialVersionUID = 43014628867656917L;
     
    public TreeModel<TreeNode<PackageData>> getTreeModel() {
        return new DefaultTreeModel<PackageData>(PackageDataUtil.getRoot());
    }
}
