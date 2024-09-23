import java.util.HashMap;

class FamilyTreeNode {
    private static int idCounter = 1;
    private int identifier;
    private String name;
    private FamilyTreeNode partner;
    private FamilyTreeNode sibling;
    private FamilyTreeNode child;

    public FamilyTreeNode(String name) {
        this.identifier = idCounter++;
        this.name = name;
        this.partner = null;
        this.sibling = null;
        this.child = null;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public FamilyTreeNode getPartner() {
        return partner;
    }

    public FamilyTreeNode getSibling() {
        return sibling;
    }

    public FamilyTreeNode getChild() {
        return child;
    }

    public void setPartner(FamilyTreeNode partner) {
        this.partner = partner;
    }

    public void setSibling(FamilyTreeNode sibling) {
        this.sibling = sibling;
    }

    public void setChild(FamilyTreeNode child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return name;
    }
}

