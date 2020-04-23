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
	
//	cout << "BMI 계산"<<endl;
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
//	 cout << "위도를 도, 분, 초 단위로 입력하시오"<<endl;
//	 cout << "도각을 입력하시오: ";
//	 cin >> a;
//	 cout << "분각을 입력하시오: ";
//	 cin >> b;
//	 cout << "초각을 입력하시오: "; 
//	 cin >> c;
//	 cout.precision(4);
////	 cout << a<<"도, "<<b<<"분, "<<c<<"초 = "<<wido(a,b,c)<<endl;
//	 cout << a<<"도, "<<b<<"분, "<<c<<"초 = "<< double(a+((b+c/60)/60));
	
//	long num;
//	cout << "초 수를 입력하세요: ";
//	cin >> num;
//	cout << num << "초 = ";
//	secToDay(num);
	
	long long worldNum;
	long long USNum;
	cout << "세계 인구 수를 입력하시오: ";
	cin >> worldNum; 
	cout << "미국 인구 수를 입력하시오: ";
	cin >> USNum;
	cout << worldNum<<" "<<USNum<<endl;
	cout << "세계 인구수에서 미국이 차지하는 비중은 "<<long((USNum / worldNum)*100)<<"%이다"<<endl;
	printf("%lf %이다.\n", (USNum / worldNum)*100); 
	
	
	
	return 0;
}

double BMI(int ft, int inch, int pound)
{
	int ftToInch = ft*12;
	double inchToMeter = (inch+ftToInch)*0.0254; //모르겠 당 
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
	
	cout << day<<"일, "<<hour<<"시간,"<<min<<"분, "<<sec<<"초"<<endl;
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
