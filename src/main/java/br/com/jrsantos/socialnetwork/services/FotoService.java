package br.com.jrsantos.socialnetwork.services;

import br.com.jrsantos.socialnetwork.models.Foto;
import br.com.jrsantos.socialnetwork.repositories.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public Foto salvar(byte[] cd_foto){
        Foto foto = new Foto();
        foto.setCd_foto(cd_foto);
        return fotoRepository.save(foto);
    }


}
