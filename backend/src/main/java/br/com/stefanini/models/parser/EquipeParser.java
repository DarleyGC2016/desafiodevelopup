package br.com.stefanini.models.parser;

import br.com.stefanini.dto.EquipeDTO;
import br.com.stefanini.models.Equipe;

public class EquipeParser {
       
      public static EquipeParser get() {
        return new EquipeParser();
      }

      public Equipe entity(EquipeDTO  dto) {
          Equipe equipe = new Equipe();
         // equipe.setId(dto.getId());
          equipe.setNome(dto.getNome());
          return equipe;
      }
      
      public Equipe editarEntity(EquipeDTO  dto) {
          Equipe equipe = new Equipe();
          equipe.setId(dto.getId());
          equipe.setNome(dto.getNome());
          return equipe;
      }

      public EquipeDTO dto(Equipe  equipe) {
        EquipeDTO equipeDTO = new EquipeDTO();
        equipeDTO.setId(equipe.getId());
        equipeDTO.setNome(equipe.getNome());
        return equipeDTO;
    }

}
