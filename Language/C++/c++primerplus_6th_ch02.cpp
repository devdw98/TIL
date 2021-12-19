#include <iostream>
#include <cmath>

using namespace std;

void printText1();
void printText2();
double changeDist(double dist);
void printHourMinute(int hour, int minute);

int main(void)
{
//	cout << "pdw"<<endl;
//	cout << "경기도" << endl;
	
//	int mile;
//	cout << "마일을 입력하세요: ";
//	cin >> mile;
//	cout << mile << " 은 " << mile * 1.60934 << "km입니다." << endl;
	
//	printText1();
//	printText2();
	
//	int age;
//	cout << "Enter your age: ";
//	cin >> age;
//	cout << age * 12;

//	int c;
//	cout << "섭씨 온도를 입력하고 Enter 키를 누르십시오: ";
//	cin >> c;
//	cout << "섭씨 " << c << "도는 화씨로 " << 1.8 * c + 32.0 << " 도 입니다." << endl;

//	double dist;
//	cout << "광년 수를 입력하고 Enter 키를 누르십시오: ";
//	cin >> dist;
//	cout << dist << "광년은 " << changeDist(dist) << " 천문 단위입니다." << endl;

	int hour, minute;
	cout << "시간 값을 입력하시오: ";
	cin >> hour;
	cout << "분 값을 입력하시오: ";
	cin >> minute;
	printHourMinute(hour, minute);

	return 0;
}

void printText1()
{
	for (int i = 0; i < 2; i++)
		cout << "Three blind mice" << endl;
}

void printText2()
{
	for (int i = 0; i < 2; i++)
		cout << "See how they run" << endl;
}

double changeDist(double dist)
{
	return dist * 63240;
}

void printHourMinute(int hour, int minute)
{
	cout << "시각: " << hour << ":" << minute;
}
