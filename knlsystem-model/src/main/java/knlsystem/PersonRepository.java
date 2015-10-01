package knlsystem;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByPerId(Integer perId);

    List<Person> findByEmail(String email);

    @Override
    Page<Person> findAll(Pageable pageable);

    //findByNameContainingAndCountryContainingAllIgnoringCase
    List<Person> findByfirstNameContainingAndLastNameContainingAllIgnoringCase(String firstName, String lastName);
}
