#include <iostream>

using namespace std;

double BMI(int ft, int inch, int pound);
float wido(int a, int b, int c);
void secToDay(long num);

int main()
{
//	int ft;
//	int inch;
//	int pound;
//	double result;
	
//	cout << "BMI ���"<<endl;
//	cout << "ft: ";
//	cin >> ft;
//	cout << "inch: ";
//	cin >> inch;
//	cout << "pound: ";
//	cin >> pound;
//	result = BMI(ft,inch,pound);
//	cout << result; 

//	double a, b, c; 
//
//	 cout << "������ ��, ��, �� ������ �Է��Ͻÿ�"<<endl;
//	 cout << "������ �Է��Ͻÿ�: ";
//	 cin >> a;
//	 cout << "�а��� �Է��Ͻÿ�: ";
//	 cin >> b;
//	 cout << "�ʰ��� �Է��Ͻÿ�: "; 
//	 cin >> c;
//	 cout.precision(4);
////	 cout << a<<"��, "<<b<<"��, "<<c<<"�� = "<<wido(a,b,c)<<endl;
//	 cout << a<<"��, "<<b<<"��, "<<c<<"�� = "<< double(a+((b+c/60)/60));
	
//	long num;
//	cout << "�� ���� �Է��ϼ���: ";
//	cin >> num;
//	cout << num << "�� = ";
//	secToDay(num);
	
	long long worldNum;
	long long USNum;
	cout << "���� �α� ���� �Է��Ͻÿ�: ";
	cin >> worldNum; 
	cout << "�̱� �α� ���� �Է��Ͻÿ�: ";
	cin >> USNum;
	cout << worldNum<<" "<<USNum<<endl;
	cout << "���� �α������� �̱��� �����ϴ� ������ "<<long((USNum / worldNum)*100)<<"%�̴�"<<endl;
	printf("%lf %�̴�.\n", (USNum / worldNum)*100); 
	
	
	
	return 0;
}

double BMI(int ft, int inch, int pound)
{
	int ftToInch = ft*12;
	double inchToMeter = (inch+ftToInch)*0.0254; //�𸣰� �� 
	double poundToKg = pound / 2.2;
	double result = poundToKg / (inchToMeter * inchToMeter) ;
	
	return result;
}

float wido(int a, int b, int c)
{
	float b_ = c / 60;
	float a_ = (b+b_) / 60;
	
	return a+a_;
}

void secToDay(long num)
{
	int day;
	int hour;
	int min;
	int sec;
	
	day = num / (24*60*60);
	hour = num / (60*60) - day*24;
	min = num / 60 - (day*24+hour)*60;
	sec = num - ((day*24 + hour)*60 + min)*60;
	
	cout << day<<"��, "<<hour<<"�ð�,"<<min<<"��, "<<sec<<"��"<<endl;
}

void question6()
{
	
	int mile;
	int gal;
	cout << mile/gal;
	
}

void question7()
{
	
}
