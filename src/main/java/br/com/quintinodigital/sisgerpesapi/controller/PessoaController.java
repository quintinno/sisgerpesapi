package br.com.quintinodigital.sisgerpesapi.controller;

import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import br.com.quintinodigital.sisgerpesapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    private PessoaModel saveOne(@RequestBody PessoaModel pessoaModel) {
        return this.pessoaService.saveOne(pessoaModel);
    }

}
