package java_1;

import java.util.Scanner;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	
	public boolean juerTime(){
		if(this.hour>23||this.hour<-1) {
			System.out.println("һ��ֻ��24Сʱ");
			return false ;
		}
		if(this.minute>59||this.minute<0){
			System.out.println("һ��Сʱֻ��60����");
			return false;
		}
		if(this.second>59||this.second<0) {
			System.out.println("һ����ֻ��60��");
			return false;
		}
		return true;
	}
	public void inputTime(int hour,int minute,int second) {
		this.hour=hour;
		this.minute=minute;
		this.second=second;
		
	}
	public void printTime() {
		if(!(juerTime())) {
			System.out.println("��������ȷ��ʱ��");
			return;
		}
		System.out.printf("ʱ�䣺%02d:%02d:%02d %n",this.hour,this.minute,this.second);
		
	}
	
	public Time immutableAfter(int seconds) {
		if(seconds<0) {
			System.err.println("������Ϸ���ʱ��");
			return null;
		}
		Time m=new Time();
		m.hour=this.hour;
		m.minute=this.minute;
		m.second=this.second;
		
		while(seconds+m.second>59) {
			seconds-=60;
			m.minute++;
			if(m.minute>59) {
				m.minute=0;
				m.hour++;
				if(m.hour>23) {
					m.hour=0;
				}
			}
		}
		m.second+=seconds;
		
		return m;
	}
	public Time immutableAfter(int hours, int minutes, int seconds) {
		if(hours<0||minutes<0||seconds<0) {
			System.err.println("������Ϸ���ʱ��");
			return null;
		}
		int second_s=seconds+(minutes*60)+(hours*60*60);
		System.out.println(second_s);
		return immutableAfter(second_s);
	}
	
	public static int diff(Time a, Time b) {
		if(a.equals(b)) {
			return 0;
		}
		int second_a=a.hour*3600+a.minute*60+a.second;
		int second_b=b.hour*3600+b.minute*60+b.second;
		return second_b-second_a;
		
	}
	public static void main(String[] args) {
		/*Time t=new Time();
		Scanner scanner=new Scanner(System.in);
		System.out.println("����������ʱ���֣���");
		t.inputTime(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		t.printTime();
		Time e=new Time();
		System.out.println("���������Ŀ��ʱ���ʱ���֣���");
		e=t.immutableAfter(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()) ;
		e.printTime();
		t.printTime();*/
		Time a=new Time();
		Time b=new Time();
		Scanner scanner=new Scanner(System.in);
		System.out.println("����������aʱ���֣���");
		a.inputTime(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		System.out.println("����������bʱ���֣���");
		b.inputTime(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		System.out.println("���"+diff(a,b)+"��");
		
	}

}
