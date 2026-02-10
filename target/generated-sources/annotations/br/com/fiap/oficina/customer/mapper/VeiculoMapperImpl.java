package br.com.fiap.oficina.customer.mapper;

import br.com.fiap.oficina.customer.dto.request.VeiculoRequesDTO;
import br.com.fiap.oficina.customer.dto.response.VeiculoResponseDTO;
import br.com.fiap.oficina.customer.entity.Cliente;
import br.com.fiap.oficina.customer.entity.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-18T13:07:47-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260128-0750, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class VeiculoMapperImpl implements VeiculoMapper {

    @Override
    public VeiculoResponseDTO toDTO(Veiculo veiculo) {
        if ( veiculo == null ) {
            return null;
        }

        VeiculoResponseDTO veiculoResponseDTO = new VeiculoResponseDTO();

        veiculoResponseDTO.setClienteId( veiculoClienteId( veiculo ) );
        veiculoResponseDTO.setAno( veiculo.getAno() );
        veiculoResponseDTO.setAtivo( veiculo.getAtivo() );
        veiculoResponseDTO.setCor( veiculo.getCor() );
        veiculoResponseDTO.setId( veiculo.getId() );
        veiculoResponseDTO.setMarca( veiculo.getMarca() );
        veiculoResponseDTO.setModelo( veiculo.getModelo() );
        veiculoResponseDTO.setObservacoes( veiculo.getObservacoes() );
        veiculoResponseDTO.setPlaca( veiculo.getPlaca() );

        return veiculoResponseDTO;
    }

    @Override
    public Veiculo toEntity(VeiculoRequesDTO veiculoResponseDTO) {
        if ( veiculoResponseDTO == null ) {
            return null;
        }

        Veiculo veiculo = new Veiculo();

        veiculo.setAno( veiculoResponseDTO.getAno() );
        veiculo.setCor( veiculoResponseDTO.getCor() );
        veiculo.setMarca( veiculoResponseDTO.getMarca() );
        veiculo.setModelo( veiculoResponseDTO.getModelo() );
        veiculo.setObservacoes( veiculoResponseDTO.getObservacoes() );
        veiculo.setPlaca( veiculoResponseDTO.getPlaca() );

        return veiculo;
    }

    @Override
    public List<VeiculoResponseDTO> toDTOList(List<Veiculo> veiculos) {
        if ( veiculos == null ) {
            return null;
        }

        List<VeiculoResponseDTO> list = new ArrayList<VeiculoResponseDTO>( veiculos.size() );
        for ( Veiculo veiculo : veiculos ) {
            list.add( toDTO( veiculo ) );
        }

        return list;
    }

    private Long veiculoClienteId(Veiculo veiculo) {
        if ( veiculo == null ) {
            return null;
        }
        Cliente cliente = veiculo.getCliente();
        if ( cliente == null ) {
            return null;
        }
        Long id = cliente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
