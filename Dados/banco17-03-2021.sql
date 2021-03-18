-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.11-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura para tabela sist.caixa
CREATE TABLE IF NOT EXISTS `caixa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataCaixa` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `totalGeral` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Caixa diario';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `cidade` varchar(150) NOT NULL,
  `uf` char(2) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `bairro` varchar(150) NOT NULL,
  `numero` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.formapagamento
CREATE TABLE IF NOT EXISTS `formapagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `parcelado` int(11) NOT NULL,
  `parcelamento` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabela para armazenar a forma de pagamento\r\nparcelamento ex: 30/60/90';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.fornecedor
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fornecedor` varchar(200) NOT NULL,
  `cidade` varchar(200) NOT NULL,
  `uf` char(2) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `bairro` varchar(150) NOT NULL,
  `numero` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.itvenda
CREATE TABLE IF NOT EXISTS `itvenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_venda` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `descProduto` varchar(150) NOT NULL,
  `quantidade` int(11) NOT NULL DEFAULT 0,
  `valorUnit` double(22,2) NOT NULL,
  `subtotal` double(22,2) NOT NULL,
  `total` double(22,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8mb4 COMMENT='nessa table armazena os itens da venda';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.linha
CREATE TABLE IF NOT EXISTS `linha` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomeLinha` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMarca` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.movcaixa
CREATE TABLE IF NOT EXISTS `movcaixa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_caixa` int(11) NOT NULL,
  `id_venda` int(11) NOT NULL,
  `dataMov` date NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `origemMov` varchar(50) NOT NULL,
  `formPag` varchar(50) NOT NULL,
  `valor` double(22,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='Tabela para receber movimentações do caixa, entrada e saida de valores no caixa.\r\nA ideia é fazer uma procedure de entrada e outra procedure de saida de valores \r\ne quando for preciso no sistema, apenas chamar a procedure e passar os parametros.\r\ntipo=> entrada ou saida\r\norigem => venda, sangria, suprimento\r\ntipoMov => dinheiro, cartao, cheque';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(200) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_linha` int(11) NOT NULL,
  `estoque` int(11) NOT NULL,
  `pcompra` double(22,2) NOT NULL,
  `pvenda` double(22,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_marca` (`id_marca`),
  KEY `id_linha` (`id_linha`),
  CONSTRAINT `FK_produto_linha` FOREIGN KEY (`id_linha`) REFERENCES `linha` (`id`),
  CONSTRAINT `FK_produto_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `perfilUser` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='Tabela de armazenar dados de usuario';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sist.venda
CREATE TABLE IF NOT EXISTS `venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `situacao` varchar(50) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `qtd_item` double(22,2) NOT NULL,
  `dataVenda` date NOT NULL,
  `formaPag` varchar(50) NOT NULL,
  `valorTotal` double(22,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COMMENT='Tabela para armazenar as vendas';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para procedure sist.addItVendas
DELIMITER //
CREATE PROCEDURE `addItVendas`(
	IN `idVenda` INT,
	IN `idProduto` INT,
	IN `descProd` VARCHAR(150),
	IN `qtdProduto` INT,
	IN `valorUnit` DOUBLE,
	IN `subtotal` DOUBLE,
	IN `vlrTotal` DOUBLE
)
BEGIN
	INSERT INTO itvenda(id_venda, id_produto, descProduto, quantidade, valorUnit, subtotal, total) 
	VALUES(idVenda, idProduto, descProd, qtdProduto, valorUnit, subtotal, vlrTotal);
END//
DELIMITER ;

-- Copiando estrutura para procedure sist.addVenda
DELIMITER //
CREATE PROCEDURE `addVenda`(
	IN `idCliente` INT,
	IN `idUsuario` INT,
	IN `qtdItemVenda` DOUBLE,
	IN `dataVenda` DATE,
	IN `formPag` VARCHAR(50),
	IN `vlrTotal` DOUBLE
)
    COMMENT 'Quando disparado adiciona a venda e os itens da mesma.'
BEGIN
	INSERT INTO venda(situacao, id_cliente, id_usuario, qtd_item, dataVenda, formaPag, valorTotal) 
	VALUES('ATIVA', idCliente, idUsuario, qtdItemVenda, dataVenda, formPag, vlrTotal);	
END//
DELIMITER ;

-- Copiando estrutura para procedure sist.cancVenda
DELIMITER //
CREATE PROCEDURE `cancVenda`(
	IN `idVenda` INT
)
BEGIN
	UPDATE venda SET situacao = 'CANCELADA'
	WHERE id = idVenda;
END//
DELIMITER ;

-- Copiando estrutura para procedure sist.entradaEstoque
DELIMITER //
CREATE PROCEDURE `entradaEstoque`(
	IN `idProduto` INT,
	IN `quantidadeEntrada` INT
)
BEGIN
	UPDATE produto SET estoque = estoque + quantidadeEntrada
	WHERE id = idProduto;
END//
DELIMITER ;

-- Copiando estrutura para procedure sist.entradaMovCaixa
DELIMITER //
CREATE PROCEDURE `entradaMovCaixa`(
	IN `idCaixa` INT,
	IN `idVenda` INT,
	IN `dataMov` DATE,
	IN `tipo` VARCHAR(50),
	IN `origemMov` VARCHAR(50),
	IN `tipoMov` VARCHAR(50),
	IN `valor` DOUBLE
)
BEGIN

INSERT INTO movcaixa(id_caixa, id_venda, dataMov, tipo, origemMov, formPag, valor) 
VALUES(idCaixa, idVenda, datamov, tipo, origemMov, tipoMov, valor);	

END//
DELIMITER ;

-- Copiando estrutura para procedure sist.saidaEstoque
DELIMITER //
CREATE PROCEDURE `saidaEstoque`(
	IN `idProduto` INT,
	IN `quantidadeVend` INT
)
BEGIN
	UPDATE produto SET estoque = estoque - quantidadeVend
	WHERE id = idProduto;
END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
