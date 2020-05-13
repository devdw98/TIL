#4-1
for i in range(5):
	print('*', end='')

#4-2
for i in range(4):
	for j in range(5):
		print('*', end='')
	print()

#4-3
for i in range(5):
	for j in range(i+1):
		print('*', end='')
	print()

#4-4
for i in range(5):
	for j in range(5-i):
		print('*', end='')
	print()

#4-5
for i in range(5):
	for j in range(5-i):
		print(' ',end='')
	print('*'*(i+1))

#4-6
for i in range(5):
	print(' '*i, end='')
	for j in range(5-i):
		print('*',end='')
	print()

#4-7
for i in range(5):
	for j in range(4-i):
		print(' ',end='')
	for k in range(2*i+1):
		print('*',end='')
	print()

#4-8
for i in range(5):
	for k in range(i):
		print(' ',end='')
	for j in range(2*(4-i)+1):
		print('*', end='')
	print()

#4-9
for floor in apart:
        for house in floor:
                if house in arrears:
                        continue
                else:
                        print("Newspaper delivery: ", house)
