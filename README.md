# Laboratórios MC322

**Equipe:**  
- Thiago Gradvohl de Oliveira (RA: 281378)  
- Gabriel Lopes de Barros (RA: 281198)  

Este repositório conterá os códigos referentes aos laboratórios da disciplina **MC322 - Programação Orientada a Objetos**.

---

## 📁 Lab05

### Principais mudanças:

1. ✅ **Adicionando Missoes para Agentes Inteligentes (Robos)**

2. ✅ **Registro das Missoes em Arquivo (usamos uma classe LogMissoes para isso)**.

3. ✅ `AgenteInteligente` é **classe abstrata** (`executarMissao()`).

4. ✅ `Missao` é **interface** implementada por `MissaoBuscarPonto`, `MissaoExplorar`, `MissaoMonitorar` e `MissaoRemoverObstaculo`.

5. ✅ **Separacao do projeto em pastas (packages) -> melhor organizacao e leitura do projeto**

---

## 📝 Explicando a Main.java

### 1) "MENU ESTATICO": 
- Usada para instanciação dos objetos e alguns "testes de borda" (gerando Exceptions).

## 2) "MENU INTERATIVO" 
- Criada para que o usuario interaja com o programa.
- Opções:
1. **Listar todos os robôs**

2. **Escolher robô para interagir**
   - **Escolha um robô:**
     - (1) BB8-01  
     - (2) DO01  
     - (3) DE01  
     - (4) DF01  

       - **Escolha o que deseja fazer com o robô selecionado:**
         - (1) Visualizar status  
         - (2) Executar funcionalidades  
           - **Escolha qual funcionalidade deseja utilizar:**
             - (1) Comunicar-se  
             - (2) Usar sensores  
             - (3) Executar tarefas próprias  
             - (4) Executar Missão  
         - (3) Mudar estado do robô  
         - (4) Mover robô  
         - (5) Ver Missão  
         - (6) Definir Missão  
           - **Escolha a missão a ser adicionada:**
             - (1) Missão Buscar Ponto (10, 10, 10)  
             - (2) Missão Remover Obstáculo VULCÃO  
             - (3) Missão Explorar raio de 10.0  
             - (4) Missão Monitorar  

3. **Visualizar ambiente**

4. **Ver status do ambiente**

5. **Listar mensagens trocadas**

6. **Fechar programa**


## 📝 Explicando o Diagrama UML  
*(Imagem PNG na pasta `lab05` do repositório)*

### 1) Herança:  
- `AgenteInteligente` herda de `Robo`. **(NOVO)**
- `RoboTerrestre` e `RoboAereo` herdam de `AgenteInteligente`. **(NOVO)**  
- `BB_8` e `DestruidorObstaculos` herdam de `RoboTerrestre`.  
- `DroneEntregador` e `DroneFotografico` herdam de `RoboAereo`.  
- `SensorTemperatura`, `SensorProximidade` e `SensorOxigenio` herdam de `Sensor`.  

### 2) Dependência:  
- `Missao` depende de `Sensor`, `Entidade` e `Ambiente`. **(NOVO)**  
- `Sensor` depende de `Robo` e de `Ambiente`.  
- `CentralComunicacao` depende de `Robo`.  

### 3) Composição:  
- `LogMissoes` possui `Missao` (1 para 0..*) **(NOVO)**
- `AgenteInteligente` possui `Missao` (1 para 0..1). **(NOVO)**
- `Ambiente` contém `Entidade` (1 para 1..*).   
- `Obstaculo` contém `TipoObstaculo` (1 para 1).  
- `Obstaculo` e `Robo` contêm `TipoEntidade` (1 para 1).  
- `Robo` contém `EstadoRobo` (1 para 1).  

### 4) Agregação:  
- Robôs podem ter `Sensor` (1 para 0..*).  
- `MissaoRemoverObstaculo` contem `Obstaculo` como alvo (1 para 1). 

