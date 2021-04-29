package br.com.vinicius.estudo.cursomc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Categoria não encontrada!")
public class CategoryNotFoundException extends RuntimeException{
}
