INSERT INTO produto (id,descricao,preco_unitario) VALUES (10,'televisor',2000.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (20,'geladeira',3500.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (30,'fogao',1200.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (40,'lava-louça',1800.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (50,'lava-roupas',2870.0);
INSERT INTO produto (id,descricao,preco_unitario) VALUES (60,'destruicao-numero-2-midia-fisica',425.95);

INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (100,10,20,5,50);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (200,20,10,5,30);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (300,40,8,5,50);
INSERT INTO item_de_estoque (id, produto_id, quantidade, estoque_min, estoque_max) VALUES (400,60,15,5,50);

INSERT INTO orcamento (id, pais, estado, custo_itens, imp_federal, imp_estadual,
                      desconto, data_criacao, custo_consumidor, efetivado) VALUES (1, 'BR', 'SP', 200.00, 20.00, 10.00,
                                                                                   15.00, CURRENT_DATE, 215.00, FALSE);

INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (50, 2, 100.00, 1);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (20, 1, 100.00, 1);

INSERT INTO orcamento (id, pais, estado, custo_itens, imp_federal, imp_estadual,
                      desconto, data_criacao, custo_consumidor, efetivado) VALUES (2, 'BR', 'SP', 200.00, 20.00, 10.00,
                                                                                   15.00, '2025-05-22', 215.00, TRUE);

INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (20, 2, 100.00, 2);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (30, 1, 100.00, 2);
INSERT INTO item_pedido (id_produto, quantidade, preco, orcamento_id) VALUES (60, 2, 100.00, 2);