### 5) Implementação:  
- `MissaoBuscarPonto`, `MissaoExplorar`, `MissaoMonitorar` e `MissaoRemoverObstaculo` implementam `Missao`. **(NOVO)**
- `Robo` e `Obstaculo` implementam `Entidade`.  
- `Robo` implementa `Sensoreavel` e `Comunicavel`.  
- `BB_8` implementa `Atacante`.  
- `DroneFotografico` implementa `Fotografico`.  
- `DestruidorObstaculos` implementa `DestruidorAutonomo`.  

---

## ❗️ Exceptions adicionadas:

1. **`BateriaInsuficienteException`**:  
   Lançada quando `DestruidorObstaculos` tenta realizar ação (`moverPara()` e `executarTarefa()`) sem ter energia suficiente.

2. **`CameraDesligadaException`**:  
   Lançada quando `DroneFotografico` tenta tirar foto (`executarTarefa()`) com a câmera desligada.

3. **`ColisaoException`**:  
   Lançada na classe `Ambiente` ao tentar mover ou adicionar `Entidade` em espaço ocupado.

4. **`EntidadeEstaticaException`**:  
   Lançada ao tentar mover a entidade `Obstaculo` na classe `Ambiente`.

5. **`ForaDosLimitesException`**:  
   Lançada ao tentar adicionar ou mover `Entidade` para fora dos limites na classe `Ambiente`.

6. **`RoboDesligadoException`**:  
   Lançada ao tentar mover, acionar sensores ou `executarTarefa()` com `EstadoRobo` **DESLIGADO** nas classes `Robo` ou `Ambiente`.

7. **`MunicaoInsuficienteException`**:  
   Lançada ao tentar `executarTarefa()` (atacar) na classe `BB_8` com `municao` inferior a 10.

8. **`ModoAtaqueDesligadoException`**:  
   Lançada ao tentar `executarTarefa()` (atacar) na classe `BB_8` com `modo ataque` **DESLIGADO**.

9. **`SemMissaoException`**:  
   Lançada ao tentar `executarMissao()` nas subclasses de `AgenteInteligente` sem ter uma `Missao` definida ainda.  **(NOVO)**

---

## ▶️ Instruções para Compilação e Execução:

### 1) Clonando o repositório na sua máquina:
   ```bash
   git clone https://github.com/thiagogradvohl/Thiago_Gabriel-MC322.git
   ```

### 2) Acesse a pasta `lab05` do repositório:
   ```bash
   cd Thiago_Gabriel-MC322/lab05
   ```
### 3) Compile e execute o arquivo Main.java
### 3.1) Usando uma IDE (como IntelliJ IDEA, Eclipse, NetBeans, VsCode)
   Importe a pasta lab05 como um novo projeto ou módulo;
   Localize o arquivo Main.java;
   Clique com o botão direito e selecione "Run" ou "Executar".
### 3.2) Pelo Terminal:
   Certifique-se de ter o Java Development Kit (JDK) instalado.
   Verifique com:
   ```bash
   java -version
   javac -version
   ```  
   Compile o arquivo Main.java:
   ```bash
   javac Main.java
   ```  
   Execute o programa:
   ```bash
   java Main
   ```


## 📁 Lab04

### Principais mudanças:

1. ✅ **Adicionando interfaces** (permite uma espécie de herança múltipla em Java):
   - `Entidade`: implementada por `Robo` e `Obstaculo`;
   - `Comunicavel`: implementada por `Robo`;
   - `Sensoreavel`: implementada por `Robo`;
   - `Fotografico`: implementada por `DroneFotografico`;
   - `Atacante`: implementada por `BB_8`;
   - `DestruidorAutonomo`: implementada por `DestruidorObstaculos`.

2. ✅ **Implementando Exceptions personalizadas**.

3. ✅ `Robo`, `RoboTerrestre` e `RoboAereo` são **classes abstratas** (`executarTarefa()`).

4. ✅ **Visualização do Ambiente** com mapa.

