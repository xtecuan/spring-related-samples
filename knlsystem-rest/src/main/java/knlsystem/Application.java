// tag::runner[]
package knlsystem;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

  @Value("${db.driver}")
  private String driver;
  @Value("${db.username}")
  private String username;
  @Value("${db.password}")
  private String password;
  @Value("${db.url}")
  private String url;

  @Bean
  DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(this.driver);
    dataSource.setUsername(this.username);
    dataSource.setPassword(this.password);
    dataSource.setUrl(this.url);
    return dataSource;
  }

  // @Bean
  // CommandLineRunner init(AccountRepository accountRepository,
  // BookmarkRepository bookmarkRepository) {
  // return (evt) -> Arrays
  // .asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
  // .forEach(a -> {
  // Account account = accountRepository.save(new Account(a, "password"));
  // bookmarkRepository
  // .save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
  // bookmarkRepository
  // .save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
  // });
  // }
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
// end::runner[]


@RestController
@RequestMapping("/persons")
class PersonRestController {

  private final PersonRepository personRepository;

  @RequestMapping(method = RequestMethod.POST)
  ResponseEntity<?> add(@RequestBody Person input) {

    Person per = new Person();

    per.setFirstName(input.getFirstName());
    per.setLastName(input.getLastName());
    per.setMiddleName(input.getMiddleName());
    per.setType(input.getType());
    per.setEmail(input.getEmail());
    per.setEntryDate(new Date());
    per.setUpdatedDate(new Date());
    per.setActiveFlag(input.isActiveFlag());
    per.setGender(input.getGender());
    per.setMoodleUserId(input.getMoodleUserId());

    Person result = this.personRepository.save(per);

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{perId}")
        .buildAndExpand(result.getPerId()).toUri());
    httpHeaders.add("perId", result.getPerId().toString());
    return new ResponseEntity<>(result, httpHeaders, HttpStatus.CREATED);

    // return this.accountRepository.findByUsername(userId).map(account -> {
    // Bookmark result
    // = bookmarkRepository.save(new Bookmark(account, input.uri, input.description));
    //
    // HttpHeaders httpHeaders = new HttpHeaders();
    // httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    // .buildAndExpand(result.getId()).toUri());
    // return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    // }).get();
  }

  // @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET)
  // Bookmark readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
  // this.validateUser(userId);
  // return this.bookmarkRepository.findOne(bookmarkId);
  // }
  @RequestMapping(value = "/{perId}", method = RequestMethod.GET)
  Person readPerson(@PathVariable Integer perId) {
    this.validatePerson(perId);
    return this.personRepository.findOne(perId);
  }

  @RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
  List<Person> readByFirstNameAndLastName(@PathVariable String firstName,
      @PathVariable String lastName) {
    return this.personRepository
        .findByfirstNameContainingAndLastNameContainingAllIgnoringCase(firstName, lastName);
  }

  @RequestMapping(method = RequestMethod.GET)
  Page<Person> readAll(Pageable page) {
    return this.personRepository.findAll(page);
  }

  @Autowired
  PersonRestController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  private void validatePerson(Integer perId) {
    this.personRepository.findByPerId(perId).orElseThrow(() -> new PersonNotFoundException(perId));
  }
}


@ResponseStatus(HttpStatus.NOT_FOUND)
class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException(Integer perId) {
    super("could not find person with id: '" + perId + "'.");
  }
}
