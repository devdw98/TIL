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
//	cout << "��⵵" << endl;
	
//	int mile;
//	cout << "������ �Է��ϼ���: ";
//	cin >> mile;
//	cout << mile << " �� " << mile * 1.60934 << "km�Դϴ�." << endl;
	
//	printText1();
//	printText2();
	
//	int age;
//	cout << "Enter your age: ";
//	cin >> age;
//	cout << age * 12;

//	int c;
//	cout << "���� �µ��� �Է��ϰ� Enter Ű�� �����ʽÿ�: ";
//	cin >> c;
//	cout << "���� " << c << "���� ȭ���� " << 1.8 * c + 32.0 << " �� �Դϴ�." << endl;

//	double dist;
//	cout << "���� ���� �Է��ϰ� Enter Ű�� �����ʽÿ�: ";
//	cin >> dist;
//	cout << dist << "������ " << changeDist(dist) << " õ�� �����Դϴ�." << endl;

	int hour, minute;
	cout << "�ð� ���� �Է��Ͻÿ�: ";
	cin >> hour;
	cout << "�� ���� �Է��Ͻÿ�: ";
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
	cout << "�ð�: " << hour << ":" << minute;
}
