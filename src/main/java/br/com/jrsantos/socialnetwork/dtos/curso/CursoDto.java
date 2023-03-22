package br.com.jrsantos.socialnetwork.dtos.curso;

import br.com.jrsantos.socialnetwork.models.Instituicao;
import br.com.jrsantos.socialnetwork.models.TipoCurso;

public record CursoDto(String nome, Long tipo, Long area, Long subArea, Integer duracao_em_semestres, Long instituicao) {

}
