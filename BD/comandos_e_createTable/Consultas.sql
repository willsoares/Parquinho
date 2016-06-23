insert into Funcionario (nome, sobrenome, salario, cpf, sexo, idGerente) values ("Hugo", "Pinto", 500, 42473018880, "masculino", 1);
insert into Produto (idProduto, nome, marca, tipo, preco) values (0, "Dogão", "Pif-Paf", "Alimento", 5);
insert into Atracao (idAtracao, nome, tipo, dataManutencao, status) values (2, "Barco Viking", "Radical", 2015-02-03, 1);
insert into Loja (idLoja, nome, categoria, local) values (5, "Cenoura & Bronze", "Bronzeamento Artificial", "Setor Aquático");
insert into TrabalhaEm (idFuncionario, idAtracao, dataInicio) values (3, 1, "2015-07-02"); 

delete from Funcionario where idFuncionario = 0;
delete from Produto where idProduto = 0;
delete from Atracao where idAtracao = 2;
delete from TrabalhaEm where idFuncionario = 3;

update Funcionario set cargo = "Proprietário" where idFuncionario = 0;
update Produto set preco = 10 where idProduto = 0;
update Atracao set status = 0 where idAtracao = 2;
update Funcionario set salario = 5000 where idFuncionario = 0;
update Funcionario set salario = 3500 where idFuncionario = 1;
update Funcionario set salario = 4000 where idFuncionario = 2;

-- Funcionarios que recebem mais que 1000 e trabalham em mais de uma atração por ordem alfabética
select * from Funcionario as f where f.idFuncionario in
(select t.idFuncionario from TrabalhaEm as t 
where f.salario > 1000 
group by t.idFuncionario
having count(t.idAtracao) > 1 
order by (nome) asc);

-- Funcionários que contenham a palavra Zé no nome em ordem decrescente pelo sobrenome
select nome, sobrenome, cargo from Funcionario 
where nome like "%Zé%" 
order by (sobrenome) desc;

-- Lojas que possuem mais de um funcionário
select nome, local, count(idFuncionario) 
from Loja natural join Loja_has_Funcionario 
group by idLoja 
having count(idFuncionario) > 1;

-- Produto com maior quantidade no estoque
select nome, quantidade 
from Produto natural join Estoque 
where quantidade in 
(select max(quantidade) from Estoque);

-- Nome e salário dos funcionários que ganham mais de 3000 ou são gerentes.
(select nome, salario from Funcionario 
where salario > 3000)
union
(select nome, salario from Funcionario 
where idFuncionario in 
(select distinct idGerente from Funcionario));

-- Nome, sobrenome e salário dos funcionários que ganham mais do que todos os gerentes.
select f.nome, f.sobrenome, f.salario 
from Funcionario as f 
where f.salario > all 
(select salario from Funcionario where idFuncionario in 
(select distinct idGerente from Funcionario));

-- Loja com maior variedade de produtos distintos
select nome from Loja where idLoja in 
(select idLoja from Estoque 
group by (idLoja) 
having count(idProduto) > all 
(select idLoja from Estoque 
group by (idLoja) 
having count(idProduto)));

-- Loja com maior variedade de produtos distintos
select nome from Loja where idLoja in 
(select idLoja from Estoque 
group by (idLoja) 
having count(idProduto) > all 
(select idLoja from Estoque 
group by (idLoja) 
having count(idProduto)));

-- Selecionar o cargo dos funcionarios que trabalham na Cobra desde antes de 2015
Select f.cargo from Funcionario as f 
where f.idFuncionario in 
(select t.idFuncionario from TrabalhaEm as t 
where t.idAtracao in 
(select a.idAtracao from Atracao as a 
where nome='Cobra'));

-- Mostre o nome e o cpf do funcionario que tem 69 no cpf e é gerente
Select nome, cpf from Funcionario 
where cpf like '%69%' and 
idGerente = idFuncionario;

-- Mostre o nome e o salario do gerente
select nome, salario from Funcionario 
where idFuncionario = idGerente;

-- Selecionar o nome dos funcionarios que trabalham em atrações que não estão funcionando (status = 0)
select f.nome from Funcionario as f 
where f.idFuncionario in 
(select t.idFuncionario from TrabalhaEm as t 
where t.idAtracao in 
(select a.idAtracao from Atracao as a 
where status=0));

-- Selecione o nome e a data de manutenção da atração com a manutenção mais antiga
Select nome, dataManutencao 
from Atracao 
having min(dataManutencao);