package br.com.quintinodigital.sisgerpesapi.service;

import br.com.quintinodigital.sisgerpesapi.dto.PessoaResponseDTO;
import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import br.com.quintinodigital.sisgerpesapi.model.TipoPessoaModel;
import br.com.quintinodigital.sisgerpesapi.repository.PessoaRepository;
import br.com.quintinodigital.sisgerpesapi.repository.TipoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TipoPessoaRepository tipoPessoaRepository;

    public PessoaModel saveOne(PessoaModel pessoaModel) {
        return this.pessoaRepository.save(pessoaModel);
    }

    public List<PessoaResponseDTO> findAll() {
        List<PessoaResponseDTO> pessoaResponseDTOList = new ArrayList<>();
        for (PessoaModel pessoaModel : this.pessoaRepository.findAll()) {
            PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO();
                pessoaResponseDTO.setCodigo(pessoaModel.getCodigo());
                pessoaResponseDTO.setTipoPessoa(pessoaModel.getTipoPessoaModel().getDescricao());
                pessoaResponseDTO.setNome(pessoaModel.getNome());
                pessoaResponseDTOList.add(pessoaResponseDTO);
        }
        return pessoaResponseDTOList;
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

    public List<TipoPessoaModel> recuperarTipoPessoa() {
        return this.tipoPessoaRepository.findAll();
    }

}
