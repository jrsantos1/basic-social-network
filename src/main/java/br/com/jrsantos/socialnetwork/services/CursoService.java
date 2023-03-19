package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.CursoDto;
import br.com.jrsantos.socialnetwork.models.*;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    public Curso toCursoResponse(CursoDto cursoDto, TipoCurso tipoCurso, Instituicao instituicao, AreaCurso areaCurso, SubAreaCurso subAreaCurso){
        Curso curso = new Curso();
        curso.setNome(cursoDto.nome());
        curso.setArea(areaCurso);
        curso.setSub_area(subAreaCurso);
        curso.setTipo(tipoCurso);
        curso.setDuracao_em_semestres(cursoDto.duracao_em_semestres());
        curso.setInstituicao(instituicao);
        return curso;
    }

}
