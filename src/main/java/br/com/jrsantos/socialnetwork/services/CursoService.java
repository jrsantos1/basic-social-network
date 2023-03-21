package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.CursoDto;
import br.com.jrsantos.socialnetwork.models.*;
import br.com.jrsantos.socialnetwork.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private TipoCursoRepository tipoCursoRepository;

    @Autowired
    private AreaCursoRepository areaCursoRepository;

    @Autowired
    private SubAreaCursoRepository subAreaCursoRepository;

    @Autowired
    private CursoRepository cursoRepository;
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

    public Curso templateCadastro(CursoDto cursoDto, Curso curso){

        TipoCurso tipoCurso = tipoCursoRepository.findById(cursoDto.tipo()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        Instituicao instituicao = instituicaoRepository.findById(cursoDto.instituicao()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        AreaCurso areaCurso = areaCursoRepository.findById(cursoDto.area()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        SubAreaCurso subAreaCurso = subAreaCursoRepository.findById(cursoDto.subArea()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));

        curso = toCursoResponse(cursoDto, tipoCurso, instituicao, areaCurso, subAreaCurso);

        return curso;

    }

    public Curso cadastrar(CursoDto cursoDto){

    Curso curso = new Curso();

    Curso cursoCriado = templateCadastro(cursoDto,curso);

    cursoRepository.save(cursoCriado);

    return cursoCriado;

    }

    public Curso atualizarCurso(CursoDto cursoDto, Long id){

        Curso curso = cursoRepository.getReferenceById(id);
        Curso cursoAtualizado = templateCadastro(cursoDto, curso);
        cursoRepository.save(cursoAtualizado);
        return cursoAtualizado;

    }

    public Curso excluir(Long id){
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));
        cursoRepository.delete(curso);
        return curso;
    }



    public Curso consultarPorId(Long id){
        Optional<Curso> curso = cursoRepository.findById(id);

        if (curso.isPresent()){
            return curso.get();
        }else {
            throw new RuntimeException("Curso não existe");
        }
    }

}
