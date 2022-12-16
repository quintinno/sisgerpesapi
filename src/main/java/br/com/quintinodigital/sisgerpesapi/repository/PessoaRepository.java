package br.com.quintinodigital.sisgerpesapi.repository;

import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> { }
