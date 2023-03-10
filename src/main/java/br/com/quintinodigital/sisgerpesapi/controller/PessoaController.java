package br.com.quintinodigital.sisgerpesapi.controller;

import br.com.quintinodigital.sisgerpesapi.dto.PessoaResponseDTO;
import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import br.com.quintinodigital.sisgerpesapi.model.TipoPessoaModel;
import br.com.quintinodigital.sisgerpesapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pessoa")
@CrossOrigin("*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaModel saveOne(@RequestBody @Valid PessoaModel pessoaModel) {
        return this.pessoaService.saveOne(pessoaModel);
    }

    @GetMapping
    public List<PessoaResponseDTO> findAll() {
        return this.pessoaService.findAll();
    }

    @GetMapping("/{codigo}")
    public PessoaModel findOne(@PathVariable("codigo") UUID codigo) {
        return this.pessoaService.findOne(codigo);
    }

    @PutMapping("/{codigo}")
    public PessoaModel updateOne(@RequestBody PessoaModel pessoaModel, @PathVariable("codigo") UUID codigo) {
        pessoaModel.setCodigo(codigo);
        return this.pessoaService.updateOne(pessoaModel);
    }

    @DeleteMapping("/{codigo}")
    public void deleteOne(@PathVariable("codigo") UUID codigo) {
        this.pessoaService.deleteOne(codigo);
    }

    @GetMapping("/tipo-pessoa")
    public List<TipoPessoaModel> recuperarTipoPessoa() {
        return this.pessoaService.recuperarTipoPessoa();
    }

}
