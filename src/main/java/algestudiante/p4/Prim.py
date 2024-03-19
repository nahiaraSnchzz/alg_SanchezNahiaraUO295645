import Auxiliar as aux;
import math as math;

def Prim(matriz):
    """Tras meter el nombre en un fichero, calcula y escribe por 
    pantalla la solución óptima"""
    #aux.escribirMatriz(matriz)
    visitados = [False] * len(matriz)
    aristasMinimas = []
    visitados[0] = True
    while visitados.count(True) != len(matriz) :
        Minimo (visitados, matriz, aristasMinimas)

    return aristasMinimas


def PrimFichero(nombreFichero):
    """Tras meter el nombre en un fichero, calcula y escribe por 
    pantalla la solución óptima"""
    matriz = aux.matrizTriangularDesdeFichero(nombreFichero)
    #aux.escribirMatriz(matriz)
    visitados = [False] * len(matriz)
    aristasMinimas = []
    visitados[0] = True
    while visitados.count(True) != len(matriz) :
        Minimo (visitados, matriz, aristasMinimas)

    return aristasMinimas



def Minimo (visitados, matriz, aristasMinimas):
    """Encuentra la arista mínima"""
    minimo = math.inf
    indiceMin = -1

    for i in range (len(matriz)):
        for j in range (len(matriz)):
            if (j > i and i != j and matriz[i][j] < minimo and visitados[j] == False and visitados[i] == True):
                minimo = matriz[i][j]
                indiceMin = j
    visitados[indiceMin] = True
    aristasMinimas.append(minimo)




print(PrimFichero("grafo4.txt"))

print(PrimFichero("grafo8.txt"))
