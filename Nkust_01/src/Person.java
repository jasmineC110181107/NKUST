import javax.xml.namespace.QName;
public class Person {
    int Hp; //data member
    int Att; //data member
    int Mp; //data member
    String name; //data member
    String skill;
    Person(String PersonName,int personHp, int personAtt, int personMp ,String personskill) {
          name = PersonName;
          Hp   = personHp;
          Mp   = personMp;
          Att  = personAtt;
          skill = personskill;
    }
    void getCurrentStatus(){
        //System.out.println("Name:" + name);
        // System.out.println("Ap:" + Hp);
        //System.out.println("Mp:" + Mp);
        //System.out.println("Att:" + Att);
        //System.out.println("______________________");
        System.out.println(name+"{att:" + Att +"/hp:" +Hp+"/mp:" + Mp+"}skillname:" +skill);
    }
}
