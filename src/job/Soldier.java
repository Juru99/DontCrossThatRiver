package job;

public class Soldier extends Job{

   public Soldier() {
      super.setMoney(700000);
   }
   public void Shovel() {
      int a=super.getMoney();
      a=a+500000;
      super.setMoney(a);
      System.out.println(a);
   }
}