if __name__ == '__main__':
    n = int(input())
    liste_prix = list(map(int, input().split()))
    b = int(input())
    total = 0
    min = 2147483647
    o = 1
    for i in range(n) :
        for y in range(i,n) :
            total = total + liste_prix[y]
            if total > b :
                break
            if o > min :
                break
            if total == b :
                if min > o :
                    min = o
            o+=1
        o = 1
        total = 0
    if min==2147483647 :
        min = -1
    print(min)