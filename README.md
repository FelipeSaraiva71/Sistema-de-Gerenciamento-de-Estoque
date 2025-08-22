# 📦 Sistema de Gerenciamento de Estoque

---

Funcionalidades
✅ Login com controle de acesso: Autenticação como Administrador ou Operador, com permissões distintas para registrar entradas e saídas.
✅ Registro de Entradas: Cadastro completo de produtos que chegam ao estoque, com nome, descrição, quantidade, peso, preço unitário e operador responsável.
✅ Registro de Saídas: Remoção de produtos do estoque, disponível apenas para administradores, com rastreabilidade completa.
✅ Geração automática de SKU: Cada produto recebe um código único com prefixo e contador sequencial.
✅ Controle de posições no estoque: Armazenamento inteligente com PosicaoVaga e PosicaoOcupada, garantindo rastreabilidade física.
✅ Cálculo de valor total e peso bruto: Multiplica automaticamente quantidade pelo preço e peso unitário.
✅ Histórico de movimentações: Registro completo de entradas e saídas com data/hora, produto, operador e tipo de movimentação.
✅ Busca por SKU: Localização rápida de produtos no estoque.
✅ Exibição do mapa de posições: Visualização clara do estado atual do estoque, posição por posição.

📜 Estrutura do Código
Produto.java → Classe abstrata com atributos comerciais e físicos, como nome, descrição, quantidade, peso, preço e SKU.
PessoaAdm.java / PessoaOperador.java → Representam os usuários do sistema com permissões distintas.
GeradorSku.java → Gera códigos únicos para produtos com base em prefixo e contador.
EstoqueEntrada.java → Subclasse de Estoque que permite apenas entrada de produtos.
Posicao.java → Classe abstrata para representar posições no estoque.
PosicaoVaga.java / PosicaoOcupada.java → Subclasses que indicam se uma posição está livre ou ocupada.
Movimentacoes.java → Classe abstrata para registrar ações no estoque.
MovEntrada.java / MovSaida.java → Subclasses que representam movimentações específicas.
MovimentacoesRegistros.java → Armazena e exibe o histórico completo de movimentações.
Main.java → Interface via terminal com menu interativo, login e controle de operações.

🔮 Melhorias Futuras
- 💾 Integração com banco de dados para persistência de dados (MySQL, PostgreSQL ou SQLite).
- 🆔 Cadastro e autenticação de operadores com níveis de acesso.
- 🔐 Acesso exclusivo para administrador com gestão de permissões.
- 🧱 Expansão da lógica de posições para múltiplos estoques ou setores.
- 🕒 Registro de movimentações com posição exata e auditoria de ações.
- ⚖️ Cálculo de carga total por posição ou entrega.
- 🎨 Interface gráfica para facilitar a interação com o sistema.
- 📋 Registro de tentativas de acesso negadas para segurança e auditoria.

✨ Autor
Desenvolvido por Felipe Saraiva
