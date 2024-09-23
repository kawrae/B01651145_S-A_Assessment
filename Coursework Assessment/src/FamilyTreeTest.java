public class FamilyTreeTest {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree("James", "Mary");
        familyTree.addChild("James", "John");
        familyTree.addChild("James", "Amy");
        familyTree.addChild("James", "Alan");

        familyTree.addPartner("John", "Alice");
        familyTree.addPartner("Alan", "Emily");

        System.out.println("Displaying whole family:");
        familyTree.displayFamily();

        System.out.println("Displaying specific family member:");
        familyTree.displayFamilyMember("Amy");
    }
}