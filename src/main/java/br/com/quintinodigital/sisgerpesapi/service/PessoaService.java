package br.com.quintinodigital.sisgerpesapi.service;

import br.com.quintinodigital.sisgerpesapi.dto.PessoaResponseDTO;
import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import br.com.quintinodigital.sisgerpesapi.repository.PessoaRepository;
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

    public PessoaResponseDTO findOne(Long codigo) {
        PessoaModel pessoaModel = this.pessoaRepository.findById(codigo).get();
        PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO();
            pessoaResponseDTO.setCodigo(pessoaModel.getCodigo());
            pessoaResponseDTO.setTipoPessoa(pessoaModel.getTipoPessoaModel().getDescricao());
            pessoaResponseDTO.setNome(pessoaModel.getNome());
        return pessoaResponseDTO;
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
