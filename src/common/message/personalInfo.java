package common.message;

import java.io.Serializable;

// ����ģ���personalInfo��д��ϣ�27-mar-14
/**
 * public String qq ="";
	public String nickname ="";
	public String sex="";
	public int age=0;
	public String bri_year="";
	public String bri_month="";
	public String bri_day="";
	public String zodiacsign="";
	public String constellation ="";
	public String bloodtype="";
	public String country="";
	public String province="";
	public String city="";
	public int headimage=0;
	public int status=0;
	public String phoneNumber="";
	public String occupation="";
	public String mailaddress="";
	
	public String password=""; //passwordϵ���ݿ����治����һ��Ͳ�������
 * 
 * */
public class personalInfo implements Serializable // ��������
{
	/*
	 * ��֪�����ٸ�����
	 * */
	private static final long serialVersionUID = 1L; //���ϰ汾����
	public String qq ="";
	public String nickname ="";
	public String sex="";
	public int age=0;
	public String bri_year="";
	public String bri_month="";
	public String bri_day="";
	public String zodiacsign="";
	public String constellation ="";
	public String bloodtype="";
	public String country="";
	public String province="";
	public String city="";
	public int headimage=0;
	public int status=0;
	public String phoneNumber="";
	public String occupation="";
	public String mailaddress="";
	
	public String password=""; //passwordϵ���ݿ����治����һ��Ͳ�������
	
	//����������������ܣ�����ʱ�ı���δ���ã���ʱ������
	
	public personalInfo(String password,String nickname,String sex,
			int age,String bri_year,String bri_month,String bri_day,
			String zodiacsign,String constellation,String bloodtype,
			String province,String city)
	{
		// ����ʱ��
		super();
		this.password = password;
		this.nickname=nickname;
		this.sex=sex;
		this.age=age;
		this.bri_year=bri_year;
		this.bri_month = bri_month;
		this.bri_day = bri_day;
		this.zodiacsign = zodiacsign;
		this.constellation = constellation;
		this.bloodtype = bloodtype;
		this.province = province;
		this.city= city;
		
	}
	
	public personalInfo(personalInfo personalInformation)
	{
		this.password = personalInformation.password;
		this.nickname=personalInformation.nickname;
		this.sex=personalInformation.sex;
		this.age=personalInformation.age;
		this.bri_year=personalInformation.bri_year;
		this.bri_month = personalInformation.bri_month;
		this.bri_day = personalInformation.bri_day;
		this.zodiacsign = personalInformation.zodiacsign;
		this.constellation = personalInformation.constellation;
		this.bloodtype = personalInformation.bloodtype;
		this.province = personalInformation.province;
		this.city= personalInformation.city;
		this.headimage=personalInformation.headimage;
		this.status=personalInformation.status;
		this.phoneNumber=personalInformation.phoneNumber;
		this.occupation=personalInformation.occupation;
		this.mailaddress=personalInformation.mailaddress;
	}
	
	public personalInfo()
	{
		super();
	}
	
	
	
	
	
}