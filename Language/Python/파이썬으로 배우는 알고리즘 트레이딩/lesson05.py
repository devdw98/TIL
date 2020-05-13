#5-1
def myaverage(a,b):
	return (a+b)/2

#5-2
def get_max_min(data_list):
	return (max(data_list), min(data_list))

#5-3
def get_txt_list(path):
	import os
	org_list = os.listdir(path)
	ret_list = []
	for x in org_list:
		if x.endswith("txt"):
			ret_list.append(x)
	return ret_list

#5-4
def BMI(kg, cm):
	m = cm * 0.01
	result = kg / (m*m)
	if result < 18.5 :
		print('마른 체형')
	elif (18.5 <= result) and (result < 25.0):
		print('표준')
	elif (25.0 <= result) and (result < 30.0):
		print('비만')
	else:
		print('고도비만')

#5-5
while 1:
        height = input("Height (cm): ")
        weight = input("Weight (kg): ")
        BMI(float(height), float(weight))


#5-6
def get_triangle_area(width, height):
	return width * height / 2

#5-7
def add_start_to_end(start, end):
	result = 0
	for i in range(start,end+1,1):
		result += i
	return result
