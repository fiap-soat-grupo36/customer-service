package br.com.fiap.oficina.customer.mapper;

import br.com.fiap.oficina.customer.dto.request.ClienteRequestDTO;
import br.com.fiap.oficina.customer.dto.response.ClienteResponseDTO;
import br.com.fiap.oficina.customer.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-18T13:44:58-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260128-0750, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteResponseDTO toDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

        clienteResponseDTO.setAtivo( cliente.getAtivo() );
        clienteResponseDTO.setCnpj( cliente.getCnpj() );
        clienteResponseDTO.setCpf( cliente.getCpf() );
        clienteResponseDTO.setDataCadastro( cliente.getDataCadastro() );
        clienteResponseDTO.setDataNascimento( cliente.getDataNascimento() );
        clienteResponseDTO.setEmail( cliente.getEmail() );
        clienteResponseDTO.setEndereco( cliente.getEndereco() );
        clienteResponseDTO.setId( cliente.getId() );
        clienteResponseDTO.setNome( cliente.getNome() );
        clienteResponseDTO.setObservacao( cliente.getObservacao() );
        clienteResponseDTO.setTelefone( cliente.getTelefone() );

        return clienteResponseDTO;
    }

    @Override
    public Cliente toEntity(ClienteRequestDTO clienteResponseDTO) {
        if ( clienteResponseDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCnpj( clienteResponseDTO.getCnpj() );
        cliente.setCpf( clienteResponseDTO.getCpf() );
        cliente.setDataNascimento( clienteResponseDTO.getDataNascimento() );
        cliente.setEmail( clienteResponseDTO.getEmail() );
        cliente.setEndereco( clienteResponseDTO.getEndereco() );
        cliente.setNome( clienteResponseDTO.getNome() );
        cliente.setObservacao( clienteResponseDTO.getObservacao() );
        cliente.setTelefone( clienteResponseDTO.getTelefone() );

        return cliente;
    }

    @Override
    public List<ClienteResponseDTO> toDTO(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteResponseDTO> list = new ArrayList<ClienteResponseDTO>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( toDTO( cliente ) );
        }

        return list;
    }

    @Override
    public List<Cliente> toEntity(List<ClienteResponseDTO> clientesDTO) {
        if ( clientesDTO == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( clientesDTO.size() );
        for ( ClienteResponseDTO clienteResponseDTO : clientesDTO ) {
            list.add( clienteResponseDTOToCliente( clienteResponseDTO ) );
        }

        return list;
    }

    protected Cliente clienteResponseDTOToCliente(ClienteResponseDTO clienteResponseDTO) {
        if ( clienteResponseDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setAtivo( clienteResponseDTO.getAtivo() );
        cliente.setCnpj( clienteResponseDTO.getCnpj() );
        cliente.setCpf( clienteResponseDTO.getCpf() );
        cliente.setDataCadastro( clienteResponseDTO.getDataCadastro() );
        cliente.setDataNascimento( clienteResponseDTO.getDataNascimento() );
        cliente.setEmail( clienteResponseDTO.getEmail() );
        cliente.setEndereco( clienteResponseDTO.getEndereco() );
        cliente.setId( clienteResponseDTO.getId() );
        cliente.setNome( clienteResponseDTO.getNome() );
        cliente.setObservacao( clienteResponseDTO.getObservacao() );
        cliente.setTelefone( clienteResponseDTO.getTelefone() );

        return cliente;
    }
}
