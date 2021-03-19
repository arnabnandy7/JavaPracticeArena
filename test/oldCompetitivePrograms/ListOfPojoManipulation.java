package test.oldCompetitivePrograms;

import java.util.ArrayList;
import java.util.List;

public class ListOfPojoManipulation {
	private int eid;
	private String ename;
	private double esalary;

	public static void main(String[] args) {
		List<ListOfPojoManipulation> objArr = new ArrayList<ListOfPojoManipulation>();

		ListOfPojoManipulation obj1 = new ListOfPojoManipulation(1, "ABC", 50);
		objArr.add(obj1);
		ListOfPojoManipulation obj2 = new ListOfPojoManipulation(2, "XYZ", 100);
		objArr.add(obj2);
		System.out.println(objArr);

		for (int i = 0; i < objArr.size(); i++) {
			ListOfPojoManipulation tempPojo = objArr.get(i);
			if(tempPojo.getEid()==1){
				tempPojo.setEsalary(200);
			}
			objArr.set(i, tempPojo);
		}
		System.out.println(objArr);

	}

	public ListOfPojoManipulation(int eid, String ename, double esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
	}

	public ListOfPojoManipulation() {
		this.eid = 0;
		this.ename = "";
		this.esalary = 0;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	@Override
	public String toString() {
		return "ListOfPojoManipulation [eid=" + eid + ", ename=" + ename
				+ ", esalary=" + esalary + "]";
	}

}
