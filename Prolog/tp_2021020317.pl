% Verificar se uma lista é vazia
ehVazio([]).

% União de duas listas
uniaoConj(A, B, Resultado) :-
    append(A, B, Resultado).

% Interseção de duas listas
intersConj([], _, []).
intersConj([X|RestoA], B, Resultado) :-
    (member(X, B) ->
        Resultado = [X|Resto],
        intersConj(RestoA, B, Resto)
    ;
        intersConj(RestoA, B, Resultado)
    ).

% Diferença entre duas listas
diffConj([], _, []).
diffConj([X|RestoA], B, Resultado) :-
    (member(X, B) ->
        diffConj(RestoA, B, Resultado)
    ;
        Resultado = [X|Resto],
        diffConj(RestoA, B, Resto)
    ).

% Diferença simétrica entre duas listas
diffSimConj(A, B, Resultado) :-
    diffConj(A, B, DiffAB),
    diffConj(B, A, DiffBA),
    append(DiffAB, DiffBA, Resultado).

% Adicionar um elemento a uma lista se não estiver presente
addConj(A, X, NovoA) :-
    (member(X, A) ->
        NovoA = A
    ;
        NovoA = [X|A]
    ).

% Remover um elemento de uma lista
remConj([], _, []).
remConj([X|Resto], Elemento, NovoResto) :-
    (X = Elemento ->
        NovoResto = Resto
    ;
        NovoResto = [X|NovoRestoResto],
        remConj(Resto, Elemento, NovoRestoResto)
    ).

% Tamanho de uma lista
tamConj([], 0).
tamConj([_|Resto], Tamanho) :-
    tamConj(Resto, TamanhoResto),
    Tamanho is TamanhoResto + 1.

% Verificar se um elemento pertence a uma lista
ehElemConj(Elemento, Conjunto) :-
    member(Elemento, Conjunto).
