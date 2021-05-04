package br.com.vinicius.estudo.cursomc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Não é possível excluir categoria com produtos!")
public class PermissionDeniedException extends RuntimeException{
}
