package cloud.ansel.web.mapper;

import org.mapstruct.Mapper;

import cloud.ansel.model.User;
import cloud.ansel.web.to.UserTO;

@Mapper
public interface UserMapper {

    UserTO to(User source);
}
