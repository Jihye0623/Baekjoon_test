a=input()
ali=list(map(int,a))

ali.sort(reverse=True)
for i in ali:
    print(i,end='')