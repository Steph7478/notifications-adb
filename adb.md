# 📖 MANUAL TÉCNICO COMPLETO: ADB (PLATFORM-TOOLS)

### 🌍 OPÇÕES GLOBAIS
| Comando | Descrição |
| :--- | :--- |
| `-a` | Escuta em todas as interfaces de rede, não apenas localhost. |
| `-d` | Usa o dispositivo via USB (dá erro se houver mais de um). |
| `-e` | Usa o dispositivo via TCP/IP (dá erro se houver mais de um). |
| `-s SERIAL` | Direciona o comando para um dispositivo específico pelo número de série. |
| `-p PORTA` | Define a porta do servidor ADB (padrão 5037). |
| `-H HOST` | Nome do host do servidor ADB (padrão localhost). |

### 🛠️ COMANDOS GERAIS
| Comando | Descrição |
| :--- | :--- |
| `devices [-l]` | Lista todos os dispositivos conectados (-l detalha o modelo). |
| `help` | Mostra a mensagem de ajuda completa. |
| `version` | Exibe a versão instalada do ADB. |

### 🌐 NETWORKING (REDE)
| Comando | Descrição |
| :--- | :--- |
| `connect HOST[:PORTA]` | Conecta a um dispositivo via TCP/IP (padrão 5555). |
| `disconnect [HOST]` | Desconecta de um dispositivo ou de todos. |
| `pair HOST[:PORTA] [CODE]` | Pareia o dispositivo para depuração sem fio segura. |
| `forward LOCAL REMOTE` | Encaminha conexões de soquete do PC para o celular. |
| `reverse REMOTE LOCAL` | Encaminha conexões de soquete do celular para o PC. |
| `mdns check/services` | Verifica e lista serviços de descoberta mDNS. |

### 📂 TRANSFERÊNCIA DE ARQUIVOS
| Comando | Descrição |
| :--- | :--- |
| `push [--sync] LOCAL REMOTE` | Copia arquivos/diretórios do PC para o dispositivo. |
| `pull REMOTE LOCAL` | Copia arquivos/diretórios do dispositivo para o PC. |
| `sync [partição]` | Sincroniza uma build local com o dispositivo (data, system, etc). |

### 🐚 SHELL & APPS
| Comando | Descrição |
| :--- | :--- |
| `shell [COMANDO]` | Executa um comando no terminal remoto do Android. |
| `install [opções] APK` | Instala um pacote (.apk) no dispositivo. |
| `install-multiple` | Instala vários APKs para um único pacote (Split APKs). |
| `uninstall [-k] PACOTE` | Remove um app. `-k` mantém os dados e cache. |
| `emu COMANDO` | Executa um comando no console do emulador. |

### 🐞 DEPURAÇÃO E SCRIPTING
| Comando | Descrição |
| :--- | :--- |
| `logcat` | Exibe o log do sistema (essencial para o seu projeto). |
| `bugreport [CAMINHO]` | Gera um relatório de erros completo (zip). |
| `jdwp` | Lista PIDs de processos que suportam transporte JDWP. |
| `wait-for-device` | Pausa o script até que o dispositivo esteja online. |
| `get-state` | Retorna o status: offline, bootloader ou device. |
| `get-serialno` | Imprime o número de série do dispositivo. |

### 🔐 SEGURANÇA E SISTEMA
| Comando | Descrição |
| :--- | :--- |
| `disable-verity` | Desativa verificação de integridade (em builds userdebug). |
| `keygen ARQUIVO` | Gera chaves públicas/privadas para autenticação ADB. |
| `root / unroot` | Reinicia o daemon do ADB com ou sem permissões de root. |
| `reboot [bootloader/recovery]` | Reinicia o aparelho no modo especificado. |
| `sideload PACOTE` | Instala um pacote de atualização OTA manualmente. |

### ⚙️ SERVIDOR INTERNO (INTERNAL)
| Comando | Descrição |
| :--- | :--- |
| `start-server` | Garante que o servidor ADB está rodando. |
| `kill-server` | Encerra o servidor ADB atual. |
| `reconnect` | Força a reconexão entre o PC e o dispositivo. |
| `attach / detach` | Conecta ou desconecta logicamente de um dispositivo USB. |