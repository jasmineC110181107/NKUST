public class game {
      public static void main(String[] args) {

      //System.out.println("Archer");
      Person  Archer = new Archer( "Archer",15,30, 10);
      Archer.getCurrentStatus();

      //System.out.println("Berserker");
      Person  Berserker = new Berserker("Berserker",20,15,10);
      Berserker.getCurrentStatus();

      //System.out.println("magician");
      Person  magician = new magician("magician",15,30,10);
      magician.getCurrentStatus();
      }
}
