insert into usuario (email, nome, telefone, criado_em, foto_url, senha, ativo) values ('natassia@cwi.com.br', 'Natássia Terribele', '(51) 99999-8888', CURRENT_TIMESTAMP, 'https://sebraers.com.br/wp-content/uploads/2019/05/guri-de-uruguaiana_normal.jpg', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true);
insert into usuario (email, nome, telefone, criado_em, foto_url, senha, ativo) values ('dieison@cwi.com.br', 'Dieison Micael', '(51) 99999-8888', CURRENT_TIMESTAMP, 'https://2.bp.blogspot.com/-6RRI4xPE_qg/W8sc-WwDMrI/AAAAAAAAZf8/VA450oOkbngYjXMVh1KWN8s-EtLRRyWAgCLcBGAs/s1600/capitao%2Brodrigo%2BLacerda.jpg', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true);

insert into permissao (funcao, id_usuario) values ('ADMIN', 1);
insert into permissao (funcao, id_usuario) values ('USUARIO', 2);


