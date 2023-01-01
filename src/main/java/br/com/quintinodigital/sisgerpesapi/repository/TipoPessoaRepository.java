package br.com.quintinodigital.sisgerpesapi.repository;

import br.com.quintinodigital.sisgerpesapi.model.TipoPessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoaModel, UUID> { }
