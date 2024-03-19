import Prim as prim
import Auxiliar as aux
import time
import sys

def Tiempos():
    """Calcula los tiempos"""
    i = 256
    
    while i < sys.maxsize:

        matriz = aux.matrizTriangularEnterosAleatorios(i,100,999)
        inicio = time.time()
        prim.Prim(matriz)
        fin = time.time()
        
        tiempo = fin - inicio
        print (f'n = {i}  tiempo(s) = {tiempo}')
        
        i *= 2


def Tiemposs():
    """Calcula los tiempos"""
    

    matriz = aux.matrizTriangularEnterosAleatorios(255,100,999)
    inicio = time.time()
    prim.Prim(matriz)
    fin = time.time()
        
    tiempo = fin - inicio
    print (f'n = {255}  tiempo(s) = {tiempo}')



Tiempos()