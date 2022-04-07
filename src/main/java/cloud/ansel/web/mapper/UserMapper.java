package cloud.ansel.web.mapper;

import org.mapstruct.Mapper;

import cloud.ansel.model.User;
import cloud.ansel.web.dto.UserDTO;

@Mapper
public interface UserMapper {

    UserDTO to(User source);
}
