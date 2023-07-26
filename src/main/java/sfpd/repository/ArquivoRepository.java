package sfpd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sfpd.modelo.Arquivo;

import java.util.List;
import java.util.Optional;

/**
 * @author marco.soares
 * @since Marc 10, 2023
 */
@Repository
public interface ArquivoRepository extends PagingAndSortingRepository<Arquivo, Long> {

    List<Arquivo> findAll();

    @Query(value = "SELECT A.* FROM arquivos AS A ORDER BY A.id DESC", nativeQuery = true)
    public List<Arquivo> findAllOrderByIdDesc();

    @Query(value = "SELECT A.* FROM arquivos AS A INNER JOIN arquivos_linhas AL ON (A.id = AL.arquivoId) GROUP BY A.id ORDER BY A.id DESC", nativeQuery = true)
    public List<Arquivo> obterArquivosCadastrados();

    @Query("Select A from Arquivo as A order by A.id desc")
    public List<Arquivo> listarAnunciosNaoFechados();

    @Query(value = "SELECT A.* " +
            "FROM arquivos A " +
            "WHERE A.ID = :id", nativeQuery = true)
    public Optional<Arquivo> obterArquivo(@Param("id") Long id);
}
