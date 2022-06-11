package br.com.smr.SmartRecyclingManagement.service;

import br.com.smr.SmartRecyclingManagement.controller.dto.*;
import br.com.smr.SmartRecyclingManagement.domain.*;
import br.com.smr.SmartRecyclingManagement.repository.ListaCompraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaCompraService {

    private final ListaCompraRepository listaCompraRepository;
    private final ProdutoService produtoService;
    private final ProdutoListaCompraService produtoListaCompraService;
    private final ClienteService clienteService;

    static int totalItens;
    static Long plastico;
    static Long metal;
    static Long papel;
    static Long vidro;
    static Long organico;
    static Long naoReciclavel;
    static Double valorTotal;
    static Double pesoPlastico;
    static Double pesoMetal;
    static Double pesoPapel;
    static Double pesoVidro;
    static Double pesoOrganico;
    static Double pesoNaoReciclavel;
    static Double pesoTotal;
    static Double pesoTotalLiquido;

    public ListaCompraService(ListaCompraRepository listaCompraRepository, ProdutoService produtoService, ProdutoListaCompraService produtoListaCompraService, ClienteService clienteService) {
        this.listaCompraRepository = listaCompraRepository;
        this.produtoService = produtoService;
        this.produtoListaCompraService = produtoListaCompraService;
        this.clienteService = clienteService;
    }

    public Optional<ListaCompra> save(ListaCompraDTO dto, String email){

        ListaCompra listaCompra = new ListaCompra();
        listaCompra.setNome(dto.getNome());
        listaCompra.setDescricao(dto.getDescricao());
        listaCompra.setDataCompra(dto.getDataCompra());
        listaCompra.setDataCadastro(dto.getDataCadastro());
        listaCompra.setTipo(dto.getTipo());

        //Busca no banco de dados o cliente vinculado a esse email
        Cliente clienteEmail = clienteService.findByEmail(email);

        //Define o id do cliente encontrado
        Cliente cliente = new Cliente();
        cliente.setId(clienteEmail.getId());

        //Adiciona o id do cliente a lista de compras
        listaCompra.setCliente(cliente);

        //Salva a lista de compras
        ListaCompra listaCompraSalva = listaCompraRepository.save(listaCompra);

        //Vai salvar todos os itens da lista de compras
        dto.getProdutosId().forEach(produtoId -> {
            Optional<ProdutoDTO> produtoResult = produtoService.findById(produtoId).map(ProdutoDTO::new);
            if (produtoResult.isPresent()) {
                produtoResult.get().setListaCompraId(listaCompraSalva.getId());
                produtoListaCompraService.save(produtoResult.get());
            }
        });
        return listaCompraRepository.findById(listaCompra.getId());
    }

    public ListaCompra update(ListaCompraDTO dto, Long id){
        ListaCompra listaCompraUpdate = listaCompraRepository.getById(id);
        listaCompraUpdate.setNome(dto.getNome());
        listaCompraUpdate.setDescricao(dto.getDescricao());
        listaCompraUpdate.setDataCompra(dto.getDataCompra());
        listaCompraUpdate.setDataCadastro(dto.getDataCadastro());
        listaCompraUpdate.setTipo(dto.getTipo());
        return listaCompraRepository.save(listaCompraUpdate);
    }

    public List<ListaCompraDTO> findAllByClienteId(Long id){

        return listaCompraRepository.findAllByClienteId(id).stream().map(ListaCompraDTO::new).collect(Collectors.toList());
    }
    public Optional<ListaCompraDTO> findById(Long id){
        return listaCompraRepository.findById(id).map(ListaCompraDTO::new);
    }

    public List<ListaCompra> findAll(){
        return listaCompraRepository.findAll();
    }

    public void delete(Long id){
        listaCompraRepository.deleteById(id);
    }

    public ConsumoMensalDTO findConsumoMensal(Long id) {
        //Reset da variavel totalItens
        totalItens = 0;
        plastico = 0L;
        metal = 0L;
        papel = 0L;
        vidro = 0L;
        organico = 0L;
        naoReciclavel = 0L;
        valorTotal = 0.0;

        List<ListaCompra> listaCompras = findListaCompraById(id);

        ConsumoMensalDTO consumoMensalDTO = new ConsumoMensalDTO();

        if (listaCompras.size() > 0) {

            listaCompras.forEach(listaCompra -> {

                Optional<ListaCompra> comprasLista = listaCompraRepository.findById(listaCompra.getId());
                if (comprasLista.isPresent()) {

                    //Soma a quantidade total de itens do mes
                    totalItens = totalItens + comprasLista.get().getProdutos().size();

                    //Filtro para verificar se os tipos de produtos recicláveis
                    plastico = plastico + comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.PLASTICO)).count();
                    metal = metal + comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.METAL)).count();
                    papel = papel + comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.PAPEL)).count();
                    vidro = vidro + comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.VIDRO)).count();
                    organico = organico + comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.ORGANICO)).count();
                    naoReciclavel = naoReciclavel + comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.NAO_RECICLAVEL)).count();
                    //Soma o valor total da lista de compras
                    comprasLista.get().getProdutos().forEach(item -> {
                        valorTotal = valorTotal + item.getPreco();
                    });
                }
            });

            consumoMensalDTO.setPlastico(porcentagemList(plastico));
            consumoMensalDTO.setMetal(porcentagemList(metal));
            consumoMensalDTO.setOrganico(porcentagemList(organico));
            consumoMensalDTO.setPapel(porcentagemList(papel));
            consumoMensalDTO.setVidro(porcentagemList(vidro));
            consumoMensalDTO.setNaoReciclavel(porcentagemList(naoReciclavel));
            consumoMensalDTO.setGastoMensal(valorTotal);
        }
        return consumoMensalDTO;
    }

    public Double porcentagemList(Long item){

        Double porcentagem = Double.valueOf((item * 100) / totalItens);

        return porcentagem;
    }

    public List<ListaCompra> findListaCompraById(Long id){
        LocalDate dataHoje = LocalDate.now();
        List<ListaCompra> clienteLista = listaCompraRepository.findAllByClienteId(id);

        //Filtra somente a lista de compras do mês atual
        return clienteLista.stream().filter(listaCompra -> listaCompra.getDataCompra().getMonth().equals(dataHoje.getMonth())).collect(Collectors.toList());
    }
    public ConsumoMensalPesoDTO findConsumoMensalPeso(Long id) {
        //Reset da variavel totalItens
        pesoPlastico = 0.0;
        pesoMetal = 0.0;
        pesoPapel = 0.0;
        pesoVidro = 0.0;
        pesoOrganico = 0.0;
        pesoNaoReciclavel = 0.0;
        pesoTotal = 0.0;
        pesoTotalLiquido = 0.0;

        List<ListaCompra> listaCompras = findListaCompraById(id);

        ConsumoMensalPesoDTO consumoMensalPesoDTO = new ConsumoMensalPesoDTO();

        if (listaCompras.size() > 0) {

            listaCompras.forEach(listaCompra -> {

                Optional<ListaCompra> comprasLista = listaCompraRepository.findById(listaCompra.getId());
                if (comprasLista.isPresent()) {

                    //Filtro para verificar se os tipos de produtos recicláveis
                    comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.PLASTICO)).forEach(item -> {
                        pesoPlastico = pesoPlastico + item.getPesoEmbalagem();
                        pesoTotal = pesoTotal + item.getPesoBruto();
                        pesoTotalLiquido = pesoTotalLiquido + item.getPesoLiquido();
                    });
                    comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.METAL)).forEach(item -> {
                        pesoMetal = pesoMetal + item.getPesoEmbalagem();
                        pesoTotal = pesoTotal + item.getPesoBruto();
                        pesoTotalLiquido = pesoTotalLiquido + item.getPesoLiquido();
                    });
                    comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.PAPEL)).forEach(item -> {
                        pesoPapel = pesoPapel + item.getPesoEmbalagem();
                        pesoTotal = pesoTotal + item.getPesoBruto();
                        pesoTotalLiquido = pesoTotalLiquido + item.getPesoLiquido();
                    });
                    comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.VIDRO)).forEach(item -> {
                        pesoVidro = pesoVidro + item.getPesoEmbalagem();
                        pesoTotal = pesoTotal + item.getPesoBruto();
                        pesoTotalLiquido = pesoTotalLiquido + item.getPesoLiquido();
                    });
                    comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.ORGANICO)).forEach(item -> {
                        pesoOrganico = pesoOrganico + item.getPesoEmbalagem();
                        pesoTotal = pesoTotal + item.getPesoBruto();
                        pesoTotalLiquido = pesoTotalLiquido + item.getPesoLiquido();
                    });
                    comprasLista.get().getProdutos().stream().filter(item -> item.getTipoReciclagem().equals(TipoReciclagem.NAO_RECICLAVEL)).forEach(item -> {
                        pesoNaoReciclavel = pesoNaoReciclavel + item.getPesoEmbalagem();
                        pesoTotal = pesoTotal + item.getPesoBruto();
                        pesoTotalLiquido = pesoTotalLiquido + item.getPesoLiquido();
                    });

                    consumoMensalPesoDTO.setPesoMetal(pesoMetal);
                    consumoMensalPesoDTO.setPesoPlastico(pesoPlastico);
                    consumoMensalPesoDTO.setPesoPapel(pesoPapel);
                    consumoMensalPesoDTO.setPesoVidro(pesoVidro);
                    consumoMensalPesoDTO.setPesoOrganico(pesoOrganico);
                    consumoMensalPesoDTO.setPesoNaoReciclavel(pesoNaoReciclavel);
                    consumoMensalPesoDTO.setPesoTotalMensalEmbalagem(pesoMetal + pesoPlastico + pesoPapel + pesoVidro + pesoOrganico + pesoNaoReciclavel);
                    consumoMensalPesoDTO.setPesoTotalMensalLiquido(pesoTotalLiquido);
                    consumoMensalPesoDTO.setPesoTotal(pesoTotal);

                }
            });
        }
        return consumoMensalPesoDTO;
    }

}
