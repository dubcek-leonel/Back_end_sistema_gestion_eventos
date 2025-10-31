package org.example.sis_eventos.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.sis_eventos.dto.UsersDTO;
import org.example.sis_eventos.entity.UsersEntity;
import org.example.sis_eventos.mapper.UsersMapper;
import org.example.sis_eventos.repository.UsersRepository;
import org.example.sis_eventos.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;



    @Override
    public List<UsersDTO> findAll() {
        return usersMapper.UsersEntitiesToUsersDTOs(usersRepository.findAll());
    }

    @Override
    public UsersDTO findById(Long id) {
        UsersEntity usersEntity = usersRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found"));
        return usersMapper.UsersEntityToUsersDTO(usersEntity);
    }

    @Override
    public UsersDTO save(UsersDTO usersDTO) {
        UsersEntity usersEntity = usersMapper.UsersDTOToUsersEntity(usersDTO);

        return usersMapper.UsersEntityToUsersDTO(usersRepository.save(usersEntity));
    }

    @Override
    public UsersDTO update(Long id, UsersDTO usersDTO) {

        Optional<UsersEntity> usersEntity =
                Optional.ofNullable(usersRepository.findById(id).orElseThrow(()->
                        new RuntimeException("User not found")));
        UsersEntity updatedUsersEntity = new UsersEntity();
        if (usersEntity.isPresent()) {
            usersEntity.get().setEmail(usersDTO.getEmail());
            usersEntity.get().setStudentCode(usersDTO.getStudentCode());
            usersEntity.get().setFullName(usersDTO.getFullName());
            usersEntity.get().setRole(usersDTO.getRole());
            usersEntity.get().setId(id);
            usersEntity.get().setPhone(usersDTO.getPhone());
            usersEntity.get().setCareer(usersDTO.getCareer());
            usersEntity.get().setSemmester(usersDTO.getSemmester());
            usersEntity.get().setProfileImage(usersDTO.getProfileImage());
            usersEntity.get().setActive(usersDTO.isActive());


            updatedUsersEntity = usersRepository.save(usersEntity.get());
        }




        return usersMapper.UsersEntityToUsersDTO(updatedUsersEntity);
    }

    @Override
    public void delete(Long id) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
        }else  {
            throw new RuntimeException("User not found");
        }
    }
}
