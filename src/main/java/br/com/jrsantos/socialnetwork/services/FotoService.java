package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.dtos.FotoDto;
import br.com.jrsantos.socialnetwork.models.Foto;
import br.com.jrsantos.socialnetwork.repositories.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public Foto salvar(FotoDto fotoDto){
        Foto foto = new Foto();
        foto.setCd_foto(fotoDto.cd_foto());
        return fotoRepository.save(foto);
    }
    public Foto atualizarFoto(FotoDto fotoDto, Long id){
        Foto foto = fotoRepository.getReferenceById(id);
        foto.setCd_foto(foto.getCd_foto());
        fotoRepository.save(foto);
        return foto;
    }

    public void excluirFoto(Long id){
        fotoRepository.deleteById(id);
    }

    public Foto getFoto(Long id){
        return fotoRepository.findById(id).get();
    }


}
