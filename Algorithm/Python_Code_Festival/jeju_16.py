enter = input("enter string: ")
l = []
length = len(enter)
for i in range(0, length):

    l[i] = enter[length-1-i]
    print(enter[i])


print(l)