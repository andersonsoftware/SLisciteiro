--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2017-12-08 22:59:20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 206 (class 1259 OID 17344)
-- Name: categoria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE categoria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categoria_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 17285)
-- Name: Categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Categoria" (
    id_categoria integer DEFAULT nextval('categoria_id_seq'::regclass) NOT NULL,
    nome character varying(60),
    id_setor integer
);


ALTER TABLE "Categoria" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 17235)
-- Name: Conta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Conta" (
    login character varying(60) NOT NULL,
    senha character varying NOT NULL,
    id_pessoa integer NOT NULL,
    tipo_usuario integer NOT NULL
);


ALTER TABLE "Conta" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 17261)
-- Name: Fornecedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Fornecedor" (
    id_fornecedor integer NOT NULL,
    cnpj character varying(60) NOT NULL,
    pontuacao integer NOT NULL,
    conta_bancaria character varying(15),
    agencia_bancaria character varying(15),
    tipo_conta character varying(20),
    banco character varying(20)
);


ALTER TABLE "Fornecedor" OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17359)
-- Name: FornecedorCategoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "FornecedorCategoria" (
    id_fornecedor integer NOT NULL,
    id_categoria integer NOT NULL
);


ALTER TABLE "FornecedorCategoria" OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 17247)
-- Name: Funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Funcionario" (
    id_funcionario integer NOT NULL,
    cargo integer NOT NULL,
    rg character varying(60) NOT NULL,
    cpf character varying(60) NOT NULL
);


ALTER TABLE "Funcionario" OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17350)
-- Name: licitacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE licitacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE licitacao_id_seq OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17276)
-- Name: Licitacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Licitacao" (
    id_licitacao integer DEFAULT nextval('licitacao_id_seq'::regclass) NOT NULL,
    descricao character varying(60),
    id_funcionario integer NOT NULL,
    id_categoria integer NOT NULL,
    valor_estimado real NOT NULL,
    lancado boolean NOT NULL,
    data_inicio date,
    data_fim date,
    id_fornecedor integer,
    estado boolean NOT NULL
);


ALTER TABLE "Licitacao" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17282)
-- Name: LicitacaoProduto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "LicitacaoProduto" (
    id_licitacao integer NOT NULL,
    id_produto integer NOT NULL,
    quantidade integer NOT NULL
);


ALTER TABLE "LicitacaoProduto" OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 17227)
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 17220)
-- Name: Pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Pessoa" (
    id_pessoa integer DEFAULT nextval('pessoa_id_seq'::regclass) NOT NULL,
    nome character varying(60) NOT NULL,
    email character varying(60) NOT NULL,
    endereco character varying(60) NOT NULL,
    telefone character varying(20) NOT NULL
);


ALTER TABLE "Pessoa" OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17346)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE produto_id_seq OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17279)
-- Name: Produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Produto" (
    id_produto integer DEFAULT nextval('produto_id_seq'::regclass) NOT NULL,
    nome character varying(60) NOT NULL,
    descricao character varying(60) NOT NULL,
    id_categoria integer NOT NULL,
    valor_estimado real NOT NULL
);


ALTER TABLE "Produto" OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 17348)
-- Name: setor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE setor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE setor_id_seq OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 17273)
-- Name: Setor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Setor" (
    id_setor integer DEFAULT nextval('setor_id_seq'::regclass) NOT NULL,
    nome character varying(60) NOT NULL,
    id_gerente integer NOT NULL,
    teto_gastos real NOT NULL
);


ALTER TABLE "Setor" OWNER TO postgres;

--
-- TOC entry 2894 (class 0 OID 17285)
-- Dependencies: 205
-- Data for Name: Categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Categoria" (id_categoria, nome, id_setor) FROM stdin;
1	Ferramentas	1
\.


--
-- TOC entry 2887 (class 0 OID 17235)
-- Dependencies: 198
-- Data for Name: Conta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Conta" (login, senha, id_pessoa, tipo_usuario) FROM stdin;
matheus	B7E94BE513E96E8C45CD23D162275E5A12EBDE9100A425C4EBCDD7FA4DCD897C	1	1
cicero	B7E94BE513E96E8C45CD23D162275E5A12EBDE9100A425C4EBCDD7FA4DCD897C	4	2
anderson	B7E94BE513E96E8C45CD23D162275E5A12EBDE9100A425C4EBCDD7FA4DCD897C	2	1
rogerio	B7E94BE513E96E8C45CD23D162275E5A12EBDE9100A425C4EBCDD7FA4DCD897C	3	1
\.


--
-- TOC entry 2889 (class 0 OID 17261)
-- Dependencies: 200
-- Data for Name: Fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Fornecedor" (id_fornecedor, cnpj, pontuacao, conta_bancaria, agencia_bancaria, tipo_conta, banco) FROM stdin;
4	55.555.555/5555-55	50	9220-7	4572-1	CONTA CORRENTE	BANCO DO BRASIL
\.


