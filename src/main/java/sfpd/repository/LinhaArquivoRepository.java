package sfpd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sfpd.modelo.Arquivo;
import sfpd.modelo.ArquivosLinhas;

import java.util.List;

/**
 * @author marco.soares
 * @since Marc 10, 2023
 */
@Repository
public interface LinhaArquivoRepository extends PagingAndSortingRepository<ArquivosLinhas, Long> {

    List<ArquivosLinhas> findAll();

    @Query("Select AL from ArquivosLinhas as AL order by AL.id desc")
    public List<ArquivosLinhas> findAllOrderByIdDesc();

    @Query("Select AL from ArquivosLinhas as AL order by AL.id desc")
    public List<ArquivosLinhas> listarAnunciosNaoFechados();

    @Query(value = "SELECT AL.* " +
            "FROM ArquivosLinhas AL " +
            "WHERE AL.ID = :id", nativeQuery = true)
    public Arquivo obterLinhaArquivo(@Param("id") Long id);

    @Query(value = "SELECT AL.* FROM arquivos_linhas AL INNER JOIN arquivos A ON A.id = AL.arquivoId " +
                   "WHERE A.ID = :id", nativeQuery = true)
    public List<ArquivosLinhas> obterLinhasArquivo(@Param("id") Long id);
}
