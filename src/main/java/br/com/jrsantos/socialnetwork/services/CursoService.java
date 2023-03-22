package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.curso.AreaCursoDto;
import br.com.jrsantos.socialnetwork.dtos.curso.CursoDto;
import br.com.jrsantos.socialnetwork.dtos.curso.SubAreaCursoDto;
import br.com.jrsantos.socialnetwork.dtos.curso.TipoCursoDto;
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

    public AreaCurso cadastrarAreaCurso(AreaCursoDto areaCursoDto){
        AreaCurso areaCurso = new AreaCurso();
        areaCurso.setNomeArea(areaCursoDto.nome());
        areaCurso.setDescricao(areaCursoDto.ds_area());
        areaCursoRepository.save(areaCurso);
        return areaCurso;

    }

    public AreaCurso atualizarAreaCurso(AreaCursoDto areaCursoDto, Long id){
        AreaCurso areaCurso = areaCursoRepository.getReferenceById(id);
        areaCurso.setNomeArea(areaCursoDto.nome());
        areaCurso.setDescricao(areaCursoDto.ds_area());
        areaCursoRepository.save(areaCurso);
        return areaCurso;
    }

    public void excluirAreaCurso(Long id){
        areaCursoRepository.deleteById(id);
    }

    public AreaCurso consultarAreaCursoPorId(Long id){
        return areaCursoRepository.findById(id).get();
    }

    // areaCurso

    public SubAreaCurso cadastrarSubAreaCurso(SubAreaCursoDto subAreaCursoDto){
        SubAreaCurso subAreaCurso = new SubAreaCurso();
        AreaCurso areaCurso = areaCursoRepository.getReferenceById(subAreaCursoDto.area_curso_id());
        subAreaCurso.setNomeSubArea(subAreaCursoDto.nome());
        subAreaCurso.setDescricao(subAreaCursoDto.ds_sub_area());
        subAreaCurso.setArea_curso(areaCurso);
        subAreaCursoRepository.save(subAreaCurso);

        return subAreaCurso;

    }

    public SubAreaCurso atualizarSubAreaCurso(SubAreaCursoDto subAreaCursoDto, Long id){
        SubAreaCurso subAreaCurso = subAreaCursoRepository.getReferenceById(id);
        AreaCurso areaCurso = areaCursoRepository.getReferenceById(subAreaCursoDto.area_curso_id());
        subAreaCurso.setNomeSubArea(subAreaCursoDto.nome());
        subAreaCurso.setDescricao(subAreaCursoDto.ds_sub_area());
        subAreaCurso.setArea_curso(areaCurso);
        subAreaCursoRepository.save(subAreaCurso);
        return subAreaCurso;
    }

    public void excluirSubAreaCurso(Long id){
        subAreaCursoRepository.deleteById(id);
    }

    public SubAreaCurso consultarSubAreaPorId(Long id){
        return subAreaCursoRepository.findById(id).get();
    }

    // subAreaCurso

    public TipoCurso cadastrarTipoCurso(TipoCursoDto tipoCursoDto){
        TipoCurso tipoCurso = new TipoCurso();

        tipoCurso.setNome(tipoCursoDto.nome());
        tipoCurso.setDs_tipo(tipoCursoDto.ds_tipo());
        tipoCursoRepository.save(tipoCurso);
        return tipoCurso;

    }

    public TipoCurso atualizarTipoCurso(TipoCursoDto tipoCursoDto, Long id){
        TipoCurso tipoCurso = tipoCursoRepository.getReferenceById(id);
        tipoCurso.setNome(tipoCursoDto.nome());
        tipoCurso.setDs_tipo(tipoCursoDto.ds_tipo());
        tipoCursoRepository.save(tipoCurso);
        return tipoCurso;
    }

    public void excluirTipoCurso(Long id){
        tipoCursoRepository.deleteById(id);
    }

    public TipoCurso consultarTipoCursoId(Long id){
        return tipoCursoRepository.findById(id).get();
    }


}