--
-- TOC entry 2899 (class 0 OID 17359)
-- Dependencies: 210
-- Data for Name: FornecedorCategoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "FornecedorCategoria" (id_fornecedor, id_categoria) FROM stdin;
4	1
\.


--
-- TOC entry 2888 (class 0 OID 17247)
-- Dependencies: 199
-- Data for Name: Funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Funcionario" (id_funcionario, cargo, rg, cpf) FROM stdin;
1	1	2017989504-6	090.959.356-00
2	2	2777989777-6	795.555.555-00
3	3	8888989777-6	888.888.555-00
\.


--
-- TOC entry 2891 (class 0 OID 17276)
-- Dependencies: 202
-- Data for Name: Licitacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Licitacao" (id_licitacao, descricao, id_funcionario, id_categoria, valor_estimado, lancado, data_inicio, data_fim, id_fornecedor, estado) FROM stdin;
\.


--
-- TOC entry 2893 (class 0 OID 17282)
-- Dependencies: 204
-- Data for Name: LicitacaoProduto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "LicitacaoProduto" (id_licitacao, id_produto, quantidade) FROM stdin;
\.


--
-- TOC entry 2885 (class 0 OID 17220)
-- Dependencies: 196
-- Data for Name: Pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Pessoa" (id_pessoa, nome, email, endereco, telefone) FROM stdin;
1	Matheus de Souza Oliveira	matheusesoft@alu.ufc.br	Tv. 15 de Novembro, nº 79	(88)8803-3133
2	Anderson Alexandre Paz Cardoso	andersonsoftware@alu.ufc.br	Tv. 15 de Novembro, nº 79	(88)8856-3133
3	Rogério Sena Leitão	rogeriosena@alu.ufc.br	Tv. 15 de Novembro, nº 88	(88)8866-3166
4	Cicero Romão Bezerra da Silva	cicinhoimportados@alu.ufc.br	Tv. 15 de Novembro, nº 79	(85)9466-3166
\.


--
-- TOC entry 2892 (class 0 OID 17279)
-- Dependencies: 203
-- Data for Name: Produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Produto" (id_produto, nome, descricao, id_categoria, valor_estimado) FROM stdin;
1	Vassoura	Utilizado para limpeza do chão	1	12.8999996
2	Rôdo	Utilizado para limpeza do chão	1	9.89999962
3	Luvas de silicone	Utilizado higiêne e proteção do funcionário	1	9.96000004
\.


--
-- TOC entry 2890 (class 0 OID 17273)
-- Dependencies: 201
-- Data for Name: Setor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Setor" (id_setor, nome, id_gerente, teto_gastos) FROM stdin;
1	Setor de limpeza	3	500
\.


--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 206
-- Name: categoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('categoria_id_seq', 1, true);


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 209
-- Name: licitacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('licitacao_id_seq', 1, false);


--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 197
-- Name: pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pessoa_id_seq', 4, true);


--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 207
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('produto_id_seq', 3, true);


--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 208
-- Name: setor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('setor_id_seq', 1, true);


--
-- TOC entry 2735 (class 2606 OID 17267)
-- Name: Fornecedor cnpj; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Fornecedor"
    ADD CONSTRAINT cnpj UNIQUE (cnpj);


--
-- TOC entry 2729 (class 2606 OID 17255)
-- Name: Funcionario cpf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Funcionario"
    ADD CONSTRAINT cpf UNIQUE (cpf);


--
-- TOC entry 2721 (class 2606 OID 17226)
-- Name: Pessoa email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Pessoa"
    ADD CONSTRAINT email UNIQUE (email);


--
-- TOC entry 2725 (class 2606 OID 17241)
-- Name: Conta id_conta_pessoa; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Conta"
    ADD CONSTRAINT id_conta_pessoa UNIQUE (id_pessoa);


--
-- TOC entry 2723 (class 2606 OID 17224)
-- Name: Pessoa id_pessoa; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Pessoa"
    ADD CONSTRAINT id_pessoa PRIMARY KEY (id_pessoa);


--
-- TOC entry 2727 (class 2606 OID 17239)
-- Name: Conta login; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Conta"
    ADD CONSTRAINT login PRIMARY KEY (login);


--
-- TOC entry 2749 (class 2606 OID 17297)
-- Name: Categoria nome_categoria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Categoria"
    ADD CONSTRAINT nome_categoria UNIQUE (nome);


--
-- TOC entry 2745 (class 2606 OID 17301)
-- Name: Produto nome_produto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Produto"
    ADD CONSTRAINT nome_produto UNIQUE (nome);


