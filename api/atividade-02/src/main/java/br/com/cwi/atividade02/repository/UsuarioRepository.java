package br.com.cwi.atividade02.repository;

import br.com.cwi.atividade02.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByIdIsNotAndNomeContainingIgnoreCaseOrIdIsNotAndEmailContainingIgnoreCase(Long id, String nome, Long id2, String email);

    List<Usuario> findByNomeContainingOrEmailContainingAllIgnoreCase (String nome, String email);

    boolean existsByEmail(String email);
}
