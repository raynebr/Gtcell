package com.Sistema.Gtcell.Controller;

import com.Sistema.Gtcell.Dto.Request.CategoriaRequest;
import com.Sistema.Gtcell.Dto.Response.CategoriaResponse;
import com.Sistema.Gtcell.Entity.CategoriaEntity;
import com.Sistema.Gtcell.Service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Cadastrar categoria
    @PostMapping
    public ResponseEntity<CategoriaResponse> cadastrar(
            @RequestBody CategoriaRequest request) {

        CategoriaEntity categoria = new CategoriaEntity();

        categoria.setNome(request.nome());

        CategoriaEntity categoriaSalva =
                categoriaService.cadastrar(categoria);

        CategoriaResponse response = new CategoriaResponse(
                categoriaSalva.getId(),
                categoriaSalva.getNome()
        );

        return ResponseEntity.ok(response);
    }

    // Listar categorias
    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listar() {

        List<CategoriaResponse> response =
                categoriaService.listar()
                        .stream()
                        .map(categoria -> new CategoriaResponse(
                                categoria.getId(),
                                categoria.getNome()
                        ))
                        .toList();

        return ResponseEntity.ok(response);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscarPorId(
            @PathVariable UUID id) {

        CategoriaEntity categoria =
                categoriaService.buscarPorId(id);

        CategoriaResponse response = new CategoriaResponse(
                categoria.getId(),
                categoria.getNome()
        );

        return ResponseEntity.ok(response);
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> atualizar(
            @PathVariable UUID id,
            @RequestBody CategoriaRequest request) {

        CategoriaEntity categoria = new CategoriaEntity();

        categoria.setNome(request.nome());

        CategoriaEntity categoriaAtualizada =
                categoriaService.atualizar(id, categoria);

        CategoriaResponse response = new CategoriaResponse(
                categoriaAtualizada.getId(),
                categoriaAtualizada.getNome()
        );

        return ResponseEntity.ok(response);
    }

    // Excluir
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable UUID id) {

        categoriaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}