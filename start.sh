#!/bin/bash

echo -ne "\033]0;Mobile Bridge Control\007"
clear

echo "=========================================="
echo "    CONTROLE DE CONEXAO - MOBILE BRIDGE"
echo "=========================================="
echo ""

echo "[1/4] Reiniciando servidor ADB..."
adb kill-server
adb start-server

echo ""
echo "[2/4] Configuracao de Conexao"
echo "------------------------------------------"
read -p "Digite o IP do celular (ou aperte Enter para USB): " ip

if [ -z "$ip" ]; then
    echo "Modo USB selecionado."
else
    echo "Tentando conectar ao IP: $ip"
    adb connect "$ip"
fi

echo ""
echo "[3/4] Limpando mensagens antigas..."
adb logcat -c

echo ""
echo "[4/4] Iniciando Notificador Java..."
echo "------------------------------------------"
mvn exec:java -Dexec.mainClass="com.notificador.App"

echo ""
echo "O programa foi encerrado."
read -p "Pressione [Enter] para sair..."