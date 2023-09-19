package dptr;

import job.*;
import saveFile.ShowStream;

public class Ability {
	
	public void GoAbility() { 
		new ShowStream();
			if(saveFile.OutStream.inline[0].equals("CollegeStudent")) {
				((CollegeStudent) dptr.JobScreen.Player).scholarship();
				dptr.JobScreen.pmoney=((CollegeStudent)dptr.JobScreen.Player).getMoney();
			}
			if(saveFile.OutStream.inline[0].equals("HighStudent")) {
				((HighStudent)dptr.JobScreen.Player).PartTimeJob();
				dptr.JobScreen.pmoney=((HighStudent)dptr.JobScreen.Player).getMoney();
			}
			if(saveFile.OutStream.inline[0].equals("Professor")) {
				((Professor)dptr.JobScreen.Player).NobelPrize();
				dptr.JobScreen.pmoney=((Professor)dptr.JobScreen.Player).getMoney();
			}
			if(saveFile.OutStream.inline[0].equals("ChickenBoss")) {
				((ChickenBoss)dptr.JobScreen.Player).SuwonKingGalbi();;
				dptr.JobScreen.pmoney=((ChickenBoss)dptr.JobScreen.Player).getMoney();
			}
			if(saveFile.OutStream.inline[0].equals("Homeless")) {
				System.out.println("????? ?????????");
			}
			if(saveFile.OutStream.inline[0].equals("Landlord")) {
				((Landlord)dptr.JobScreen.Player).NopainGetmoney();
				dptr.JobScreen.pmoney=((Landlord)dptr.JobScreen.Player).getMoney();
			}
			if(saveFile.OutStream.inline[0].equals("Thief")) {
				//dptr.JobScreen.Player=new Thief();
				((Thief)dptr.JobScreen.Player).Lupine();
				dptr.JobScreen.pmoney=((Thief)dptr.JobScreen.Player).getMoney();
			}
			if(saveFile.OutStream.inline[0].equals("Soldier")) {
				//dptr.JobScreen.Player=new Soldier();
				((Soldier)dptr.JobScreen.Player).Shovel();
				dptr.JobScreen.pmoney=((Soldier)dptr.JobScreen.Player).getMoney();
			}
		
		
		
	}
	
	
	
}
