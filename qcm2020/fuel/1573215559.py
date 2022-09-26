if __name__ == '__main__':
    n = int(input())
    p = list(map(int, input().split()))
    e=0
    for i in range(n) :
        if p[i] > 90 :
            e+=1

    total = e*20 + n*60
    print(total)