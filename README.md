# ToDoApp

ToDoApp é um aplicativo de lista de tarefas desenvolvido em [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/), permitindo que ele seja executado em diversas plataformas, incluindo Android, iOS e Desktop. O aplicativo foi construído com a arquitetura MVVM (Model-View-ViewModel) para garantir uma separação clara de responsabilidades e facilitar a manutenção e escalabilidade do código. Para a persistência de dados, foi utilizado o Room, uma biblioteca robusta e eficiente para armazenamento local.

# Screenshots

Aqui estão algumas capturas de tela do ToDoApp em diferentes plataformas:
<p float="left">
  <img src="https://github.com/user-attachments/assets/e49a9dd4-9e82-4ee8-bd21-ca1ac67fe209" width=20% />
  <img src="https://github.com/user-attachments/assets/0a96c9d4-6bd7-44b5-9eca-a970c19e06d3" width=20% /> 
  <img src="https://github.com/user-attachments/assets/a75d32ce-18a6-41cb-a5ae-8c4de7248845" width=20% />
</p>


# Funcionalidades

- Adicionar tarefas: Crie novas tarefas com título, descrição e data de conclusão.

- Excluir tarefas: Remova tarefas que não são mais necessárias.

- Marcar como concluída: Marque tarefas como concluídas para manter o controle do progresso.

- Persistência de dados: Todas as tarefas são armazenadas localmente usando o Room, garantindo que os dados sejam mantidos mesmo após o fechamento do aplicativo.

- Multiplataforma: Funciona em Android, iOS e Desktop com uma base de código compartilhada.

# Arquitetura

O aplicativo segue a arquitetura MVVM (Model-View-ViewModel), que promove uma separação clara entre a lógica de negócios e a interface do usuário. Aqui está uma visão geral dos componentes principais:

- Model: Representa os dados da aplicação e a lógica de negócios. Neste caso, o modelo é gerenciado pelo Room para persistência de dados.

- View: A interface do usuário é construída usando Jetpack Compose, que permite uma UI declarativa e reativa.

- ViewModel: Age como intermediário entre a View e o Model, expondo os dados necessários para a UI e lidando com as interações do usuário.

# Tecnologias Utilizadas

- [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/): Para a construção da interface do usuário multiplataforma.

- [Room](https://developer.android.com/kotlin/multiplatform/room/): Para persistência de dados local.
  
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html): Para operações assíncronas e gerenciamento de threads.
  
- [MVVM Architecture](https://developer.android.com/topic/libraries/architecture/viewmodel): Para uma estrutura de código organizada e escalável.
