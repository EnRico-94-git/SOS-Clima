-- Inserir locais
INSERT INTO local (id, cidade, pais) VALUES
(1, 'São Paulo', 'Brasil'),
(2, 'Nova Orleans', 'EUA'),
(3, 'Tóquio', 'Japão');

-- Inserir recomendações
INSERT INTO recomendacao (id, descricao) VALUES
(1, 'Evite áreas baixas e próximas a rios. Mantenha-se em local elevado e seguro.'),
(2, 'Abasteça-se de água e alimentos não perecíveis. Desligue equipamentos elétricos.'),
(3, 'Use máscara para proteção contra fumaça. Mantenha-se informado sobre as rotas de evacuação.');

-- Inserir eventos climáticos
INSERT INTO evento (id, tipo, nivel, local_id, recomendacao_id) VALUES
(1, 'ENCHENTE', 8, 1, 1),
(2, 'FURACAO', 9, 2, 2),
(3, 'INCENDIO', 7, 3, 3);