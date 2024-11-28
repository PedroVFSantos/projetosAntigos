def ehVazio(A):
    return len(A) == 0

def uniaoConj(A, B):
    return list(set(A) | set(B))

def intersConj(A, B):
    return list(set(A) & set(B))

def diffConj(A, B):
    return list(set(A) - set(B))

def diffSimConj(A, B):
    return list(set(A) ^ set(B))

def addConj(A, x):
    if x not in A:
        A.append(x)

def remConj(A, x):
    if x in A:
        A.remove(x)

def tamConj(A):
    return len(A)

def ehElemConj(A, x):
    return x in A

# Função para converter elementos da entrada em tipos específicos
def converte_elemento(elemento):
    try:
        return int(elemento)
    except ValueError:
        try:
            return eval(elemento)
        except:
            return elemento

# Criando conjuntos A e B a partir da entrada do usuário
entrada_A = input("Digite os elementos do conjunto A separados por espaço: ")
conjunto_A = [converte_elemento(elemento) for elemento in entrada_A.split()]

entrada_B = input("Digite os elementos do conjunto B separados por espaço: ")
conjunto_B = [converte_elemento(elemento) for elemento in entrada_B.split()]

# Exibindo os conjuntos A e B
print("A:", conjunto_A)
print("B:", conjunto_B)

# Realizando as operações automaticamente
print("É vazio (A):", ehVazio(conjunto_A))
print("União de A e B:", uniaoConj(conjunto_A, conjunto_B))
print("Interseção de A e B:", intersConj(conjunto_A, conjunto_B))
print("Diferença A - B:", diffConj(conjunto_A, conjunto_B))
print("Diferença Simétrica A ⊕ B:", diffSimConj(conjunto_A, conjunto_B))

elemento_add = converte_elemento(input("Digite um elemento para adicionar ao conjunto A: "))
addConj(conjunto_A, elemento_add)
print("A após adição:", conjunto_A)

elemento_rem = converte_elemento(input("Digite um elemento para remover do conjunto A: "))
remConj(conjunto_A, elemento_rem)
print("A após remoção:", conjunto_A)

print("Tamanho de A:", tamConj(conjunto_A))

elemento_verificar = converte_elemento(input("Digite um elemento para verificar se está em A: "))
print(f"{elemento_verificar} pertence a A:", ehElemConj(conjunto_A, elemento_verificar))

