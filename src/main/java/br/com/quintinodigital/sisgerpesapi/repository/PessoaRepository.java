package br.com.quintinodigital.sisgerpesapi.repository;

import br.com.quintinodigital.sisgerpesapi.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> { }
