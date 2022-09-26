if __name__ == '__main__':
    n = int(input())
    s = input()
    s= s.replace('.','')
    e = 0
    final = ""
    o=0
    t = 0
    for i in range(len(s)) :
        if s[i] == '*' :
            if e == 1 :
                t = 1
            else :
                e = 1
        if e == 0 :
            final=final+s[i]
            o+=0
        if t == 1 :
            e = 0
            t = 0
    print(final)