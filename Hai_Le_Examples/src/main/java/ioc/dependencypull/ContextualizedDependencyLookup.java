package ioc.dependencypull;

import ioc.dependencypull.interfaces.Container;
import ioc.dependencypull.interfaces.ManagedComponent;

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
