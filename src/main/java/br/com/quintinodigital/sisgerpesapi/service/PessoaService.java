package br.com.quintinodigital.sisgerpesapi.service;

import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import br.com.quintinodigital.sisgerpesapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PessoaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel saveOne(PessoaModel pessoaModel) {
        return this.pessoaRepository.save(pessoaModel);
    }


}
