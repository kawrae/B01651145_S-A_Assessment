class FamilyTree {
    private FamilyTreeNode ancestor;

    public FamilyTree(String ancestorName, String partnerName) {
        this.ancestor = new FamilyTreeNode(ancestorName);
        if (partnerName != null && !partnerName.isEmpty()) {
            this.ancestor.setPartner(new FamilyTreeNode(partnerName));
            this.ancestor.getPartner().setPartner(this.ancestor);
        } else {
            System.out.println("Warning: Ancestor has no partner.");
        }
    }

    public void addChild(String parentName, String childName) {
        FamilyTreeNode parent = findFamilyMember(parentName);
        if (parent != null && parent.getPartner() != null) {
            FamilyTreeNode newChild = new FamilyTreeNode(childName);
            FamilyTreeNode currentChild = parent.getChild();
            if (currentChild == null) {
                parent.setChild(newChild);
            } else {
                while (currentChild.getSibling() != null) {
                    currentChild = currentChild.getSibling();
                }
                currentChild.setSibling(newChild);
            }
        } else {
            System.out.println("Error: Cannot add child. Parent does not have a partner.");
        }
    }

    public void addPartner(String familyMemberName, String partnerName) {
        FamilyTreeNode familyMember = findFamilyMember(familyMemberName);
        if (familyMember != null && familyMember.getPartner() == null) {
            FamilyTreeNode partner = new FamilyTreeNode(partnerName);
            familyMember.setPartner(partner);
            partner.setPartner(familyMember);
        } else {
            System.out.println("Error: Cannot add partner. Family member does not exist or already has a partner.");
        }
    }

    public void displayFamily() {
        displayFamilyMember(ancestor);
    }

    public void displayFamilyMember(String memberName) {
        FamilyTreeNode familyMember = findFamilyMember(memberName);
        if (familyMember != null) {
            displayFamilyMember(familyMember);
        } else {
            System.out.println("Error: No match found for the given identifier.");
        }
    }

    private void displayFamilyMember(FamilyTreeNode member) {
        if (member != null) {
            System.out.println(member.getName() + " (identifier " + member.getIdentifier() + ") partner " +
                    (member.getPartner() != null ? member.getPartner().getName() + " (identifier " + member.getPartner().getIdentifier() + ")" : "none"));
            System.out.println("Children:");
            displayChildren(member.getChild());
            System.out.println();
        }
    }

    private void displayChildren(FamilyTreeNode child) {
        if (child != null) {
            System.out.println("- " + child.getName() + " (identifier " + child.getIdentifier() + ")");
            displayChildren(child.getSibling());
        }
    }

    private FamilyTreeNode findFamilyMember(String name) {
        return findFamilyMember(ancestor, name);
    }

    private FamilyTreeNode findFamilyMember(FamilyTreeNode current, String name) {
        if (current == null) {
            return null;
        }
        if (current.getName().equalsIgnoreCase(name)) {
            return current;
        }
        FamilyTreeNode foundInChild = findFamilyMember(current.getChild(), name);
        if (foundInChild != null) {
            return foundInChild;
        }
        return findFamilyMember(current.getSibling(), name);
    }
}