-- BBDD NATMINDS

-- Eliminamos la BBDD por si ya existe y la creamos
drop database if exists natminds;
create database natminds;

-- Usamos la BBDD que hemos creado
use natminds;

-- Creamos la tabla USUARIO
drop table if exists usuario;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(100) NOT NULL UNIQUE,
  `nombre` varchar(500) NOT NULL,
  `primerApellido` varchar(500) NOT NULL,
  `segundoApellido` varchar(500) NOT NULL,
  `mail` varchar(500) NOT NULL,
  `pass` varchar(500) NOT NULL,
  constraint pk_usuario primary key (idUsuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Creamos la tabla POST
drop table if exists post;
CREATE TABLE `post` (
  `idPost` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `texto` varchar(10000) NOT NULL,
  `img` longblob,
  constraint pk_post primary key (idPost),
  constraint fk_idUsu foreign key (idUsuario) references usuario(idUsuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Creamos la tabla COMENTARIOS
drop table if exists comentarios;
CREATE TABLE `comentarios` (
  `idComentario` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `idPost` int NOT NULL,
  `fecha` date NOT NULL,
  `texto` varchar(10000) NOT NULL,
  constraint pk_comentarios primary key (idComentario),
  constraint fk_idUsuario foreign key (idUsuario) references usuario(idUsuario),
  constraint fk_idPost foreign key (idPost) references post(idPost)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Creamos la tabla LIKE
drop table if exists likes;
CREATE TABLE `likes` (
  `idPost` int NOT NULL,
  `idUsuario` int NOT NULL,
  constraint primary key (idPost, idUsuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Creamos la tabla SEGUIR
-- Esta creo que está mal... 
drop table if exists seguir;
CREATE TABLE `seguir` (
  `idUsuario` int NOT NULL,
  `nombreUsuario` int NOT NULL,
  constraint primary key (idUsuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;