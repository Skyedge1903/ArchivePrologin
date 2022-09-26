n = int(input())
v = int(input())
equipes = [dict(zip(("a", "b", "c"), map(int, input().split()))) for _ in range(n)]
max = -1
meilleur = -1
for i in range(0,n):
    if equipes[i]["a"]+equipes[i]["b"]+equipes[i]["c"]<=v:
        if max<equipes[i]["a"]+equipes[i]["b"]+equipes[i]["c"]:
            max = equipes[i]["a"]+equipes[i]["b"]+equipes[i]["c"]
            meilleur = i
print(meilleur)