--
-- TOC entry 2739 (class 2606 OID 17291)
-- Name: Setor nome_setor; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Setor"
    ADD CONSTRAINT nome_setor UNIQUE (nome);


--
-- TOC entry 2751 (class 2606 OID 17295)
-- Name: Categoria pk_id_categoria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Categoria"
    ADD CONSTRAINT pk_id_categoria PRIMARY KEY (id_categoria);


--
-- TOC entry 2731 (class 2606 OID 17251)
-- Name: Funcionario pk_id_funcionario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Funcionario"
    ADD CONSTRAINT pk_id_funcionario PRIMARY KEY (id_funcionario);


--
-- TOC entry 2743 (class 2606 OID 17318)
-- Name: Licitacao pk_id_licitacao; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Licitacao"
    ADD CONSTRAINT pk_id_licitacao PRIMARY KEY (id_licitacao);


--
-- TOC entry 2737 (class 2606 OID 17265)
-- Name: Fornecedor pk_id_pessoa; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Fornecedor"
    ADD CONSTRAINT pk_id_pessoa PRIMARY KEY (id_fornecedor);


--
-- TOC entry 2747 (class 2606 OID 17299)
-- Name: Produto pk_id_produto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Produto"
    ADD CONSTRAINT pk_id_produto PRIMARY KEY (id_produto);


--
-- TOC entry 2741 (class 2606 OID 17289)
-- Name: Setor pk_id_setor; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Setor"
    ADD CONSTRAINT pk_id_setor PRIMARY KEY (id_setor);


--
-- TOC entry 2733 (class 2606 OID 17253)
-- Name: Funcionario rg; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Funcionario"
    ADD CONSTRAINT rg UNIQUE (rg);


--
-- TOC entry 2755 (class 2606 OID 17402)
-- Name: Licitacao fky_id_categoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Licitacao"
    ADD CONSTRAINT fky_id_categoria FOREIGN KEY (id_categoria) REFERENCES "Categoria"(id_categoria) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2758 (class 2606 OID 17427)
-- Name: Produto fky_id_categoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Produto"
    ADD CONSTRAINT fky_id_categoria FOREIGN KEY (id_categoria) REFERENCES "Categoria"(id_categoria) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2757 (class 2606 OID 17412)
-- Name: Licitacao fky_id_fornecedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Licitacao"
    ADD CONSTRAINT fky_id_fornecedor FOREIGN KEY (id_fornecedor) REFERENCES "Fornecedor"(id_fornecedor) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2756 (class 2606 OID 17407)
-- Name: Licitacao fky_id_funcionario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Licitacao"
    ADD CONSTRAINT fky_id_funcionario FOREIGN KEY (id_funcionario) REFERENCES "Funcionario"(id_funcionario) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2759 (class 2606 OID 17417)
-- Name: LicitacaoProduto fky_id_licitacao; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "LicitacaoProduto"
    ADD CONSTRAINT fky_id_licitacao FOREIGN KEY (id_licitacao) REFERENCES "Licitacao"(id_licitacao) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2752 (class 2606 OID 17377)
-- Name: Conta fky_id_pessoa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Conta"
    ADD CONSTRAINT fky_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES "Pessoa"(id_pessoa) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2754 (class 2606 OID 17382)
-- Name: Fornecedor fky_id_pessoa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Fornecedor"
    ADD CONSTRAINT fky_id_pessoa FOREIGN KEY (id_fornecedor) REFERENCES "Pessoa"(id_pessoa) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2753 (class 2606 OID 17397)
-- Name: Funcionario fky_id_pessoa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Funcionario"
    ADD CONSTRAINT fky_id_pessoa FOREIGN KEY (id_funcionario) REFERENCES "Pessoa"(id_pessoa) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2760 (class 2606 OID 17422)
-- Name: LicitacaoProduto fky_id_produto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "LicitacaoProduto"
    ADD CONSTRAINT fky_id_produto FOREIGN KEY (id_produto) REFERENCES "Produto"(id_produto) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2761 (class 2606 OID 17372)
-- Name: Categoria fky_id_setor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Categoria"
    ADD CONSTRAINT fky_id_setor FOREIGN KEY (id_setor) REFERENCES "Setor"(id_setor) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2762 (class 2606 OID 17387)
-- Name: FornecedorCategoria id_categoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "FornecedorCategoria"
    ADD CONSTRAINT id_categoria FOREIGN KEY (id_categoria) REFERENCES "Categoria"(id_categoria) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2763 (class 2606 OID 17392)
-- Name: FornecedorCategoria id_fornecedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "FornecedorCategoria"
    ADD CONSTRAINT id_fornecedor FOREIGN KEY (id_fornecedor) REFERENCES "Fornecedor"(id_fornecedor) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2017-12-08 22:59:20

--
-- PostgreSQL database dump complete
--

