INSERT INTO produto (id,descricao,preco_unitario) VALUES (10,'televisor',2000.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (20,'geladeira',3500.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (30,'fogao',1200.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (40,'lava-louça',1800.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (50,'lava-roupas',2870.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (60,'destruicao-numero-2-midia-fisica',425.95);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (70,'cd-genesis-company',150.43);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (80,'expansion-pack-yugioh',123.12);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (90,'farinha*',425.95);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (100,'agua-mineral-5-litros*',9.90);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (110,'arroz-parabolico-1kg*',5.59);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (120,'arroz-conico-1,42kg*',29.23);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (130,'feijao-5kg*',112.56);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (140,'computador-gamer-i9-geracao3-positivo', 5142.11);

INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (100, 10,  20, 5, 50);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (200, 20,  10, 5, 30);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (300, 40,  8,  5, 50);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (400, 60,  15, 5, 50);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (500, 70,  28, 5, 50);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (600, 80,  10, 5, 30);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (700, 90,  8,  5, 100);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (800, 100, 49, 5, 95);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (900, 110, 55, 2, 60);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (1000,120, 31, 6, 73);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (1100,140, 54, 9, 84);

INSERT INTO orcamento (id, pais, estado, custo_itens, imp_federal, imp_estadual,
                      desconto, data_criacao, custo_consumidor, efetivado) VALUES (1, 'BR', 'SP', 200.00, 20.00, 10.00,
                                                                                   15.00, '2025-06-01', 215.00, FALSE);

INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (50, 2, 100.00, 1);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (20, 1, 100.00, 1);

INSERT INTO orcamento (id, pais, estado, custo_itens, imp_federal, imp_estadual,
                      desconto, data_criacao, custo_consumidor, efetivado) VALUES (2, 'BR', 'SP', 200.00, 20.00, 10.00,
                                                                                   15.00, CURRENT_DATE, 215.00, TRUE);

INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (20, 2, 100.00, 2);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (30, 1, 100.00, 2);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (60, 2, 100.00, 2);

INSERT INTO orcamento (id, pais, estado, custo_itens, imp_federal, imp_estadual,
                      desconto, data_criacao, custo_consumidor, efetivado) VALUES (3, 'BR', 'RS', 200.00, 20.00, 10.00,
                                                                                   15.00, CURRENT_DATE, 215.00, TRUE);

INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (70, 2, 100.00, 3);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (80, 1, 100.00, 3);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (140, 2, 100.00, 3);

INSERT INTO orcamento (id, pais, estado, custo_itens, imp_federal, imp_estadual,
                      desconto, data_criacao, custo_consumidor, efetivado) VALUES (4, 'BR', 'PE', 200.00, 20.00, 10.00,
                                                                                  15.00, CURRENT_DATE, 215.00, FALSE);

INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (90, 3, 100.00, 4);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (100, 5, 100.00, 4);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (120, 5, 100.00, 4); 