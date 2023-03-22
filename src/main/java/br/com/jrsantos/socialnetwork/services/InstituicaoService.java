package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.InstiuicaoDto;
import br.com.jrsantos.socialnetwork.models.Instituicao;
import br.com.jrsantos.socialnetwork.repositories.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {

    @Autowired
    InstituicaoRepository instituicaoRepository;
    public Instituicao toInstituicaoResponse(InstiuicaoDto instiuicaoDto){
        Instituicao instituicao = new Instituicao();
        instituicao.setNome(instiuicaoDto.nome());
        instituicao.setUnidade(instiuicaoDto.unidade());
        instituicao.setCidade(instiuicaoDto.cidade());
        instituicao.setEstado(instiuicaoDto.estado());
        return instituicao;

    }

    public void excluirInstituicao(Long id){
        instituicaoRepository.deleteById(id);
    }

    public Instituicao atualizarInstituicao(InstiuicaoDto instiuicaoDto, Long id){
        Instituicao instituicao = instituicaoRepository.getReferenceById(id);
        instituicao.setNome(instiuicaoDto.nome());
        instituicao.setEstado(instiuicaoDto.estado());
        instituicao.setCidade(instiuicaoDto.cidade());
        instituicao.setUnidade(instiuicaoDto.unidade());
        instituicaoRepository.save(instituicao);
        return instituicao;
    }


    public Instituicao getInstituicao(Long id){
        return instituicaoRepository.getReferenceById(id);
    }

    public Instituicao cadastrarInstituicao(InstiuicaoDto instiuicaoDto){
        Instituicao instituicao = new Instituicao();
        instituicao.setNome(instiuicaoDto.nome());
        instituicao.setEstado(instiuicaoDto.estado());
        instituicao.setCidade(instiuicaoDto.cidade());
        instituicao.setUnidade(instiuicaoDto.unidade());
        instituicaoRepository.save(instituicao);
        return instituicao;
    }

}
