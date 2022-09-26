n = int(input())
liste_prix = list(map(int, input().split()))
b = int(input())

prix = 0
debut = 0
min_soluce = []
for fin in range(n):
    prix += liste_prix[fin]
    while prix > b:
        prix -= liste_prix[debut]
        debut += 1
        if prix == b:
            min_soluce.append(fin - debut + 1)
    if prix == b:
        min_soluce.append(fin-debut+1)
print(min_soluce)
if len(min_soluce) == 0:
    print(-1)
else:
    print(min(min_soluce))