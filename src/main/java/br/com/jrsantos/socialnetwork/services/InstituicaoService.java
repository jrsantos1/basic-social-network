package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.InstiuicaoDto;
import br.com.jrsantos.socialnetwork.models.Instituicao;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {
    public Instituicao toInstituicaoResponse(InstiuicaoDto instiuicaoDto){
        Instituicao instituicao = new Instituicao();
        instituicao.setNome(instiuicaoDto.nome());
        instituicao.setUnidade(instiuicaoDto.unidade());
        instituicao.setCidade(instiuicaoDto.cidade());
        instituicao.setEstado(instiuicaoDto.estado());
        return instituicao;

    }
}
