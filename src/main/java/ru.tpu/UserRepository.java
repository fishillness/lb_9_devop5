package ru.tpu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // создает бин модель (бин - синглтон)
public interface UserRepository extends JpaRepository<User, Integer> { //юзер - полу4аемьй объект из бд,  а инт - тиип данньх клю4а

}
