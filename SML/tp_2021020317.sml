(* Função para verificar se uma lista é vazia *)
fun ehVazio(A) = null A;

(* Função para calcular a união de duas listas *)
fun uniaoConj(A, B) = A @ List.filter (fn x => not (List.exists (fn y => x = y) A)) B;

(* Função para calcular a interseção de duas listas *)
fun intersConj(A, B) = List.filter (fn x => List.exists (fn y => x = y) B) A;

(* Função para calcular a diferença entre duas listas *)
fun diffConj(A, B) = List.filter (fn x => not (List.exists (fn y => x = y) B)) A;

(* Função para calcular a diferença simétrica entre duas listas *)
fun diffSimConj(A, B) = diffConj(A, B) @ diffConj(B, A);

(* Função para adicionar um elemento a uma lista *)
fun addConj(A, x) = if List.exists (fn y => x = y) A then A else A @ [x];

(* Função para remover um elemento de uma lista *)
fun remConj(A, x) = List.filter (fn y => not (x = y)) A;

(* Função para calcular o tamanho de uma lista *)
fun tamConj(A) = length A;

(* Função para verificar se um elemento pertence a uma lista *)
fun ehElemConj(A, x) = List.exists (fn y => x = y) A;

(* Exemplo de uso *)
(*val conjunto_A = [1, 2, 3, 4, 5];
val conjunto_B = [4, 5, 6, 7, 8];

(* Imprimindo os resultados *)
print ("É vazio (A): " ^ Bool.toString (ehVazio(conjunto_A)) ^ "\n");
print ("União de A e B: " ^ Int.toString (uniaoConj(conjunto_A, conjunto_B)) ^ "\n");
print ("Interseção de A e B: " ^ Int.toString (intersConj(conjunto_A, conjunto_B)) ^ "\n");
print ("Diferença A - B: " ^ Int.toString (diffConj(conjunto_A, conjunto_B)) ^ "\n");
print ("Diferença Simétrica A ⊕ B: " ^ Int.toString (diffSimConj(conjunto_A, conjunto_B)) ^ "\n");

(* Adicionando um elemento a A *)
val novo_conjunto_A = addConj(conjunto_A, 10);
print ("A após adição: " ^ Int.toString novo_conjunto_A ^ "\n");

(* Removendo um elemento de A *)
val novo_conjunto_A = remConj(conjunto_A, 3);
print ("A após remoção: " ^ Int.toString novo_conjunto_A ^ "\n");

(* Tamanho de A *)
print ("Tamanho de A: " ^ Int.toString (tamConj(conjunto_A)) ^ "\n");

(* Verificando se um elemento pertence a A *)
val elemento_verificar = 2;
print (Int.toString elemento_verificar ^ " pertence a A: " ^ Bool.toString
(ehElemConj(conjunto_A, elemento_verificar)) ^ "\n");*)

