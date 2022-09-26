p = int(input())
q = int(input())
n = int(input())
animaux = [
    dict(zip(("poids", "quantite"), map(int, input().split())))
    for _ in range(n)
    ]
e=0
ratio  = q/p
for i in range (0,n):
    if (animaux[i]["quantite"])/(animaux[i]["poids"])>=ratio :
        e+=1
        
print(e)