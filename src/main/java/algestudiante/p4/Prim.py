import Auxiliar as aux;
import math as math;


def Prim(nombreFichero):
    """Tras meter el nombre de un fichero, calcule y escriba por pantalla la solución óptima."""
    matriz = aux.matrizTriangularDesdeFichero(nombreFichero)
    aux.escribirMatriz(matriz)
    primerNodo = matriz [0][1]
    visitados = [primerNodo]
    aristaMinima = CalculaAristaMinima(matriz, 0)
    print(aristaMinima)


def CalculaAristaMinima(matriz, fila):
    """Busca la arista minima"""
    minimo = math.inf
    for j in range (1,len(matriz)-1):

        if (matriz[fila][j] < minimo):

            minimo = matriz[fila][j]

    return minimo


def GetListaAristas(matriz,fila):
    """Devuelve una lista con los valores de las aristas en la fila pasada como parametro"""
    

Prim("grafo4.txt")


