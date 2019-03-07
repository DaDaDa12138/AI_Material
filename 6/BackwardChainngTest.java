import java.util.*;
public class BackwardChainngTest {

	public static int find(String[] source,String goal){
		int pos = 0;
		for(pos=0;pos<source.length;pos++){
			if(source[pos].equals(goal))
				break;
		}
		return pos;
	}
	
	public static boolean backwardChining(String[] str,String[] facts){
		ArrayList<Boolean> ret = new ArrayList<Boolean>();
		for(int i=0;i<str.length;i++){
			if(IsInFacts(str[i],facts))
				ret.add(true);
		}
		return true;
		
		//will do and operation
	}
	
	public static boolean IsInFacts(String str,String[] facts){
		if(facts.equals(str))
			return true;
		else
			return false;
	}
	
	public static void main(String args[]){
		
		String[][][] rules = {{{"Hair","Milk"}},{{"Feather"},{"Fly","LayEgg"}},
				{{"Mammal","EatMeat","Mammal","PointedTooth","Claw","ForwardPointingEye"}},
				{{"Mammal","Hoof"},{"Mammal","ChewCud"}},{{"Carnivore","TawnyColor","DarkSpot"}},
				{{"Carnivore","TawnyColor","Blackstrip"}},{{"Ungulate","LongLeg","LongNeck","TawnyColor","DarkSpot"}},
				{{"Ungulate","WhiteColor","BlackStrip"}},
				{{"Bird","NotFly","LongNeck","LongLeg","BlackColor","WhiteColor"}},
				{{"Bird","NotFly","Swim","BlackColor","WhiteColor"}},{{"Bird","FlyWell"}}};
		
		String[] animals = {"Mammal","Bird","Carnivore","Ungulate","Cheetah","Tiger","Giraffe",
				"Zebra","Ostrich","Penguin","Albatross"};
		int animal_number = animals.length;
		
		String[] facts = {"Hair","ChewCud","LongLeg","LongNeck","TawnyColor","DarkSpot"};
		String goal = "Zebra";
		
		for(int i=0;i<rules.length;i++){
			System.out.print(animals[i]+" ");
			for(int j=0;j<rules[i].length;j++)
				for(int k=0;k<rules[i][j].length;k++)
					System.out.print(rules[i][j][k]+" ");
			System.out.println("\n");
		}

		int pos = find(animals,"Zebra");
		for(int i=0;i<rules[pos].length;i++)
			for(int k=0;k<rules[pos][i].length;k++)
				System.out.println(rules[pos][i][k]);
		
		boolean[] decision = new boolean[rules[pos].length];
		for(int i=0;i<rules[pos].length;i++){
//			for(int j=0;j<rules[pos][i].length;j++)
			decision[i] = backwardChining(rules[pos][i],facts);
		}
		//will do or operation
	}
}
