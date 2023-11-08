package es.natalia.natminds.apiRest.dto;

import lombok.Data;

/*DTO para la funcionalidad de Partial Update (@PATCH)
 *
 * En este caso PostDtoPartialUpdate sólo tendrá el atributo text, ya que es lo único que nos podría interesar
 * modificar */
@Data
public class PostDtoPartialUpdate {
    private String text;
}