5. ✅ **Comunicação entre Robôs** → `CentralComunicacao` + `Comunicavel`.

---

## 📝 Explicando o Diagrama UML  
*(Imagem PNG na pasta `lab04` do repositório)*

### 1) Herança:  
- `RoboTerrestre` e `RoboAereo` herdam de `Robo`.  
- `BB_8` e `DestruidorObstaculos` herdam de `RoboTerrestre`.  
- `DroneEntregador` e `DroneFotografico` herdam de `RoboAereo`.  
- `SensorTemperatura`, `SensorProximidade` e `SensorOxigenio` herdam de `Sensor`.  

### 2) Dependência:  
- `Sensor` depende de `Robo` e de `Ambiente`.  
- `CentralComunicacao` depende de `Robo`.  

### 3) Composição:  
- `Ambiente` contém `Entidade` (1 para 1..*).  
- `Obstaculo` contém `TipoObstaculo` (1 para 1).  
- `Obstaculo` e `Robo` contêm `TipoEntidade` (1 para 1).  
- `Robo` contém `EstadoRobo` (1 para 1).  

### 4) Agregação:  
- Robôs podem ter `Sensor` (1 para 0..*).  

### 5) Implementação:  
- `Robo` e `Obstaculo` implementam `Entidade`.  
- `Robo` implementa `Sensoreavel` e `Comunicavel`.  
- `BB_8` implementa `Atacante`.  
- `DroneFotografico` implementa `Fotografico`.  
- `DestruidorObstaculos` implementa `DestruidorAutonomo`.  

---

## ❗️ Exceptions adicionadas:

1. **`BateriaInsuficienteException`**:  
   Lançada quando `DestruidorObstaculos` tenta realizar ação (`moverPara()` e `executarTarefa()`) sem ter energia suficiente.

2. **`CameraDesligadaException`**:  
   Lançada quando `DroneFotografico` tenta tirar foto (`executarTarefa()`) com a câmera desligada.

3. **`ColisaoException`**:  
   Lançada na classe `Ambiente` ao tentar mover ou adicionar `Entidade` em espaço ocupado.

4. **`EntidadeEstaticaException`**:  
   Lançada ao tentar mover a entidade `Obstaculo` na classe `Ambiente`.

5. **`ForaDosLimitesException`**:  
   Lançada ao tentar adicionar ou mover `Entidade` para fora dos limites na classe `Ambiente`.

6. **`RoboDesligadoException`**:  
   Lançada ao tentar mover, acionar sensores ou `executarTarefa()` com `EstadoRobo` **DESLIGADO** nas classes `Robo` ou `Ambiente`.

7. **`MunicaoInsuficienteException`**:  
   Lançada ao tentar `executarTarefa()` (atacar) na classe `BB_8` com `municao` inferior a 10.

8. **`ModoAtaqueDesligadoException`**:  
   Lançada ao tentar `executarTarefa()` (atacar) na classe `BB_8` com `modo ataque` **DESLIGADO**.

---

## ▶️ Instruções para Compilação e Execução:

### 1) Clonando o repositório na sua máquina:
   ```bash
   git clone https://github.com/thiagogradvohl/Thiago_Gabriel-MC322.git
   ```

### 2) Acesse a pasta `lab04` do repositório:
   ```bash
   cd Thiago_Gabriel-MC322/lab04
   ```
### 3) Compile e execute o arquivo Main.java
### 3.1) Usando uma IDE (como IntelliJ IDEA, Eclipse, NetBeans, VsCode)
   Importe a pasta lab04 como um novo projeto ou módulo;
   Localize o arquivo Main.java;
   Clique com o botão direito e selecione "Run" ou "Executar".
### 3.2) Pelo Terminal:
   Certifique-se de ter o Java Development Kit (JDK) instalado.
   Verifique com:
   ```bash
   java -version
   javac -version
   ```  
   Compile o arquivo Main.java:
   ```bash
   javac Main.java
   ```  
   Execute o programa:
   ```bash
   java Main
   ```
