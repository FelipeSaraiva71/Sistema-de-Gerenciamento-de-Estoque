📦 Sistema de Gerenciamento de Estoque
Funcionalidades
✅ Registro de Entradas: Cadastra produtos que chegam ao estoque, incluindo informações como nome, descrição, quantidade, preço unitário, fornecedor, local de armazenamento e operador responsável.
✅ Registro de Saídas: Cadastra produtos retirados do estoque, incluindo receptor, responsável pela retirada e operador.
✅ Cálculo de valor total: Multiplica automaticamente quantidade pelo preço unitário.
✅ Controle de estoque: Mantém saldo atualizado de cada produto, validando disponibilidade antes de registrar uma saída.
✅ Exibição detalhada: Mostra data/hora da movimentação e todos os detalhes do registro.

📜 Estrutura do Código
Produtos.java → Classe abstrata que define atributos e métodos comuns para entradas e saídas, incluindo cálculo de valor total e registro de data/hora.

RegistroEntrada.java → Subclasse para movimentações de entrada, com atributos específicos como fornecedor e local de armazenagem.

RegistroSaida.java → Subclasse para movimentações de saída, com atributos específicos como receptor e responsável pela retirada.

Gerenciamento.java → Classe de controle que gerencia registros de entrada, saída e saldo de estoque.

🔮 Melhorias Futuras
💾 Banco de dados para persistência de dados (opções em análise: MySQL, PostgreSQL ou SQLite).
🆔 Cadastro e validação de operadores com autenticação.
📦 Cadastro e controle de SKU (código único de identificação de produto).
🏷️ Controle de posições e capacidade de armazenamento (validar disponibilidade antes de registrar).
⚖️ Adicionar peso como atributo para cálculo de carga total.
🎨 Interface gráfica para facilitar a interação.
📤 Exportar relatórios de estoque e movimentações em PDF/Excel.

✨ Autor
Desenvolvido por Felipe Saraiva

