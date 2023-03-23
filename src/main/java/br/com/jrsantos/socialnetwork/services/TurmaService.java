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
        Turma turma = new Turma();
        Turma turmaCriada = toTurmaCadastroResponse(turmaCadastroDto, turma);
        return turmaRepository.save(turmaCriada);
    }


    public Turma toTurmaCadastroResponse(TurmaCadastroDto turmaCadastroDto, Turma turma){
        Curso curso = cursoRepository.getReferenceById(turmaCadastroDto.curso_id());
        turma.setCurso(curso);
        turma.setData(turmaCadastroDto.data());
        turma.setSemestre(turmaCadastroDto.semestre());
        turma.setLetra(turmaCadastroDto.letra());
        return turma;
    }

    public Turma atualizarTurma(TurmaCadastroDto turmaCadastroDto, Long id){
        Turma turma = turmaRepository.getReferenceById(id);
         toTurmaCadastroResponse(turmaCadastroDto, turma);
         turmaRepository.save(turma);
         return turma;
    }

    public void excluirTurma(Long id){
        turmaRepository.deleteById(id);
    }

    public Turma getTurma(Long id){
        return turmaRepository.findById(id).get();
    }


}
