m = int(input())
f = int(input())
males = [dict(zip(("x", "y"), map(int, input().split()))) for _ in range(m)]
femelles = [dict(zip(("x", "y"), map(int, input().split()))) for _ in range(f)]
distance_min = 1000000000
male_alpha =-1
total = [0 for i in range(0,m)]
max_=0

for femelle in range(0,f):
    for male in range(0,m):
        if distance_min>abs(males[male]["x"]-femelles[femelle]["x"])+abs(males[male]["y"]-femelles[femelle]["y"]):
            distance_min = abs(males[male]["x"]-femelles[femelle]["x"])+abs(males[male]["y"]-femelles[femelle]["y"])
            male_alpha = male
    total[male_alpha]= total[male_alpha]+distance_min
    male_alpha = -1
    distance_min = 1000000000

for i in total :
    if max_<i:
        max_ = i
print (max_)