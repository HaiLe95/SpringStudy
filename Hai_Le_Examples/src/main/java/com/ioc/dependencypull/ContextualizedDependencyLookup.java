package com.ioc.dependencypull;

import com.ioc.dependencypull.interfaces.Container;
import com.ioc.dependencypull.interfaces.ManagedComponent;

public class ContextualizedDependencyLookup implements ManagedComponent {
    private Dependency dependency;

    @Override
    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency("myDependency");
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
