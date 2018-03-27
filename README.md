# RamsesArquitetura
Simulador de máquina hipotética desenvolvida com fins didáticos como trabalho da disciplina como Arquitetura de Computadores.

# Características
- Quatro modos de endereçamento (direto, indireto, imediato e indexado)
- Dois registradores de uso geral, RA e RB
- Um registrador de índice, RX
- Indicadores de carry, negativo e zero,
- Instruções adicionais ao Neander e o Ahmes com chamada de subrotina, negação e deslocamento de bits, além de outras.

# Conjunto de instruções do Ramses
Para se construir o código binário de uma instrução no Ramses, é preciso concatenar os bits relativos a uma operação, um registrador e um modo de endereçamento. Por exemplo, a instrução 00010000 (em binário), é uma instrução de armazenamento, usando o registrador RA, no modo de endereçamento direto. Caso se queira alterar o registrador de A para B, altera-se o registrador (5° e 6° bits) de 00 para 01. Neste caso, a instrução o binário 00010100. Alterando, desta vez, o modo de endereçamento para indexado, por exemplo, o código da instrução resultaria em 00010111.

