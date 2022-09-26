n = int(input())
for i in range(n+1) :
    for j in range(n+1) :
        for k in range(n+1) :
            if not i+j+k==0 and not (i*100+j*10+k)%2 ==0 and not (i*100+j*10+k)%5 ==0 and not (i*100+j*10+k) % 11 == 0 and (i+j+k) % 2 ==1 and (i*j*k) % 2 == 0 :
                print(str(i)+str(j)+str(k))