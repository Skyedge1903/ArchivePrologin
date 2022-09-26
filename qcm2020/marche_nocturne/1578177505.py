n = int(input())
liste_prix = list(map(int, input().split()))
b = int(input())

prix = 0
consecutif = 0
min_soluce = float('inf')
for i in range(n):
    prix += liste_prix[i]
    if prix > b:
        while prix > b:
            prix -= liste_prix[i-consecutif]
            consecutif -= 1
    elif prix == b:
        min_soluce = int(min(float(consecutif+1), min_soluce))
    consecutif += 1
if min_soluce == float('inf'):
    print(-1)
else:
    print(min_soluce)