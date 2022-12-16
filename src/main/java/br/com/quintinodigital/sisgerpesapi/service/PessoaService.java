package br.com.quintinodigital.sisgerpesapi.service;

import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import br.com.quintinodigital.sisgerpesapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel saveOne(PessoaModel pessoaModel) {
        return this.pessoaRepository.save(pessoaModel);
    }

    public List<PessoaModel> findAll() {
        return this.pessoaRepository.findAll();
    }

    public PessoaModel findOne(Long codigo) {
        return this.pessoaRepository.findById(codigo).get();
    }

    public PessoaModel updateOne(PessoaModel pessoaModel) {
        Optional<PessoaModel> pessoaModelOptional = this.pessoaRepository.findById(pessoaModel.getCodigo());
        if(pessoaModelOptional.isPresent()) {
            pessoaModel.setTipoPessoaModel(pessoaModel.getTipoPessoaModel());
            pessoaModel.setNome(pessoaModel.getNome());
        }
        return this.pessoaRepository.save(pessoaModel);
    }

    public void deleteOne(Long codigo) {
        Optional<PessoaModel> pessoaModelOptional = this.pessoaRepository.findById(codigo);
        this.pessoaRepository.deleteById(codigo);
    }


}
