package spring.study.springrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.springrest.models.Person;
import spring.study.springrest.service.PeopleService;
import spring.study.springrest.util.PersonErrorResponse;

import java.util.List;

/**
 * @author Neil Alishev
 */
@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return peopleService.findAll(); // Jackson конвертирует эти объекты в JSON
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findOne(id); // Jackson конвертирует в JSON
    }
    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException() {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id wasn't found",
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // 404 
    }
}