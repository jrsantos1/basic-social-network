package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.PostagemDto;
import br.com.jrsantos.socialnetwork.models.Conta;
import br.com.jrsantos.socialnetwork.models.Foto;
import br.com.jrsantos.socialnetwork.models.Postagem;
import br.com.jrsantos.socialnetwork.models.Usuario;
import br.com.jrsantos.socialnetwork.repositories.ContaRepository;
import br.com.jrsantos.socialnetwork.repositories.FotoRepository;
import br.com.jrsantos.socialnetwork.repositories.PostagemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private FotoRepository fotoRepository;

    public Postagem toPostagemResponse(PostagemDto postagemDto){

        Foto foto = fotoRepository.findById(postagemDto.foto_id()).orElseThrow(() -> new EntityNotFoundException("A foto não foi localizada"));
        Conta conta = contaRepository.findById(postagemDto.conta_id()).orElseThrow(() -> new EntityNotFoundException("A conta não exite"));

        Postagem postagem = new Postagem();
        postagem.setConta(conta);
        postagem.setFoto(foto);
        postagem.setConteudo(postagemDto.conteudo());
        return postagem;
    }
    public Postagem cadastrar(PostagemDto postagemDto){
        Postagem postagem = toPostagemResponse(postagemDto);
        postagemRepository.save(postagem);
        return postagem;
    }

    public Postagem consultarPorId(Long id){
        Optional<Postagem> postagem = postagemRepository.findById(id);

        if (postagem.isPresent()){
            return postagem.get();
        }else {
            throw new RuntimeException("Postagem não existe");
        }
    }



}
