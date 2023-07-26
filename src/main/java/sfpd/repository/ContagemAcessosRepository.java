package sfpd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sfpd.modelo.Arquivo;
import sfpd.modelo.ContagemAcessos;

import java.util.List;

/**
 * @author marco.soares
 * @since July 05, 2023
 */
@Repository
public interface ContagemAcessosRepository extends PagingAndSortingRepository<ContagemAcessos, Long> {

    List<ContagemAcessos> findAll();

    @Query(value = "SELECT CA.* FROM contagem_acessos CA ORDER BY A.id DESC", nativeQuery = true)
    public List<Arquivo> findAllOrderByIdDesc();

    @Query(value = "SELECT CA.* FROM contagem_acessos CA WHERE CA.descricao = :descricao", nativeQuery = true)
    public ContagemAcessos obterContagemAcessos(@Param("descricao") String descricao);

    @Query(value = "SELECT COUNT(A.data) total FROM meses M LEFT JOIN arquivos A ON (M.mes = month(A.data)) WHERE YEAR(A.data) = :ano GROUP BY m.mes", nativeQuery = true)
    public List obterTotalArquivosAnual(@Param("ano") Integer ano);
}
