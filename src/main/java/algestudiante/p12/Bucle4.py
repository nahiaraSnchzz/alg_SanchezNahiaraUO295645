from time import time

def bucle4 (n):
    """ complejidad temporal cuadrática  O(n**3)"""
    cont=0
    for i in range (1,n+1,1):
        for j in range (1,i+1,1):
            for k in range(1,j+1,1):
                cont=cont+1
    return cont



def main():
    print ("TIEMPO= MILISEGUNDOS")
    t1=0
    t2=0
    n=100
    cont=0
    for i in range (10):
        t1=time()
        c=bucle4(n)
        t2=time()
        print("n= ",n,"**tiempo=",int(1000*(t2-t1)),"**contador=",c)
        n=n*2


main()