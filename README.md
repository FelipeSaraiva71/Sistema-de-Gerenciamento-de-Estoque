# 📦 Sistema de Gerenciamento de Estoque

---

## Funcionalidades

✅ **Registro de Entradas**: Cadastro de produtos que chegam ao estoque, incluindo informações como nome, descrição, quantidade, preço unitário, fornecedor, local de armazenamento e operador responsável.  
✅ **Registro de Saídas**: Cadastro de produtos retirados do estoque, incluindo receptor, responsável pela retirada e operador.  
✅ **Cálculo de valor total**: Multiplica automaticamente quantidade pelo preço unitário.  
✅ **Controle de estoque**: Mantém saldo atualizado de cada produto, validando disponibilidade antes de registrar uma saída.  
✅ **Exibição detalhada**: Mostra data/hora da entrega e todos os detalhes do registro.  
✅ **Controle por SKU**: Rastreabilidade por código único de identificação do produto.  
✅ **Movimentações individuais**: Cada entrada e saída é registrada separadamente, garantindo histórico completo.

---

## 📜 Estrutura do Código

`Produtos.java` → Classe abstrata que define atributos e métodos comuns para entradas e saídas, incluindo cálculo de valor total e registro de data/hora.  
`RegistroEntrada.java` → Subclasse para movimentações de entrada, com atributos específicos como fornecedor e local de armazenamento.  
`RegistroSaida.java` → Subclasse para movimentações de saída, com atributos específicos como receptor e responsável pela retirada.  
`Gerenciamento.java` → Classe de controle que gerencia registros de entrada, saída, saldo de estoque e rastreabilidade por SKU.

---

## 🔮 Melhorias Futuras

- 💾 Integração com banco de dados para persistência de dados (opções em análise: MySQL, PostgreSQL ou SQLite).
- 🆔 Cadastro e validação de operadores com autenticação, incluindo controle de acesso por tipo (liberado/restrito).
- 🔐 Implementação de acesso exclusivo para administrador, responsável pelo cadastro e gestão de operadores.
- 📦 Cadastro e controle de SKU (código único de identificação do produto).
- 🏷️ Gerenciamento de posições e capacidade de armazenamento, com validação de disponibilidade antes de registrar movimentações.
- ⚖️ Inclusão de atributo de peso nos produtos para cálculo de carga total por posição ou movimentação.
- 🎨 Desenvolvimento de interface gráfica para facilitar a interação com o sistema.
- 📋 Registro de logs de movimentações e tentativas de acesso (inclusive negadas), para auditoria e segurança.

---

## ✨ Autor

Desenvolvido por Felipe Saraiva  

---
