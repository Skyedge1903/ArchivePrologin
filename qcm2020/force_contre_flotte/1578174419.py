l = int(input())
h = int(input())
n = int(input())
flotte = [dict(zip(("x", "y", "u", "v"), map(int, input().split()))) for _ in range(n)]

graphe = {
    "lig": {},
    "col": {}
}

battle_map = {}


def placer_ligne(g, l, deja_vis):
    for v in l["arc_poss"]:
        if v["arc_pris"] is None:
            v["arc_pris"] = l
            l["arc_pris"] = v
            return True
        elif v["arc_pris"] not in deja_vis:
            deja_vis.append(v["arc_pris"])
            if placer_ligne(g, v["arc_pris"], deja_vis):
                v["arc_pris"] = l
                l["arc_pris"] = v["arc_pris"]
                return True

    return False


def est_chaine_augmentante(g):
    for l in g["lig"]:
        if g["lig"][l]["arc_pris"] is None:
            if placer_ligne(g, g["lig"][l], []):
                return True
    return False


def resoudre_graphe(g):
    # D'abord je retire tout les sommets accessibles
    for l in g["lig"]:
        for v in g["lig"][l]["arc_poss"]:
            if v["arc_pris"] is None:
                v["arc_pris"] = g["lig"][l]
                g["lig"][l]["arc_pris"] = v
                break

    # Ensuite je regarde si c'est possible de couvrir plus de lignes

    est_augment = True
    while est_augment:
        est_augment = est_chaine_augmentante(g)

    reponse = 0
    for l in g["lig"]:
        if g["lig"][l]["arc_pris"] is not None:
            reponse = reponse + 1

    print(reponse)


for i in flotte:
    for j in range(i["y"], i["v"]):
        if not j in battle_map:
            battle_map[j] = {}
        for k in range(i["x"], i["u"]):
            battle_map[j][k] = {
                "parent": {
                    "x": i["x"],
                    "y": i["y"]
                }
            }

for y in battle_map:
    for x in battle_map[y]:
        ligXId = battle_map[y][x]["parent"]["x"]
        while (ligXId - 1) in battle_map[y]:
            ligXId = battle_map[y][ligXId - 1]["parent"]["x"]
        cle = str(ligXId) + "#" + str(y)
        if cle not in graphe["lig"]:
            graphe["lig"][cle] = {
                "x": x,
                "y": y,
                "arc_pris": None,
                "arc_poss": []
            }
            i = 0
            while ligXId + i in battle_map[y]:
                colYId = battle_map[y][ligXId + i]["parent"]["y"]
                while (colYId - 1) in battle_map and (ligXId + i) in battle_map[colYId - 1]:
                    colYId = battle_map[colYId - 1][ligXId + i]["parent"]["y"]

                # Ajouter la colonne
                cleCol = str(ligXId + i) + "#" + str(colYId)
                if cleCol not in graphe["col"]:
                    graphe["col"][cleCol] = {
                        "x": ligXId + i,
                        "y": colYId,
                        "arc_pris": None,
                        "arc_poss": [graphe["lig"][cle]]
                    }
                else:
                    graphe["col"][cleCol]["arc_poss"].append(graphe["lig"][cle])
                graphe["lig"][cle]["arc_poss"].append(graphe["col"][cleCol])
                i = i + 1

resoudre_graphe(graphe)