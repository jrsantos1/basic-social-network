package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.TurmaCadastroDto;
import br.com.jrsantos.socialnetwork.models.Curso;
import br.com.jrsantos.socialnetwork.models.Turma;
import br.com.jrsantos.socialnetwork.repositories.CursoRepository;
import br.com.jrsantos.socialnetwork.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Turma cadastrar(TurmaCadastroDto turmaCadastroDto){
        Turma turma = toTurmaCadastroResponse(turmaCadastroDto);
        return turmaRepository.save(turma);
    }

    public Turma toTurmaCadastroResponse(TurmaCadastroDto turmaCadastroDto){

        Turma turma = new Turma();

        Curso curso = cursoRepository.getReferenceById(turmaCadastroDto.curso_id());

        turma.setCurso(curso);
        turma.setData(turmaCadastroDto.data());
        turma.setSemestre(turmaCadastroDto.semestre());
        turma.setLetra(turmaCadastroDto.letra());

        return turma;

    }



}
