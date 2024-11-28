#!/bin/bash

# Nome do arquivo Prolog
arquivo_prolog="tp_2021020317.pl"

if [ ! -f "$arquivo_prolog" ]
then
    echo "Arquivo $arquivo_prolog não encontrado."
    exit 1
fi

swipl -s "$arquivo_prolog"
