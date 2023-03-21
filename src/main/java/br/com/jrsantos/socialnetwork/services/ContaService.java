package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.ContaDto;
import br.com.jrsantos.socialnetwork.dtos.ContaRetornoDto;
import br.com.jrsantos.socialnetwork.models.*;
import br.com.jrsantos.socialnetwork.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FotoService fotoService;

    @Autowired
    private ContaRepository contaRepository;
    public Conta consultarPorId(Long id){
        Optional<Conta> conta = contaRepository.findById(id);
        if(conta.isPresent()){
            return conta.get();
        }else {
            throw new EntityNotFoundException("A conta não existe");
        }
    }

    public ContaRetornoDto toContaRetornoResponse(Conta conta){
        ContaRetornoDto contaRetornoDto = new ContaRetornoDto(conta.getCpf(),
                conta.getSobre(),
                conta.getData_nascimento(),
                conta.getSobre(),
                conta.getCurso(),
                conta.getTurma());

        return contaRetornoDto;

    }
    public Conta cadastrar(ContaDto contaDto){
        Conta conta = new Conta();

        Curso curso = cursoRepository.findById(contaDto.curso_id()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        Turma turma = turmaRepository.findById(contaDto.turma_id()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));
        Usuario usuario = usuarioRepository.findById(contaDto.usuario_id()).orElseThrow(() -> new EntityNotFoundException("Entidade não mapeada"));

        if (contaDto.cd_foto() != null){

            byte[] cd_foto = contaDto.cd_foto();
            Foto foto = fotoService.salvar(cd_foto);
            conta.setFoto(foto);
        }

        conta.setCpf(contaDto.cpf());
        conta.setNome(contaDto.nome());
        conta.setSobre(contaDto.sobre());
        conta.setData_nascimento(contaDto.data_nascimento());
        conta.setTurma(turma);
        conta.setCurso(curso);
        conta.setInstituicao(curso.getInstituicao());
        conta.setUsuario(usuario);

        return contaRepository.save(conta);

    }

}
