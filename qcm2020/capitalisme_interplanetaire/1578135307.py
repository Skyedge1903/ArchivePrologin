t = int(input())
n = int(input())
planetes = [dict(zip(("x", "y", "k"), map(int, input().split()))) for _ in range(n)]
d = int(input())
mission = list(map(int, input().split()))

# on crée une nouvelle structure

carte_spatial = {}
for i in planetes:
    carte_spatial[i['k']] = []
for i in planetes:
    carte_spatial[i['k']].append([i['x'], i['y']])

# on génère puis élague puis racourcis

graphe_ancien = [0]*len(carte_spatial[mission[0]])
for i in range(d-1):
    graphe = [float('inf')]*len(carte_spatial[mission[i+1]])
    for j, a in zip(carte_spatial[mission[i+1]], range(len(graphe))):
        for k, b in zip(carte_spatial[mission[i]], graphe_ancien):
            graphe[a] = min(graphe[a], abs(j[0] - k[0]) + abs(j[1] - k[1]) + b)
    graphe_ancien = graphe.copy()
print(min(graphe_ancien))