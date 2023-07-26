package sfpd.controller;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sfpd.dto.ArquivoDto;
import sfpd.dto.RotinaDto;
import sfpd.modelo.Arquivo;
import sfpd.modelo.ArquivosLinhas;
import sfpd.service.ArquivoService;
import sfpd.service.ContagemAcessosService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/arquivo/")
@CrossOrigin(origins = "*")
public class ArquivoController {

    @Autowired
    public ArquivoService arquivoService;

    @Autowired
    private ContagemAcessosService contagemAcessosService;

    @Autowired
    private ArquivoDto arquivoDto;

    private List<String> atributos = new ArrayList<String>();

    @ApiOperation(value = "Retorna a lista de arquivos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "lista de arquivos retornados"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Foi lançada uma exceção nesta rota")
    })
    @Timed(value = "arquivos.obterArquivos.time", description = "Tempo gasto para retornar os arquivos listados")
    @GetMapping(value = "obterArquivos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> obterArquivos()
    {
        List<Arquivo> arquivos = this.arquivoService.listarArquivos();

        if(arquivos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(arquivoDto.arquivosOutputDto(arquivos));
    }

    @ApiOperation(value = "Retorna espaço em disco livre")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "tamanho em disco retornado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Foi lançada uma exceção nesta rota")
    })
    @GetMapping(value = "obterEspacoDisco", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterEspacoDisco()
    {
        Double espacoDisco = this.arquivoService.obterEspacoDisco();

        return ResponseEntity.ok(espacoDisco);
    }

    @ApiOperation(value = "Retorna total de arquivos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "total de arquivos retornado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Foi lançada uma exceção nesta rota")
    })
    @GetMapping(value = "obterTotalArquivos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterTotalArquivos()
    {
        Integer totalArquivos = this.arquivoService.obterTotalArquivos();

        return ResponseEntity.ok(totalArquivos);
    }

    @ApiOperation(value = "Retorna total de downloads efetuados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "total de downloads retornado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Foi lançada uma exceção nesta rota")
    })
    @GetMapping(value = "obterTotalDownloads", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterTotalDownloads()
    {
        Integer totalDownloads = null;

        try {
                totalDownloads = this.contagemAcessosService.obterContadorRegistrado("countDownloads");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(totalDownloads);
    }

    @ApiOperation(value = "Retorna total de rotinas efetuadas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "total de rotinas retornado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Foi lançada uma exceção nesta rota")
    })
    @GetMapping(value = "obterTotalRotinasDisparadas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterTotalRotinasDisparadas()
    {
        Integer totalRotinas = null;

        try {

            totalRotinas = this.contagemAcessosService.obterContadorRegistrado("countRotina");

        } catch (Exception e) {
            e.printStackTrace();
        }

            return ResponseEntity.ok(totalRotinas);
    }

    @ApiOperation(value = "Retorna total de arquivos anual")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "total de arquivos anual retornado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Foi lançada uma exceção nesta rota")
    })
    @GetMapping(value = "obterTotalArquivosAnual", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterTotalArquivosAnual()
    {
        HashMap<Integer, List> totalAnual = null;

        try {

            totalAnual = this.contagemAcessosService.obterTotalArquivosAnual();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(totalAnual);
    }

    @ApiOperation(value = "Registra execucao rotina")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "status retornado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Foi lançada uma exceção nesta rota")
    })
    @GetMapping(value = "registrarExecucaoRotina", produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed(value = "arquivos.obterArquivos.time", description = "Tempo gasto para registrar execução da rotina")
    public ResponseEntity<RotinaDto> registrarExecucaoRotina()
    {
        // rotina iniciada/executada pelo producer python, este metodo somente caontabiliza as execucoes
        this.contagemAcessosService.registrarAcesso("countRotina");

        // seta dto default output
        RotinaDto rotinaDto = new RotinaDto();

        rotinaDto.setData(new Date());
        rotinaDto.setExecutado(true);
        rotinaDto.setStatus("registrado...");

        return ResponseEntity.ok(rotinaDto);
    }

    @ApiOperation(value = "Realiza download do arquivo gerado")
    @GetMapping(value = "downloadArquivo/{id}")
    @Timed(value = "arquivos.obterArquivos.time", description = "Tempo Médio gasto para gerar arquivo fisico para download")
    public void gerarArquivoCSV(HttpServletResponse response, @PathVariable(value = "id") Long idArquivo) {

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            // registros cadastrados
            List<ArquivosLinhas> linhas = this.arquivoService.obterLinhasArquivo(idArquivo);

            // contagem downloads
            this.contagemAcessosService.registrarAcesso("countDownloads");

            List<String[]> dataLines = new ArrayList<>();

            for(ArquivosLinhas linha: linhas)
            {
                // percorre atributos
                String str = tratarStringJson(linha.getLinha());
                String[] attrs = str.split(",");

                for (String attr: attrs)
                {
                    String[] atributo = attr.split(":");
                    String atributoChave = atributo[0];
                    String atributoValor = atributo[1];

                    this.atributos.add(atributoChave);
                    this.atributos.add(atributoValor);
                }

                String[] el = this.atributos.toArray(new String[this.atributos.size()]);
                dataLines.add(el);
                this.atributos.clear();
            }

            StringBuilder sb = new StringBuilder();

            for(String[] s : dataLines) { sb.append(convertToCSV(s)); }

            new DataOutputStream(byteArrayOutputStream).write(String.valueOf(sb).getBytes());
            byteArrayOutputStream.flush();

            response.setHeader("Content-Disposition", "attachment; filename=teste.csv");
            response.setContentType("text/csv");
            response.getOutputStream().write(byteArrayOutputStream.toByteArray());
            response.flushBuffer();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(";")) + "\n";
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public static String tratarStringJson(String str)
    {
        str = str.substring(1, str.length() - 1);
        str = str.replace("'", "");

        return str;
    }
}
