package br.com.quintinodigital.sisgerpesapi.controller;

import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import br.com.quintinodigital.sisgerpesapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaModel saveOne(@RequestBody PessoaModel pessoaModel) {
        return this.pessoaService.saveOne(pessoaModel);
    }

    @GetMapping
    public List<PessoaModel> findAll() {
        return this.pessoaService.findAll();
    }

    @GetMapping("/{codigo}")
    public PessoaModel findOne(@PathVariable("codigo") Long codigo) {
        return this.pessoaService.findOne(codigo);
    }

    @PutMapping("/{codigo}")
    public PessoaModel updateOne(@RequestBody PessoaModel pessoaModel, @PathVariable("codigo") Long codigo) {
        pessoaModel.setCodigo(codigo);
        return this.pessoaService.updateOne(pessoaModel);
    }

    @DeleteMapping("/{codigo}")
    public void deleteOne(@PathVariable("codigo") Long codigo) {
        this.pessoaService.deleteOne(codigo);
    }

}
