list1=[1,2,2,2,3,3,3,3,4]
com=[]
nocom=[]
for i in list1:
    if(list1.count(i)==1):
        nocom.append(i)
    else:
        com.append(i)

print(list1)
print("common element: ",set(com))
print("no common element: ",nocom)
