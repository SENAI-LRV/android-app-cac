# CAC (Cadê a Chave?) - SENAI Lucas do Rio Verde

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue.svg)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-brightgreen.svg)](https://developer.android.com/jetpack/compose)
[![Room](https://img.shields.io/badge/Database-Room-orange.svg)](https://developer.android.com/training/data-storage/room)
[![License](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](LICENSE.md)
[![Scc Count Badge](https://sloc.xyz/github/SENAI-LRV/android-app-cac/)](https://github.com/SENAI-LRV/android-app-cac/)

Aplicativo Android desenvolvido para gerenciar a reserva de chaves de salas de aula no SENAI de Lucas do Rio Verde, facilitando o controle de acesso e organização para professores e funcionários.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
- [Arquitetura](#arquitetura)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

## 🎯 Sobre o Projeto

O Sistema de Reserva de Chaves é uma solução digital desenvolvida especificamente para o SENAI de Lucas do Rio Verde, visando modernizar e otimizar o processo de controle de chaves das salas de aula. O aplicativo permite que professores e funcionários autorizados façam reservas de chaves de forma prática e organizada, eliminando a necessidade de controles manuais em papel.

### Problema Resolvido

- Eliminação de conflitos de horários para uso de salas
- Controle digital de quem possui cada chave
- Histórico completo de reservas e devoluções
- Redução de perda de chaves e tempo de espera
- Organização centralizada dos recursos da instituição

## ⚡ Funcionalidades

### 🔐 Gerenciamento de Chaves
- Cadastro e catalogação de chaves por sala
- Status em tempo real (disponível/reservada/em uso)
- Informações detalhadas de cada sala

### 📅 Sistema de Reservas
- Reserva de chaves por período específico
- Visualização de agenda de reservas
- Notificações de lembrete para devolução
- Cancelamento e alteração de reservas

### 👥 Controle de Usuários
- Autenticação de professores e funcionários
- Diferentes níveis de permissão
- Perfil personalizado do usuário

### 📊 Relatórios e Histórico
- Histórico completo de reservas
- Relatórios de uso por sala
- Estatísticas de ocupação
- Exportação de dados

### 🔔 Notificações
- Lembretes de devolução
- Alertas de reservas pendentes
- Notificações de status das chaves

## 🛠 Tecnologias Utilizadas

### Core
- **[Kotlin](https://kotlinlang.org/)** - Linguagem de programação principal
- **[Android SDK](https://developer.android.com/)** - Framework de desenvolvimento Android

### Interface de Usuário
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)** - Toolkit moderno para UI nativa
- **[Material Design 3](https://m3.material.io/)** - Sistema de design

### Arquitetura e Gerenciamento de Estado
- **[Android Architecture Components](https://developer.android.com/topic/libraries/architecture)** - MVVM pattern
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)** - Gerenciamento de estado
- **[LiveData](https://developer.android.com/topic/libraries/architecture/livedata)** - Observação de dados
- **[Navigation Component](https://developer.android.com/guide/navigation)** - Navegação entre telas

### Banco de Dados
- **[Room](https://developer.android.com/training/data-storage/room)** - Camada de abstração sobre SQLite
- **[SQLite](https://www.sqlite.org/)** - Banco de dados local

### Injeção de Dependência
- **[Hilt](https://dagger.dev/hilt/)** - Framework de injeção de dependência

### Utilitários
- **[Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)** - Programação assíncrona
- **[Flow](https://kotlinlang.org/docs/flow.html)** - Streams de dados reativos

## 📋 Pré-requisitos

Antes de iniciar, certifique-se de ter as seguintes ferramentas instaladas:

- **Android Studio** Arctic Fox ou superior
- **JDK 8** ou superior
- **Android SDK** (API level 24 ou superior)
- **Git** para controle de versão

### Versões Mínimas
- **Compile SDK**: 34
- **Target SDK**: 34
- **Min SDK**: 24 (Android 7.0)

## 🚀 Instalação

### 1. Clone o Repositório
```bash
git clone https://github.com/SENAI-LRV/android-app-cac.git
cd android-app-cac
```

### 2. Abra no Android Studio
- Abra o Android Studio
- Selecione "Open an existing project"
- Navegue até a pasta do projeto clonado
- Aguarde a sincronização automática do Gradle

### 3. Sincronize as Dependências
```bash
./gradlew build
```

### 4. Execute o Aplicativo
- Conecte um dispositivo Android ou inicie um emulador
- Clique em "Run" ou pressione `Shift + F10`

## ⚙️ Configuração

### Configuração do Banco de Dados

O aplicativo utiliza Room com SQLite, não sendo necessária configuração adicional para desenvolvimento local. O banco será criado automaticamente na primeira execução.

### Configuração de Usuários Padrão

Na primeira execução, o sistema criará automaticamente:
- **Usuário Administrador**: `admin@senai.br` / `admin123`
- **Usuário Professor**: `professor@senai.br` / `prof123`

### Personalização

Para personalizar o aplicativo para sua instituição, edite os seguintes arquivos:

- `app/src/main/res/values/strings.xml` - Textos e labels
- `app/src/main/res/values/colors.xml` - Cores do tema
- `app/src/main/java/br/edu/senai/cac/config/AppConfig.kt` - Configurações gerais

## 📱 Uso

### Primeiro Acesso
1. Abra o aplicativo
2. Faça login com as credenciais padrão ou cadastre-se
3. Complete seu perfil com informações pessoais

### Reservar uma Chave
1. Na tela principal, toque em "Nova Reserva"
2. Selecione a sala desejada
3. Escolha o período de uso
4. Confirme a reserva

### Devolver uma Chave
1. Acesse "Minhas Reservas"
2. Selecione a reserva ativa
3. Toque em "Devolver Chave"
4. Confirme a devolução

### Visualizar Histórico
1. Acesse o menu lateral
2. Selecione "Histórico"
3. Filtre por período ou sala conforme necessário

## 🏗 Arquitetura

O projeto segue o padrão **MVVM (Model-View-ViewModel)** recomendado pelo Google para aplicações Android, implementando Clean Architecture com as seguintes camadas:

```
app/
├── data/           # Camada de dados
│   ├── local/      # Banco de dados local (Room)
│   ├── repository/ # Implementação dos repositórios
│   └── models/     # Modelos de dados
├── domain/         # Regras de negócio
│   ├── entities/   # Entidades do domínio
│   ├── repository/ # Interfaces dos repositórios
│   └── usecases/   # Casos de uso
├── presentation/   # Camada de apresentação
│   ├── ui/         # Composables e telas
│   ├── viewmodel/  # ViewModels
│   └── theme/      # Tema e estilos
└── di/            # Injeção de dependência
```

### Fluxo de Dados
1. **UI (Compose)** → **ViewModel** → **UseCase** → **Repository** → **Database (Room)**

### Principais Componentes

#### Entidades de Banco de Dados
- `User` - Informações dos usuários
- `Room` - Dados das salas
- `Key` - Informações das chaves
- `Reservation` - Registros de reservas

#### ViewModels Principais
- `AuthViewModel` - Autenticação e gerenciamento de sessão
- `ReservationViewModel` - Gerenciamento de reservas
- `KeyManagementViewModel` - Controle de chaves
- `HistoryViewModel` - Histórico e relatórios

## 📁 Estrutura do Projeto

```
android-app-cac/
├── app/
│   ├── src/main/
│   │   ├── java/br/edu/senai/cac/
│   │   │   ├── data/
│   │   │   │   ├── local/
│   │   │   │   │   ├── database/
│   │   │   │   │   │   ├── AppDatabase.kt
│   │   │   │   │   │   └── Converters.kt
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   ├── UserDao.kt
│   │   │   │   │   │   ├── RoomDao.kt
│   │   │   │   │   │   ├── KeyDao.kt
│   │   │   │   │   │   └── ReservationDao.kt
│   │   │   │   │   └── entities/
│   │   │   │   │       ├── UserEntity.kt
│   │   │   │   │       ├── RoomEntity.kt
│   │   │   │   │       ├── KeyEntity.kt
│   │   │   │   │       └── ReservationEntity.kt
│   │   │   │   └── repository/
│   │   │   │       ├── AuthRepositoryImpl.kt
│   │   │   │       ├── ReservationRepositoryImpl.kt
│   │   │   │       └── KeyRepositoryImpl.kt
│   │   │   ├── domain/
│   │   │   │   ├── entities/
│   │   │   │   ├── repository/
│   │   │   │   └── usecases/
│   │   │   ├── presentation/
│   │   │   │   ├── ui/
│   │   │   │   │   ├── screens/
│   │   │   │   │   ├── components/
│   │   │   │   │   └── navigation/
│   │   │   │   ├── viewmodel/
│   │   │   │   └── theme/
│   │   │   ├── di/
│   │   │   └── utils/
│   │   └── res/
│   │       ├── drawable/
│   │       ├── values/
│   │       └── xml/
├── gradle/
├── build.gradle
├── README.md
└── LICENSE.md
```

## 🤝 Contribuição

Contribuições são sempre bem-vindas! Para contribuir com o projeto:

### Como Contribuir

1. **Fork o projeto**
2. **Crie uma branch para sua feature**
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. **Faça commit das suas alterações**
   ```bash
   git commit -m 'Adiciona nova funcionalidade'
   ```
4. **Push para a branch**
   ```bash
   git push origin feature/nova-funcionalidade
   ```
5. **Abra um Pull Request**

### Diretrizes de Contribuição

- Siga os padrões de código Kotlin estabelecidos
- Escreva testes para novas funcionalidades
- Documente mudanças significativas
- Mantenha commits pequenos e focados
- Use mensagens de commit claras e descritivas

### Reportando Bugs

Para reportar bugs, crie uma issue incluindo:
- Descrição detalhada do problema
- Passos para reproduzir o bug
- Versão do Android e dispositivo usado
- Screenshots (se aplicável)

## 📄 Licença

Este projeto está licenciado sob a Licença GPL v3 - veja o arquivo [LICENSE.md](LICENSE.md) para detalhes.

```
GNU General Public License v3.0

Copyright (c) 2024 SENAI Lucas do Rio Verde

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.
```

## 📞 Contato

**SENAI Lucas do Rio Verde**
- 📧 Email: miguel@docente.senai.br
- 🌐 Website: [senaimt.ind.br](https://senaimt.ind.br)
- 📱 Telefone: (65) 3548-8600
- 📍 Endereço: Rua Umuarama 675 S - Menino Deus - Lucas do Rio Verde, MT

**Equipe de Desenvolvimento**
- 👨‍💻 Lead Developer: [Miguel Nischor](mailto:miguel@docente.senai.br)
- 🎨 UI/UX Designer: [Miguel Nischor](mailto:miguel@docente.senai.br)

---

<div align="center">

**Desenvolvido com ❤️ para o SENAI Lucas do Rio Verde**

[⬆ Voltar ao topo](#sistema-de-reserva-de-chaves---senai-lucas-do-rio-verde)

</div>
