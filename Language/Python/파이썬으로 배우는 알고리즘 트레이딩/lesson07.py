import os
#7-1
f = open("C:\\Users\\DO\\Desktop\\number.txt",'rt')
numbers = f.readlines()
for i in numbers:
    print(i,end="")

print()

#7-2
path = input("경로를 입력하세요: ")
fpath = open("C:\\Users\\DO\\Desktop\\flist.txt",'wt')
plist = os.listdir(path)
for l in plist:
    fpath.write(l+"\n")