import javax.xml.namespace.QName;

public class Person {

    int Hp; //data member
    int Att; //data member
    int Mp; //data member
    String name; //data member



    Person(String PersonName,int personHp, int personAtt, int personMp) {
          name = PersonName;
          Hp   = personHp;
          Mp   = personMp;
          Att  = personAtt;

    }

    void getCurrentStatus(){
        System.out.println("Name:" + name);
        System.out.println("Ap:" + Hp);
        System.out.println("Mp:" + Mp);
        System.out.println("Att:" + Att);
        System.out.println("______________________");
    }
}
